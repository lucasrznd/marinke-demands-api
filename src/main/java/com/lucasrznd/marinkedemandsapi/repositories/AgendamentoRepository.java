package com.lucasrznd.marinkedemandsapi.repositories;

import com.lucasrznd.marinkedemandsapi.entities.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {
}
