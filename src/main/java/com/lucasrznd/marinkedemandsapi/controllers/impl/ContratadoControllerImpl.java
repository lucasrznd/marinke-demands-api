package com.lucasrznd.marinkedemandsapi.controllers.impl;

import com.lucasrznd.marinkedemandsapi.controllers.ContratadoController;
import com.lucasrznd.marinkedemandsapi.dtos.request.ContratadoRequest;
import com.lucasrznd.marinkedemandsapi.dtos.response.ContratadoResponse;
import com.lucasrznd.marinkedemandsapi.services.ContratadoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequiredArgsConstructor
public class ContratadoControllerImpl implements ContratadoController {

    private final ContratadoService service;

    @Override
    public ResponseEntity<ContratadoResponse> save(ContratadoRequest request) {
        return ResponseEntity.status(CREATED).body(service.save(request));
    }

    @Override
    public ResponseEntity<List<ContratadoResponse>> findAll() {
        return ResponseEntity.ok().body(service.findAll());
    }

    @Override
    public ResponseEntity<ContratadoResponse> update(Long id, ContratadoRequest request) {
        return ResponseEntity.ok().body(service.update(id, request));
    }

    @Override
    public ResponseEntity<Void> delete(Long id) {
        service.delete(id);

        return ResponseEntity.noContent().build();
    }

}
