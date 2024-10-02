package com.lucasrznd.marinkedemandsapi.services;

import com.lucasrznd.marinkedemandsapi.controllers.exceptions.ResourceNotFoundException;
import com.lucasrznd.marinkedemandsapi.dtos.request.ReembolsoRequest;
import com.lucasrznd.marinkedemandsapi.dtos.response.ReembolsoResponse;
import com.lucasrznd.marinkedemandsapi.entities.Reembolso;
import com.lucasrznd.marinkedemandsapi.mappers.ReembolsoMapper;
import com.lucasrznd.marinkedemandsapi.repositories.ReembolsoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReembolsoService {

    private final ReembolsoRepository repository;
    private final ReembolsoMapper mapper;

    public ReembolsoResponse save(final ReembolsoRequest request) {
        return mapper.toResponse(repository.save(mapper.toEntity(request)));
    }

    public List<ReembolsoResponse> findAll() {
        return repository.findAll().stream().map(mapper::toResponse).toList();
    }

    public ReembolsoResponse update(final Long id, final ReembolsoRequest request) {
        Reembolso reembolso = find(id);

        return mapper.toResponse(repository.save(mapper.update(request, reembolso)));
    }

    public void delete(Long id) {
        repository.delete(find(id));
    }

    private Reembolso find(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Objeto não encontrado. Id: " + id + ", Tipo: " + ReembolsoResponse.class.getSimpleName()));
    }

}
