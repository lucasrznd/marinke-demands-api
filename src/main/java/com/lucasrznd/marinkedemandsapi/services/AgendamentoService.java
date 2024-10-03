package com.lucasrznd.marinkedemandsapi.services;

import com.lucasrznd.marinkedemandsapi.controllers.exceptions.ResourceNotFoundException;
import com.lucasrznd.marinkedemandsapi.dtos.request.AgendamentoRequest;
import com.lucasrznd.marinkedemandsapi.dtos.response.AgendamentoResponse;
import com.lucasrznd.marinkedemandsapi.entities.Agendamento;
import com.lucasrznd.marinkedemandsapi.mappers.AgendamentoMapper;
import com.lucasrznd.marinkedemandsapi.repositories.AgendamentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AgendamentoService {

    private final AgendamentoRepository repository;
    private final AgendamentoMapper mapper;

    public AgendamentoResponse save(final AgendamentoRequest request) {
        return mapper.toResponse(repository.save(mapper.toEntity(request)));
    }

    public List<AgendamentoResponse> findAll() {
        return repository.findAll().stream().map(mapper::toResponse).toList();
    }

    public AgendamentoResponse update(final Long id, AgendamentoRequest request) {
        Agendamento Agendamento = find(id);

        return mapper.toResponse(repository.save(mapper.update(request, Agendamento)));
    }

    public void delete(Long id) {
        repository.delete(find(id));
    }

    private Agendamento find(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Objeto não encontrado. Id: " + id + ", Tipo: " + AgendamentoResponse.class.getSimpleName()));
    }

}
