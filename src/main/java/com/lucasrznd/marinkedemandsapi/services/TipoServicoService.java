package com.lucasrznd.marinkedemandsapi.services;

import com.lucasrznd.marinkedemandsapi.controllers.exceptions.ResourceNotFoundException;
import com.lucasrznd.marinkedemandsapi.dtos.request.TipoServicoRequest;
import com.lucasrznd.marinkedemandsapi.dtos.response.TipoServicoResponse;
import com.lucasrznd.marinkedemandsapi.entities.TipoServico;
import com.lucasrznd.marinkedemandsapi.mappers.TipoServicoMapper;
import com.lucasrznd.marinkedemandsapi.repositories.TipoServicoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TipoServicoService {

    private final TipoServicoRepository repository;
    private final TipoServicoMapper mapper;

    public TipoServicoResponse save(final TipoServicoRequest request) {
        return mapper.toResponse(repository.save(mapper.toEntity(request)));
    }

    public List<TipoServicoResponse> findAll() {
        return repository.findAll().stream().map(mapper::toResponse).toList();
    }

    public TipoServicoResponse update(final Long id, final TipoServicoRequest request) {
        TipoServico tipoServico = find(id);

        return mapper.toResponse(repository.save(mapper.update(request, tipoServico)));
    }

    public void delete(Long id) {
        repository.delete(find(id));
    }

    private TipoServico find(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Objeto não encontrado. Id: " + id + ", Tipo: " + TipoServicoResponse.class.getSimpleName()));
    }

}
