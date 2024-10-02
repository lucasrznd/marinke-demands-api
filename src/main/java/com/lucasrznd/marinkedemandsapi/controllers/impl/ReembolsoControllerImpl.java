package com.lucasrznd.marinkedemandsapi.controllers.impl;

import com.lucasrznd.marinkedemandsapi.controllers.ReembolsoController;
import com.lucasrznd.marinkedemandsapi.dtos.request.ReembolsoRequest;
import com.lucasrznd.marinkedemandsapi.dtos.response.ReembolsoResponse;
import com.lucasrznd.marinkedemandsapi.services.ReembolsoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequiredArgsConstructor
public class ReembolsoControllerImpl implements ReembolsoController {

    private final ReembolsoService service;

    @Override
    public ResponseEntity<ReembolsoResponse> save(ReembolsoRequest request) {
        return ResponseEntity.status(CREATED).body(service.save(request));
    }

    @Override
    public ResponseEntity<List<ReembolsoResponse>> findAll() {
        return ResponseEntity.ok().body(service.findAll());
    }

    @Override
    public ResponseEntity<ReembolsoResponse> update(Long id, ReembolsoRequest request) {
        return ResponseEntity.ok().body(service.update(id, request));
    }

    @Override
    public ResponseEntity<Void> delete(Long id) {
        service.delete(id);

        return ResponseEntity.noContent().build();
    }

}
