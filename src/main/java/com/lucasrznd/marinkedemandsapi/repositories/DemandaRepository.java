package com.lucasrznd.marinkedemandsapi.repositories;

import com.lucasrznd.marinkedemandsapi.entities.Demanda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DemandaRepository extends JpaRepository<Demanda, Long> {
}
