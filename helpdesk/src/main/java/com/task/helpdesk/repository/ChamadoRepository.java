package com.task.helpdesk.repository;

import com.task.helpdesk.model.Chamado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChamadoRepository extends JpaRepository<Chamado, Long> {

}
