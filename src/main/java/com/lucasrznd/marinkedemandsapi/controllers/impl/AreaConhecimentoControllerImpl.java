package com.lucasrznd.marinkedemandsapi.controllers.impl;

import com.lucasrznd.marinkedemandsapi.controllers.AreaConhecimentoController;
import com.lucasrznd.marinkedemandsapi.dtos.request.AreaConhecimentoRequest;
import com.lucasrznd.marinkedemandsapi.dtos.response.AreaConhecimentoResponse;
import com.lucasrznd.marinkedemandsapi.services.AreaConhecimentoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequiredArgsConstructor
public class AreaConhecimentoControllerImpl implements AreaConhecimentoController {

    private final AreaConhecimentoService service;

    @Override
    public ResponseEntity<AreaConhecimentoResponse> save(AreaConhecimentoRequest request) {
        return ResponseEntity.status(CREATED).body(service.save(request));
    }

    @Override
    public ResponseEntity<List<AreaConhecimentoResponse>> findAll() {
        return ResponseEntity.ok().body(service.findAll());
    }

    @Override
    public ResponseEntity<AreaConhecimentoResponse> update(Long id, AreaConhecimentoRequest request) {
        return ResponseEntity.ok().body(service.update(id, request));
    }

    @Override
    public ResponseEntity<Void> delete(Long id) {
        service.delete(id);

        return ResponseEntity.noContent().build();
    }

}
