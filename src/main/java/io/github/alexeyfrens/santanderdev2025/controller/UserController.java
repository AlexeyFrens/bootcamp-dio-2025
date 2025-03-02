package io.github.alexeyfrens.santanderdev2025.controller;

import io.github.alexeyfrens.santanderdev2025.domain.model.User;
import io.github.alexeyfrens.santanderdev2025.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("users")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping("{id}")
    public ResponseEntity<User> findById(@PathVariable Long id){
        var userSearched =  service.findById(id);
        return ResponseEntity.ok(userSearched);
    }

    @PostMapping
    public ResponseEntity<User> create(@RequestBody User user){
        service.create(user);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(user.getId())
                .toUri();

        return ResponseEntity.created(location).body(user);
    }
}
