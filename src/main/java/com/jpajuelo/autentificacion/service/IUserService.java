package com.jpajuelo.autentificacion.service;

import com.jpajuelo.autentificacion.model.User;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    //Insert
    public User insertUser(User user);
    //Find
    public User findById(Long id);
    public Optional<User> findByDni(String dni);
    public List<User> findAllUser();
    //Delete
    public void deleteByDni(String dni);
    //Update
    public User UpdateUser(Long id, User user);
    
}
