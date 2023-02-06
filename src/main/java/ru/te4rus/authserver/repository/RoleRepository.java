package ru.te4rus.authserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.te4rus.authserver.domain.ERole;
import ru.te4rus.authserver.domain.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(ERole eRole);
}
