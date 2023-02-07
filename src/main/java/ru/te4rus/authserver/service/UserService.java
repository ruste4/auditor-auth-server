package ru.te4rus.authserver.service;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.te4rus.authserver.domain.ERole;
import ru.te4rus.authserver.domain.JwtAuthentication;
import ru.te4rus.authserver.domain.Role;
import ru.te4rus.authserver.domain.User;
import ru.te4rus.authserver.exception.AuthException;
import ru.te4rus.authserver.exception.UserNotFoundException;
import ru.te4rus.authserver.repository.RoleRepository;
import ru.te4rus.authserver.repository.UserRepository;

import java.util.Collections;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    private final RoleRepository roleRepository;

    private final ERole DEFAULT_EROLE_BY_REGISTRATION = ERole.USER;


    public User add(@NonNull User user) {
        Role role = roleRepository.findByName(DEFAULT_EROLE_BY_REGISTRATION);
        user.setRoles(Collections.singletonList(role));
        return userRepository.save(user);
    }

    public User update(@NonNull User user, @NonNull JwtAuthentication authInfo) {
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

        return userFromDB;
    }

    public Optional<User> getByLogin(@NonNull String login) {
        return userRepository.findByLogin(login);
    }

    public void deleteById(@NonNull Long id) {
        userRepository.deleteById(id);
    }

}