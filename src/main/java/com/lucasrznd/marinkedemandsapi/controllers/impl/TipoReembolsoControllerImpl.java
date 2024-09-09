package com.lucasrznd.marinkedemandsapi.controllers.impl;

import com.lucasrznd.marinkedemandsapi.controllers.TipoReembolsoController;
import com.lucasrznd.marinkedemandsapi.dtos.request.TipoReembolsoRequest;
import com.lucasrznd.marinkedemandsapi.dtos.response.TipoReembolsoResponse;
import com.lucasrznd.marinkedemandsapi.services.TipoReembolsoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequiredArgsConstructor
public class TipoReembolsoControllerImpl implements TipoReembolsoController {

    private final TipoReembolsoService service;

    @Override
    public ResponseEntity<TipoReembolsoResponse> save(TipoReembolsoRequest request) {
        return ResponseEntity.status(CREATED).body(service.save(request));
    }

    @Override
    public ResponseEntity<List<TipoReembolsoResponse>> findAll() {
        return ResponseEntity.ok().body(service.findAll());
    }

    @Override
    public ResponseEntity<TipoReembolsoResponse> update(Long id, TipoReembolsoRequest request) {
        return ResponseEntity.ok().body(service.update(id, request));
    }

    @Override
    public ResponseEntity<Void> delete(Long id) {
        service.delete(id);

        return ResponseEntity.noContent().build();
    }

}
