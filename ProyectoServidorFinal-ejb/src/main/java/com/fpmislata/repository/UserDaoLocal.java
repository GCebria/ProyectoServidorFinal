/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.repository;

import com.fpmislata.domain.User;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Gerard
 */
@Local
public interface UserDaoLocal {

    List listUsers();

    void addUser(User user);

    void updateUser(User user);

    void deleteUser(User user);

    User findUserById(User user);

    User findUserByEmail(User user);

   
}
