package com.lucasrznd.marinkedemandsapi.controllers.impl;

import com.lucasrznd.marinkedemandsapi.controllers.DemandanteController;
import com.lucasrznd.marinkedemandsapi.dtos.request.DemandanteRequest;
import com.lucasrznd.marinkedemandsapi.dtos.request.UpdateDemandanteRequest;
import com.lucasrznd.marinkedemandsapi.dtos.response.DemandanteResponse;
import com.lucasrznd.marinkedemandsapi.services.DemandanteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequiredArgsConstructor
public class DemandanteControllerImpl implements DemandanteController {

    private final DemandanteService service;

    @Override
    public ResponseEntity<DemandanteResponse> save(DemandanteRequest request) {
        return ResponseEntity.status(CREATED).body(service.save(request));
    }

    @Override
    public ResponseEntity<List<DemandanteResponse>> findAll() {
        return ResponseEntity.ok().body(service.findAll());
    }

    @Override
    public ResponseEntity<DemandanteResponse> update(Long id, UpdateDemandanteRequest request) {
        return ResponseEntity.ok().body(service.update(id, request));
    }

    @Override
    public ResponseEntity<Void> delete(Long id) {
        service.delete(id);

        return ResponseEntity.noContent().build();
    }

}
