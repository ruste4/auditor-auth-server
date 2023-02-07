package ru.te4rus.authserver.dto;

import ru.te4rus.authserver.domain.User;

public class UserMapper {
    public static User toUser(UserCreateDto createDto) {
        User user = new User();

        user.setLogin(createDto.getLogin());
        user.setPassword(createDto.getPassword());
        user.setFirstName(createDto.getFirstname());
        user.setLastName(createDto.getLastname());

        return user;
    }

    public static User toUser(UserUpdateDto updateDto) {
        User user = new User();

        user.setId(updateDto.getId());
        user.setLogin(updateDto.getLogin());
        user.setPassword(updateDto.getPassword());
        user.setFirstName(updateDto.getFirstname());
        user.setLastName(updateDto.getLastname());

        return user;
    }

    public static UserDto toUserDto(User user) {
        UserDto userDto = new UserDto();

        userDto.setId(user.getId());
        userDto.setLogin(user.getLogin());
        userDto.setFirstname(user.getFirstName());
        userDto.setLastname(user.getLastName());

        return userDto;
    }

}
