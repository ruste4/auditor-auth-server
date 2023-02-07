package ru.te4rus.authserver.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.te4rus.authserver.domain.JwtAuthentication;
import ru.te4rus.authserver.dto.UserCreateDto;
import ru.te4rus.authserver.dto.UserDto;
import ru.te4rus.authserver.dto.UserUpdateDto;
import ru.te4rus.authserver.manager.UserApiManager;
import ru.te4rus.authserver.service.AuthService;

@Controller
@RequestMapping("api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserApiManager userApiManager;
    private final AuthService authService;

    @PostMapping("/registration")
    public ResponseEntity<UserDto> add(@RequestBody UserCreateDto createDto) {
        return ResponseEntity.ok(userApiManager.add(createDto));
    }

    @PatchMapping
    public ResponseEntity<UserDto> update(@RequestBody UserUpdateDto updateDto) {
        JwtAuthentication authInfo = authService.getAuthInfo();
        return  ResponseEntity.ok(userApiManager.update(updateDto, authInfo));
    }

}
