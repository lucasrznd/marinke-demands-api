package com.lucasrznd.marinkedemandsapi.repositories;

import com.lucasrznd.marinkedemandsapi.entities.Reembolso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReembolsoRepository extends JpaRepository<Reembolso, Long> {
}
