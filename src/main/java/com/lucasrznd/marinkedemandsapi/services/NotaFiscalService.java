package com.lucasrznd.marinkedemandsapi.services;

import com.lucasrznd.marinkedemandsapi.controllers.exceptions.ResourceNotFoundException;
import com.lucasrznd.marinkedemandsapi.dtos.request.NotaFiscalRequest;
import com.lucasrznd.marinkedemandsapi.dtos.response.NotaFiscalResponse;
import com.lucasrznd.marinkedemandsapi.entities.NotaFiscal;
import com.lucasrznd.marinkedemandsapi.mappers.NotaFiscalMapper;
import com.lucasrznd.marinkedemandsapi.repositories.NotaFiscalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NotaFiscalService {

    private final NotaFiscalRepository repository;
    private final NotaFiscalMapper mapper;

    public NotaFiscalResponse save(final NotaFiscalRequest request) {
        return mapper.toResponse(repository.save(mapper.toEntity(request)));
    }

    public List<NotaFiscalResponse> findAll() {
        return repository.findAll().stream().map(mapper::toResponse).toList();
    }

    public NotaFiscalResponse update(final Long id, final NotaFiscalRequest request) {
        NotaFiscal notaFiscal = find(id);

        return mapper.toResponse(repository.save(mapper.update(request, notaFiscal)));
    }

    public void delete(Long id) {
        repository.delete(find(id));
    }

    private NotaFiscal find(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Objeto não encontrado. Id: " + id + ", Tipo: " + NotaFiscalResponse.class.getSimpleName()));
    }

}
