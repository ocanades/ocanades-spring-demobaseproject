package com.ocanades.demo.mappers;

import com.ocanades.demo.dtos.UserDto;
import com.ocanades.demo.entities.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto convertToDto(User user);

    User convertToEntity(UserDto userDto);

}
