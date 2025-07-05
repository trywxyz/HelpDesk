package com.task.helpdesk.model;

import jakarta.persistence.*;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

@Entity
public class Suporte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String mensagem;
    private LocalDateTime dataTratamento = LocalDateTime.now();

    @ManyToOne
    private User tecnico;

    @OneToOne
    private Chamado chamado;

    // Getters e Setters

    public Long getId() {
        return id;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public LocalDateTime getDataTratamento() {
        return dataTratamento;
    }

    public void setDataTratamento(LocalDateTime dataTratamento) {
        this.dataTratamento = dataTratamento;
    }

    public User getTecnico() {
        return tecnico;
    }

    public void setTecnico(User tecnico) {
        this.tecnico = tecnico;
    }

    public Chamado getChamado() {
        return chamado;
    }

    public void setChamado(Chamado chamado) {
        this.chamado = chamado;
    }
}


