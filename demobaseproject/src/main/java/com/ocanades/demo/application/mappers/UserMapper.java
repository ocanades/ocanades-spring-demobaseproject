package com.ocanades.demo.application.mappers;

import com.ocanades.demo.application.dtos.UserDto;
import com.ocanades.demo.domain.entities.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto convertToDto(User user);

    User convertToEntity(UserDto userDto);

}
