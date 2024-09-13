package com.lucasrznd.marinkedemandsapi.controllers.impl;

import com.lucasrznd.marinkedemandsapi.controllers.DemandaController;
import com.lucasrznd.marinkedemandsapi.dtos.request.DemandaRequest;
import com.lucasrznd.marinkedemandsapi.dtos.response.DemandaResponse;
import com.lucasrznd.marinkedemandsapi.services.DemandaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequiredArgsConstructor
public class DemandaControllerImpl implements DemandaController {

    private final DemandaService service;

    @Override
    public ResponseEntity<DemandaResponse> save(DemandaRequest request) {
        return ResponseEntity.status(CREATED).body(service.save(request));
    }

    @Override
    public ResponseEntity<List<DemandaResponse>> findAll() {
        return ResponseEntity.ok().body(service.findAll());
    }

    @Override
    public ResponseEntity<DemandaResponse> update(Long id, DemandaRequest request) {
        return ResponseEntity.ok().body(service.update(id, request));
    }

    @Override
    public ResponseEntity<Void> delete(Long id) {
        service.delete(id);

        return ResponseEntity.noContent().build();
    }

}
