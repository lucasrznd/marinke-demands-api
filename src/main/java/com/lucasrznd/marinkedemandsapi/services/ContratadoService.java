package com.lucasrznd.marinkedemandsapi.services;

import com.lucasrznd.marinkedemandsapi.controllers.exceptions.ResourceNotFoundException;
import com.lucasrznd.marinkedemandsapi.dtos.request.ContratadoRequest;
import com.lucasrznd.marinkedemandsapi.dtos.response.ContratadoResponse;
import com.lucasrznd.marinkedemandsapi.entities.Contratado;
import com.lucasrznd.marinkedemandsapi.mappers.ContratadoMapper;
import com.lucasrznd.marinkedemandsapi.repositories.ContratadoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ContratadoService {

    private final ContratadoRepository repository;
    private final ContratadoMapper mapper;

    public ContratadoResponse save(final ContratadoRequest request) {
        return mapper.toResponse(repository.save(mapper.toEntity(request)));
    }

    public List<ContratadoResponse> findAll() {
        return repository.findAll().stream().map(mapper::toResponse).toList();
    }

    public ContratadoResponse update(final Long id, ContratadoRequest request) {
        Contratado contratado = find(id);

        return mapper.toResponse(repository.save(mapper.update(request, contratado)));
    }

    public void delete(Long id) {
        repository.delete(find(id));
    }

    private Contratado find(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Objeto não encontrado. Id: " + id + ", Tipo: " + ContratadoResponse.class.getSimpleName()));
    }

}
