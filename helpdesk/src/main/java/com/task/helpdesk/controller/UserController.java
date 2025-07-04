package com.task.helpdesk.controller;

import com.task.helpdesk.model.User;
import com.task.helpdesk.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private UserRepository repository;

    @PostMapping
    public User cadastrarUsuario(@RequestBody User usuario) {
        return repository.save(usuario);
    }

    @GetMapping
    public List<User> listarUsuarios() {
        return repository.findAll();
    }
}
