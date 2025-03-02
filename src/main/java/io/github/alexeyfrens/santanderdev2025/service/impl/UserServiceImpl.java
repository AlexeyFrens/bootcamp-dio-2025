package io.github.alexeyfrens.santanderdev2025.service.impl;

import io.github.alexeyfrens.santanderdev2025.domain.model.User;
import io.github.alexeyfrens.santanderdev2025.domain.repository.UserRepository;
import io.github.alexeyfrens.santanderdev2025.service.UserService;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public User findById(Long id) {
        return repository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public User create(User userToCreate) {
        if(repository.existsByAccountNumber(userToCreate.getAccount().getNumber())){
            throw new IllegalArgumentException("This account number already exists!");
        }
        return repository.save(userToCreate);
    }
}
