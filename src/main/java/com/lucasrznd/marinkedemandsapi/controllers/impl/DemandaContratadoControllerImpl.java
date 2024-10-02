package com.lucasrznd.marinkedemandsapi.controllers.impl;

import com.lucasrznd.marinkedemandsapi.controllers.DemandaContratadoController;
import com.lucasrznd.marinkedemandsapi.dtos.request.DemandaContratadoRequest;
import com.lucasrznd.marinkedemandsapi.dtos.response.DemandaContratadoResponse;
import com.lucasrznd.marinkedemandsapi.services.DemandaContratadoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequiredArgsConstructor
public class DemandaContratadoControllerImpl implements DemandaContratadoController {

    private final DemandaContratadoService service;

    @Override
    public ResponseEntity<DemandaContratadoResponse> save(DemandaContratadoRequest request) {
        return ResponseEntity.status(CREATED).body(service.save(request));
    }

    @Override
    public ResponseEntity<List<DemandaContratadoResponse>> findAll() {
        return ResponseEntity.ok().body(service.findAll());
    }

    @Override
    public ResponseEntity<DemandaContratadoResponse> update(Long id, DemandaContratadoRequest request) {
        return ResponseEntity.ok().body(service.update(id, request));
    }

    @Override
    public ResponseEntity<Void> delete(Long id) {
        service.delete(id);

        return ResponseEntity.noContent().build();
    }

}
