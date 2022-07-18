package com.ocanades.demo.domain.services;

import com.ocanades.demo.domain.entities.User;
import com.ocanades.demo.domain.exceptions.UserException;

import java.util.List;

public interface UserService {

    List<User> getAllUsers() throws UserException;

    User getUserById(String id) throws UserException;

    void addUser(User user) throws UserException;

}
