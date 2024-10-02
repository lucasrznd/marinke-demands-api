package com.lucasrznd.marinkedemandsapi.services;

import com.lucasrznd.marinkedemandsapi.controllers.exceptions.ResourceNotFoundException;
import com.lucasrznd.marinkedemandsapi.dtos.request.DemandaContratadoRequest;
import com.lucasrznd.marinkedemandsapi.dtos.response.DemandaContratadoResponse;
import com.lucasrznd.marinkedemandsapi.entities.DemandaContratado;
import com.lucasrznd.marinkedemandsapi.mappers.DemandaContratadoMapper;
import com.lucasrznd.marinkedemandsapi.repositories.DemandaContratadoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DemandaContratadoService {

    private final DemandaContratadoRepository repository;
    private final DemandaContratadoMapper mapper;

    public DemandaContratadoResponse save(final DemandaContratadoRequest request) {
        return mapper.toResponse(repository.save(mapper.toEntity(request)));
    }

    public List<DemandaContratadoResponse> findAll() {
        return repository.findAll().stream().map(mapper::toResponse).toList();
    }

    public DemandaContratadoResponse update(final Long id, DemandaContratadoRequest request) {
        DemandaContratado demandaContratado = find(id);

        return mapper.toResponse(repository.save(mapper.update(request, demandaContratado)));
    }

    public void delete(Long id) {
        repository.delete(find(id));
    }

    private DemandaContratado find(final Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Objeto não encontrado. Id: " + id + ", Tipo: " + DemandaContratadoResponse.class.getSimpleName()));
    }

}
