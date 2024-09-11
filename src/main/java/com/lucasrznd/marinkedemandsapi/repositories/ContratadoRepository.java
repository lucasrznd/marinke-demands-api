package com.lucasrznd.marinkedemandsapi.repositories;

import com.lucasrznd.marinkedemandsapi.entities.Contratado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContratadoRepository extends JpaRepository<Contratado, Long> {
}
