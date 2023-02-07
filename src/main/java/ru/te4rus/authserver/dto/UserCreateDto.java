package ru.te4rus.authserver.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

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
