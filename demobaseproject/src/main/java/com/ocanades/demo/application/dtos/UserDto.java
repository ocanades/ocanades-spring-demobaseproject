package com.ocanades.demo.application.dtos;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.validation.constraints.NotBlank;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {

    @JsonProperty("id")
    @JsonAlias({"uuid"})
    private String id;

    @JsonProperty("first_name")
    @JsonAlias({"firstName"})
    @NotBlank(message = "first_name attribute is mandatory")
    private String firstName;

    @JsonProperty("last_name")
    @JsonAlias({"lastName"})
    @NotBlank(message = "last_name attribute is mandatory")
    private String lastName;

    @JsonProperty("email")
    @NotBlank(message = "email attribute is mandatory")
    private String email;

}
