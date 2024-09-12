package com.lucasrznd.marinkedemandsapi.services;

import com.lucasrznd.marinkedemandsapi.controllers.exceptions.ResourceNotFoundException;
import com.lucasrznd.marinkedemandsapi.dtos.request.AreaConhecimentoRequest;
import com.lucasrznd.marinkedemandsapi.dtos.response.AreaConhecimentoResponse;
import com.lucasrznd.marinkedemandsapi.entities.AreaConhecimento;
import com.lucasrznd.marinkedemandsapi.mappers.AreaConhecimentoMapper;
import com.lucasrznd.marinkedemandsapi.repositories.AreaConhecimentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AreaConhecimentoService {

    private final AreaConhecimentoRepository repository;
    private final AreaConhecimentoMapper mapper;

    public AreaConhecimentoResponse save(final AreaConhecimentoRequest request) {
        return mapper.toResponse(repository.save(mapper.toEntity(request)));
    }

    public List<AreaConhecimentoResponse> findAll() {
        return repository.findAll().stream().map(mapper::toResponse).toList();
    }

    public AreaConhecimentoResponse update(final Long id, AreaConhecimentoRequest request) {
        AreaConhecimento areaConhecimento = find(id);

        return mapper.toResponse(repository.save(mapper.update(request, areaConhecimento)));
    }

    public void delete(Long id) {
        repository.delete(find(id));
    }

    private AreaConhecimento find(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Objeto não encontrado. Id: " + id + ", Tipo: " + AreaConhecimentoResponse.class.getSimpleName()));
    }

}
