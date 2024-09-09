package com.lucasrznd.marinkedemandsapi.services;

import com.lucasrznd.marinkedemandsapi.controllers.exceptions.ResourceNotFoundException;
import com.lucasrznd.marinkedemandsapi.dtos.request.TipoReembolsoRequest;
import com.lucasrznd.marinkedemandsapi.dtos.response.TipoReembolsoResponse;
import com.lucasrznd.marinkedemandsapi.entities.TipoReembolso;
import com.lucasrznd.marinkedemandsapi.mappers.TipoReembolsoMapper;
import com.lucasrznd.marinkedemandsapi.repositories.TipoReembolsoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TipoReembolsoService {

    private final TipoReembolsoRepository repository;
    private final TipoReembolsoMapper mapper;

    public TipoReembolsoResponse save(final TipoReembolsoRequest request) {
        return mapper.toResponse(repository.save(mapper.toEntity(request)));
    }

    public List<TipoReembolsoResponse> findAll() {
        return repository.findAll().stream().map(mapper::toResponse).toList();
    }

    public TipoReembolsoResponse update(final Long id, final TipoReembolsoRequest request) {
        TipoReembolso tipoReembolso = find(id);

        return mapper.toResponse(repository.save(mapper.update(request, tipoReembolso)));
    }

    public void delete(Long id) {
        repository.delete(find(id));
    }

    private TipoReembolso find(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Objeto não encontrado. Id: " + id + ", Tipo: " + TipoReembolsoResponse.class.getSimpleName()));
    }

}
