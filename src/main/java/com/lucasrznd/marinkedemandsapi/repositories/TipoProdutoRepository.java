package com.lucasrznd.marinkedemandsapi.repositories;

import com.lucasrznd.marinkedemandsapi.entities.TipoProduto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoProdutoRepository extends JpaRepository<TipoProduto, Long> {
}
