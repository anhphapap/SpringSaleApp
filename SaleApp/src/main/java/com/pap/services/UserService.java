/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pap.services;
import com.pap.pojo.User;
import org.springframework.security.core.userdetails.UserDetailsService;
/**
 *
 * @author admin
 */
public interface UserService extends UserDetailsService{
    void addUser(User user);
    User getUserByUsername(String username);
}
