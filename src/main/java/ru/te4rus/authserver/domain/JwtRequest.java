package ru.te4rus.authserver.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class JwtRequest {

    private String login;
    private String password;

}
