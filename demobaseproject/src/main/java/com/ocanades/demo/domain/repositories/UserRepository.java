package com.ocanades.demo.domain.repositories;

import com.ocanades.demo.domain.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, String> {

    List<User> findAll();

    Optional<User> findById(String id);

    Optional<User> findByEmail(String email);

}
