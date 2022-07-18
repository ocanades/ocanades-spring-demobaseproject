package com.ocanades.demo.services;

import com.ocanades.demo.entities.User;
import com.ocanades.demo.exceptions.UserException;
import com.ocanades.demo.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public List<User> getAllUsers() throws UserException {
        List<User> users = userRepository.findAll();
        if (!users.isEmpty()) {
            return users;
        } else {
            throw new UserException("There are no users in the database");
        }
    }

    @Override
    public User getUserById(String id) throws UserException {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            return optionalUser.get();
        } else {
            throw new UserException("User does not exist");
        }
    }

    @Override
    public void addUser(User user) throws UserException {
        if (checkIfUserExists(user)) {
            throw new UserException("User cannot be created");
        } else {
            User newUser = User.builder()
                    .id(UUID.randomUUID().toString())
                    .firstName(user.getFirstName())
                    .lastName(user.getLastName())
                    .email(user.getEmail())
                    .build();
            saveUser(newUser);
        }
    }

    private boolean checkIfUserExists(User newUser) {
        Optional<User> optionalUser = userRepository.findByEmail(newUser.getEmail());
        return optionalUser.isPresent();
    }

    private void saveUser(User user) {
        userRepository.save(user);
    }

}
