package com.pap.respositories.impl;
import com.pap.pojo.User;
import com.pap.respositories.UserRespository;
import jakarta.data.repository.Repository;
import jakarta.persistence.Query;
import java.util.List;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.Transactional;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author admin
 */
@Repository
@Transactional
public class UserRespositoryImpl implements UserRespository {

    @Autowired
    private LocalSessionFactoryBean factory;

    @Override
    public void addUser(User user) {
        Session s = factory.getObject().getCurrentSession();
        s.persist(user);
    }

    @Override
    public List<User> getUsers(String username) {
        Session s = factory.getObject().getCurrentSession();
        Query q = s.createQuery("FROM User", User.class);
        return q.getResultList();
    }
}
