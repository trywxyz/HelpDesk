package com.task.helpdesk.controller;

import com.task.helpdesk.model.Suporte;
import com.task.helpdesk.repository.SuporteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SuporteController {

    @Autowired
    private SuporteRepository repository;

    @PostMapping("/suporte")
    public Suporte registrarAtendimento(@RequestBody Suporte suporte) {
        return repository.save(suporte);
    }

    @GetMapping("/suporte")
    public List<Suporte> listarAtendimentos() {
        return repository.findAll();
    }
}
