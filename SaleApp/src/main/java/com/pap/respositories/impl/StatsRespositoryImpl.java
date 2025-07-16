package com.pap.respositories.impl;

import com.pap.pojo.OrderDetail;
import com.pap.pojo.Product;
import com.pap.pojo.SaleOrder;
import com.pap.respositories.StatsRespository;
import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Root;
import java.util.List;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author admin
 */
@Repository
@Transactional
public class StatsRespositoryImpl implements StatsRespository {

    @Autowired
    private LocalSessionFactoryBean factory;

    @Override
    public List<Object[]> statsRevenueByProduct() {
        Session s = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);
        Root r = q.from(OrderDetail.class);
        Join<OrderDetail, Product> join = r.join("productId");

        q.multiselect(join.get("id"), join.get("name"),
                b.sum(b.prod(r.get("quantity"), r.get("unitPrice"))));
        q.groupBy(join.get("id"));

        Query query = s.createQuery(q);
        return query.getResultList();

    }

    @Override
    public List<Object[]> statsRevenueByTime(String time, int year) {
        Session s = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);
        Root r = q.from(OrderDetail.class);
        Join<OrderDetail, SaleOrder> join = r.join("orderId");

        q.multiselect(b.function(time, Integer.class, join.get("createdDate")),
                b.sum(b.prod(r.get("quantity"), r.get("unitPrice"))));
        q.where(b.equal(b.function("YEAR", Integer.class, join.get("createdDate")), year));
        q.groupBy(b.function(time, Integer.class, join.get("createdDate")));

        Query query = s.createQuery(q);
        return query.getResultList();

    }
}