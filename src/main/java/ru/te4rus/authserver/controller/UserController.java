package ru.te4rus.authserver.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.te4rus.authserver.domain.JwtAuthentication;
import ru.te4rus.authserver.domain.User;
import ru.te4rus.authserver.service.AuthService;
import ru.te4rus.authserver.service.UserService;

@Controller
@RequestMapping("api/")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final AuthService authService;

    @PostMapping("registration")
    public ResponseEntity<User> add(@RequestBody User user) {
        return ResponseEntity.ok(userService.add(user));
    }

    @PatchMapping("/users")
    public ResponseEntity<User> update(@RequestBody User user) {
        JwtAuthentication authInfo = authService.getAuthInfo();
        return  ResponseEntity.ok(userService.update(user, authInfo));
    }

}
