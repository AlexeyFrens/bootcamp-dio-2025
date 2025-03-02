package io.github.alexeyfrens.santanderdev2025.service;

import io.github.alexeyfrens.santanderdev2025.domain.model.User;

public interface UserService {

    User findById(Long id);

    User create(User userToCreate);
}
