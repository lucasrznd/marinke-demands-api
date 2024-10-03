package com.lucasrznd.marinkedemandsapi.controllers.impl;

import com.lucasrznd.marinkedemandsapi.controllers.AgendamentoController;
import com.lucasrznd.marinkedemandsapi.dtos.request.AgendamentoRequest;
import com.lucasrznd.marinkedemandsapi.dtos.response.AgendamentoResponse;
import com.lucasrznd.marinkedemandsapi.services.AgendamentoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequiredArgsConstructor
public class AgendamentoControllerImpl implements AgendamentoController {

    private final AgendamentoService service;

    @Override
    public ResponseEntity<AgendamentoResponse> save(AgendamentoRequest request) {
        return ResponseEntity.status(CREATED).body(service.save(request));
    }

    @Override
    public ResponseEntity<List<AgendamentoResponse>> findAll() {
        return ResponseEntity.ok().body(service.findAll());
    }

    @Override
    public ResponseEntity<AgendamentoResponse> update(Long id, AgendamentoRequest request) {
        return ResponseEntity.ok().body(service.update(id, request));
    }

    @Override
    public ResponseEntity<Void> delete(Long id) {
        service.delete(id);

        return ResponseEntity.noContent().build();
    }

}
