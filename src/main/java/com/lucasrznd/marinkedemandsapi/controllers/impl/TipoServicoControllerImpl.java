package com.lucasrznd.marinkedemandsapi.controllers.impl;

import com.lucasrznd.marinkedemandsapi.controllers.TipoServicoController;
import com.lucasrznd.marinkedemandsapi.dtos.request.TipoServicoRequest;
import com.lucasrznd.marinkedemandsapi.dtos.response.TipoServicoResponse;
import com.lucasrznd.marinkedemandsapi.services.TipoServicoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequiredArgsConstructor
public class TipoServicoControllerImpl implements TipoServicoController {

    private final TipoServicoService service;

    @Override
    public ResponseEntity<TipoServicoResponse> save(TipoServicoRequest request) {
        return ResponseEntity.status(CREATED).body(service.save(request));
    }

    @Override
    public ResponseEntity<List<TipoServicoResponse>> findAll() {
        return ResponseEntity.ok().body(service.findAll());
    }

    @Override
    public ResponseEntity<TipoServicoResponse> update(Long id, TipoServicoRequest request) {
        return ResponseEntity.ok().body(service.update(id, request));
    }

    @Override
    public ResponseEntity<Void> delete(Long id) {
        service.delete(id);

        return ResponseEntity.noContent().build();
    }

}
