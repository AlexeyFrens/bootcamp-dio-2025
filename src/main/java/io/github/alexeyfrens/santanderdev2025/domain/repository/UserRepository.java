package io.github.alexeyfrens.santanderdev2025.domain.repository;

import io.github.alexeyfrens.santanderdev2025.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsByAccountNumber(String accountNumber);
}
