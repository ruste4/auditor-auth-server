package ru.te4rus.authserver.dto;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
public class UserCreateDto {

    @NotNull
    @Max(50)
    @Min(4)
    private String login;

    @NotNull
    @Max(255)
    @Min(8)
    private String password;

    @Max(255)
    private String firstname;

    @Max(255)
    private String lastname;

}
