/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.repository;

import com.fpmislata.domain.User;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Gerard
 */
@Stateless
public class UserDao implements UserDaoLocal {

    @PersistenceContext(unitName="MusicPU")
    EntityManager em;
    
    
    @Override
    public List listUsers() {
        return em.createNamedQuery("User.findAll").getResultList();
    }

    @Override
    public void addUser(User user) {
        em.persist(user);
    }

    @Override
    public void updateUser(User user) {
        em.merge(user);
    }

    @Override
    public void deleteUser(User user) {
        em.remove(user);
    }

    @Override
    public User findUserById(User user) {
        return em.find(User.class, user.getId());
    }

    @Override
    public User findUserByEmail(User user) {
        Query query = em.createQuery("from User u where u.email = :email");
        query.setParameter("email", user.getEmail());
        try{
            return (User) query.getSingleResult();
        }catch (NoResultException nre){
         return null;
        }catch(NonUniqueResultException nur){
            return (User)query.getResultList().get(0);
        }
    }

    
    
    
}
