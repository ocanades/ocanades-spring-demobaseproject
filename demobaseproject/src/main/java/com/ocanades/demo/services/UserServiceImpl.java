package com.ocanades.demo.services;

import com.ocanades.demo.entities.User;
import com.ocanades.demo.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public List<User> getAllUsers() throws NoSuchElementException {
        List<User> users = userRepository.findAll();
        if(!users.isEmpty()) {
            return users;
        } else {
            throw new NoSuchElementException();
        }
    }

}
