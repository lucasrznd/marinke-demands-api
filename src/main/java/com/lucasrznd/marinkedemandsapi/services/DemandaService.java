package com.lucasrznd.marinkedemandsapi.services;

import com.lucasrznd.marinkedemandsapi.controllers.exceptions.ResourceNotFoundException;
import com.lucasrznd.marinkedemandsapi.dtos.request.DemandaRequest;
import com.lucasrznd.marinkedemandsapi.dtos.response.DemandaResponse;
import com.lucasrznd.marinkedemandsapi.entities.Demanda;
import com.lucasrznd.marinkedemandsapi.mappers.DemandaMapper;
import com.lucasrznd.marinkedemandsapi.repositories.DemandaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DemandaService {

    private final DemandaRepository repository;
    private final DemandaMapper mapper;

    public DemandaResponse save(final DemandaRequest request) {
        return mapper.toResponse(repository.save(mapper.toEntity(request)));
    }

    public List<DemandaResponse> findAll() {
        return repository.findAll().stream().map(mapper::toResponse).toList();
    }

    public DemandaResponse update(final Long id, final DemandaRequest request) {
        Demanda demanda = find(id);

        return mapper.toResponse(repository.save(mapper.update(request, demanda)));
    }

    public void delete(Long id) {
        repository.delete(find(id));
    }

    private Demanda find(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Objeto não encontrado. Id: " + id + ", Tipo: " + DemandaResponse.class.getSimpleName()));
    }

}
