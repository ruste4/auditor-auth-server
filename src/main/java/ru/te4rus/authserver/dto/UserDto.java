package ru.te4rus.authserver.dto;

import lombok.Data;

@Data
public class UserDto {

    private Long id;

    private String login;

    private String firstname;

    private String lastname;

}
