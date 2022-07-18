package com.ocanades.demo.application.controllers;

import com.ocanades.demo.application.dtos.UserDto;
import com.ocanades.demo.domain.entities.User;
import com.ocanades.demo.domain.exceptions.UserException;
import com.ocanades.demo.application.mappers.UserMapper;
import com.ocanades.demo.domain.services.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;

    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers() {
        try {
            List<UserDto> usersDto = new ArrayList<>();
            userService.getAllUsers().forEach(user -> usersDto.add(userMapper.convertToDto(user)));
            return new ResponseEntity<>(usersDto, HttpStatus.OK);
        } catch (UserException e) {
            log.error(e.getMessage());
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable String id) {
        try {
            UserDto userDto = userMapper.convertToDto(userService.getUserById(id));
            return new ResponseEntity<>(userDto, HttpStatus.OK);
        } catch (UserException e) {
            log.error(e.getMessage());
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @PostMapping
    public ResponseEntity<String> addUser(@Valid @RequestBody UserDto userDto) {
        try {
            User user = userMapper.convertToEntity(userDto);
            userService.addUser(user);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (UserException e) {
            log.error(e.getMessage());
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
