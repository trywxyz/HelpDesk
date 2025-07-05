package com.task.helpdesk.controller;

import com.task.helpdesk.model.Chamado;
import com.task.helpdesk.model.Support;
import com.task.helpdesk.repository.ChamadoRepository;
import com.task.helpdesk.repository.SuporteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class SuporteController {

    @Autowired
    private SuporteRepository suporteRepository;

    @Autowired
    private ChamadoRepository chamadoRepository;

    @PostMapping("/suporte")
    public ResponseEntity<?> registrarAtendimento(@RequestBody Support suporte) {
        if (suporte.getChamado() == null || suporte.getChamado().getId() == null) {
            return ResponseEntity.badRequest().body("Invalid Request");
        }

        Optional<Chamado> chamadoOpt = chamadoRepository.findById(suporte.getChamado().getId());
        if (!chamadoOpt.isPresent()) {
            return ResponseEntity.badRequest().body("Request not found");
        }

        Chamado chamado = chamadoOpt.get();

        chamado.setStatus("Closed");
        chamadoRepository.save(chamado);

        suporte.setChamado(chamado);
        suporteRepository.save(suporte);

        return ResponseEntity.ok().build();
    }
}
