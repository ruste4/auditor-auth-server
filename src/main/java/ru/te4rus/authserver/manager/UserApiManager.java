package ru.te4rus.authserver.manager;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ru.te4rus.authserver.domain.JwtAuthentication;
import ru.te4rus.authserver.domain.User;
import ru.te4rus.authserver.dto.UserCreateDto;
import ru.te4rus.authserver.dto.UserDto;
import ru.te4rus.authserver.dto.UserMapper;
import ru.te4rus.authserver.dto.UserUpdateDto;
import ru.te4rus.authserver.service.UserService;

@Slf4j
@Component
@RequiredArgsConstructor
public class UserApiManager {

    private final UserService userService;

    public UserDto add(UserCreateDto createDto) {
        log.debug(String.format("Добавление нового пользователя: %s", createDto));
        User user = UserMapper.toUser(createDto);

        return UserMapper.toUserDto(userService.add(user));
    }

    public UserDto update(UserUpdateDto updateDto, JwtAuthentication authInfo) {
        log.debug(String.format(
                "Обновление пользователя с логином %s, на входные данные: %s", authInfo.getPrincipal() ,updateDto)
        );
        User user = UserMapper.toUser(updateDto);

        return UserMapper.toUserDto(
                userService.update(user, authInfo)
        );
    }

}
