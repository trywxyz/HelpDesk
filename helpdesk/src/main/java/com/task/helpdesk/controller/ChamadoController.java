package com.task.helpdesk.controller;

import com.task.helpdesk.model.Chamado;
import com.task.helpdesk.model.User;
import com.task.helpdesk.repository.ChamadoRepository;
import com.task.helpdesk.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/chamados")
@CrossOrigin(origins = "*")
public class ChamadoController {

    @Autowired
    private ChamadoRepository chamadoRepository;

    @Autowired
    private UserRepository usuarioRepository;

    @PostMapping
    public Chamado cadastrarChamado(@RequestBody Chamado chamado) {
        if (chamado.getUsuario() != null && chamado.getUsuario().getId() != null) {
            User usuario = usuarioRepository.findById(chamado.getUsuario().getId()).orElse(null);
            chamado.setUsuario(usuario);
        }
        return chamadoRepository.save(chamado);
    }

    @GetMapping
    public List<Chamado> listarChamados() {
        return chamadoRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Chamado> buscarChamadoPorId(@PathVariable Long id) {
        Optional<Chamado> chamado = chamadoRepository.findById(id);
        return chamado.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

}
