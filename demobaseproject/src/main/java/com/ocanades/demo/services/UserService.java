package com.ocanades.demo.services;

import com.ocanades.demo.entities.User;
import com.ocanades.demo.exceptions.UserException;

import java.util.List;

public interface UserService {

    List<User> getAllUsers() throws UserException;

    User getUserById(String id) throws UserException;

    void addUser(User user) throws UserException;

}
