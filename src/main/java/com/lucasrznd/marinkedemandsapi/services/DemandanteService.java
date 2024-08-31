package com.lucasrznd.marinkedemandsapi.services;

import com.lucasrznd.marinkedemandsapi.controllers.exceptions.ResourceNotFoundException;
import com.lucasrznd.marinkedemandsapi.dtos.request.DemandanteRequest;
import com.lucasrznd.marinkedemandsapi.dtos.request.UpdateDemandanteRequest;
import com.lucasrznd.marinkedemandsapi.dtos.response.DemandanteResponse;
import com.lucasrznd.marinkedemandsapi.entities.Demandante;
import com.lucasrznd.marinkedemandsapi.mappers.DemandanteMapper;
import com.lucasrznd.marinkedemandsapi.repositories.DemandanteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DemandanteService {

    private final DemandanteRepository repository;
    private final DemandanteMapper mapper;

    public DemandanteResponse save(final DemandanteRequest request) {
        return mapper.toResponse(repository.save(mapper.toEntity(request)));
    }

    public List<DemandanteResponse> findAll() {
        return repository.findAll().stream().map(mapper::toResponse).toList();
    }

    public DemandanteResponse update(final Long id, UpdateDemandanteRequest request) {
        Demandante demandante = find(id);

        return mapper.toResponse(repository.save(mapper.update(request, demandante)));
    }

    public void delete(Long id) {
        repository.delete(find(id));
    }

    private Demandante find(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Objeto não encontrado. Id: " + id + ", Tipo: " + DemandanteResponse.class.getSimpleName()));
    }

}
