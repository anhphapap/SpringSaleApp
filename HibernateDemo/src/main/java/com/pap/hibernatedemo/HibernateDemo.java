/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.pap.hibernatedemo;

import com.pap.respositories.impl.CategoryResositoryImpl;
import com.pap.respositories.impl.ProductRespositoryImpl;
import com.pap.respositories.impl.StatsRespositoryImpl;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author admin
 */
public class HibernateDemo {

    public static void main(String[] args) {
//        CategoryResositoryImpl s = new CategoryResositoryImpl();
//        s.getCategories().forEach(c -> System.err.println(c.getName()));
//        Map<String, String> params = new HashMap<>();
//        params.put("kw", "iPhone");
//        ProductRespositoryImpl s = new ProductRespositoryImpl();
//        s.getProducts(null).forEach(c -> System.out.printf("%d - %s - %.1f \n", c.getId(), c.getName(), c.getPrice()));
          StatsRespositoryImpl s = new StatsRespositoryImpl();
          s.statsRevenueByProduct().forEach(c -> System.out.printf("%d - %s : %d\n", c[0], c[1], c[2]));
          s.statsRevenueByTime("QUARTER", 2020).forEach(c -> System.out.printf("%d : %d\n", c[0], c[1]));

    }
}
