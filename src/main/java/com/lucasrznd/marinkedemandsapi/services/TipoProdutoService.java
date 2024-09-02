package com.lucasrznd.marinkedemandsapi.services;

import com.lucasrznd.marinkedemandsapi.controllers.exceptions.ResourceNotFoundException;
import com.lucasrznd.marinkedemandsapi.dtos.request.TipoProdutoRequest;
import com.lucasrznd.marinkedemandsapi.dtos.response.TipoProdutoResponse;
import com.lucasrznd.marinkedemandsapi.entities.TipoProduto;
import com.lucasrznd.marinkedemandsapi.mappers.TipoProdutoMapper;
import com.lucasrznd.marinkedemandsapi.repositories.TipoProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TipoProdutoService {

    private final TipoProdutoRepository repository;
    private final TipoProdutoMapper mapper;

    public TipoProdutoResponse save(final TipoProdutoRequest request) {
        return mapper.toResponse(repository.save(mapper.toEntity(request)));
    }

    public List<TipoProdutoResponse> findAll() {
        return repository.findAll().stream().map(mapper::toResponse).toList();
    }

    public TipoProdutoResponse update(final Long id, TipoProdutoRequest request) {
        TipoProduto tipoProduto = find(id);

        return mapper.toResponse(repository.save(mapper.update(request, tipoProduto)));
    }

    public void delete(Long id) {
        repository.delete(find(id));
    }

    private TipoProduto find(final Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Objeto não encontrado. Id: " + id + ", Tipo: " + TipoProdutoResponse.class.getSimpleName()));
    }

}
