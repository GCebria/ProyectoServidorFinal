/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.domain;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@NamedQueries ({@NamedQuery(name= "User.findAll", query = "select u from User u order by u.id")})
@Table(name="users")
public class User  implements Serializable{
    
    private static final long serialVersionUID = 1L; 
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_user")
    private int id;
    
    @Column(nullable = false, length = 45)
    private String nombre; 
    
    @Column(nullable = false, length = 45)
    private String password; 
    
    @Column(nullable = false, length = 45)
    private String email; 

    public User() {
    }

    public User(int id, String nombre, String password, String email) {
        this.id = id;
        this.nombre = nombre;
        this.password = password;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final User other = (User) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", nombre=" + nombre + ", password=" + password + ", email=" + email + '}';
    }
    
    
    
    
}
