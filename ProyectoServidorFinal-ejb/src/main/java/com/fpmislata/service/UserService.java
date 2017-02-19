/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.service;

import com.fpmislata.domain.User;
import com.fpmislata.repository.UserDaoLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Gerard
 */
@Stateless
public class UserService implements UserServiceLocal {

    @EJB
    private UserDaoLocal userDao;

    @Override
    public List listUsers() {
        return userDao.listUsers();
    }

    @Override
    public void addUser(User user) {
        User u = userDao.findUserByEmail(user);
        if(u==null){
        userDao.addUser(user);
        }
        
    }

    @Override
    public void updateUser(User user) {
        userDao.addUser(user);
    }

    @Override
    public void deleteUser(User user) {
        userDao.deleteUser(user);
    }

    @Override
    public User findUserById(User user) {
        return userDao.findUserById(user);
    }
    
    
    
    
    
}
