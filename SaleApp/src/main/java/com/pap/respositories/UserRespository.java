package com.pap.respositories;


import com.pap.pojo.User;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author admin
 */
public interface UserRespository {
    void addUser(User user);
    List<User> getUsers(String username);
}
