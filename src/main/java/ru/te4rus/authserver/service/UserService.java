package ru.te4rus.authserver.service;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.te4rus.authserver.domain.JwtAuthentication;
import ru.te4rus.authserver.domain.User;
import ru.te4rus.authserver.exception.AuthException;
import ru.te4rus.authserver.exception.UserNotFoundException;
import ru.te4rus.authserver.repository.RoleRepository;
import ru.te4rus.authserver.repository.UserRepository;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User add(@NonNull User user) {
        return userRepository.save(user);
    }

    public User update(@NonNull User user, JwtAuthentication authInfo) {
        String currentUserLogin = authInfo.getPrincipal();

        if (!currentUserLogin.equals(user.getLogin())) {
            throw new AuthException("Нет доступа");
        }

        User userFromDB = userRepository.findByLogin(currentUserLogin)
                .orElseThrow(
                        () -> new UserNotFoundException(
                                String.format("Пользователь с логином:%s не найден", currentUserLogin)
                        )
                );

        if (user.getLogin() != null) {
            userFromDB.setLogin(user.getLogin());
        }

        if (user.getPassword() != null) {
            userFromDB.setPassword(user.getPassword());
        }

        if (user.getFirstName() != null) {
            userFromDB.setFirstName(user.getFirstName());
        }

        if (user.getLastName() != null) {
            userFromDB.setLastName(user.getLastName());
        }

        if (user.getRoles() != null) {
            userFromDB.setRoles(user.getRoles());
        }

        return userFromDB;
    }

    public Optional<User> getByLogin(@NonNull String login) {
        return userRepository.findByLogin(login);
    }

    public void deleteById(@NonNull Long id) {
        userRepository.deleteById(id);
    }

}