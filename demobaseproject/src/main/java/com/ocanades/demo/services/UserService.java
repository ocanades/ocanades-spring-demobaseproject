package com.ocanades.demo.services;

import com.ocanades.demo.entities.User;

import java.util.List;
import java.util.NoSuchElementException;

public interface UserService {

    List<User> getAllUsers() throws NoSuchElementException;

}
