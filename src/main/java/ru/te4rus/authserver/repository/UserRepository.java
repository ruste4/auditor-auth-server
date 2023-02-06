package ru.te4rus.authserver.repository;


import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.te4rus.authserver.domain.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByLogin(@NonNull String login);

    Optional<User> findById(@NonNull Long id);
}
