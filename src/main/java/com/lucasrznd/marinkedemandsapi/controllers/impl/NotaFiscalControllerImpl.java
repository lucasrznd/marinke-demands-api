package com.lucasrznd.marinkedemandsapi.controllers.impl;

import com.lucasrznd.marinkedemandsapi.controllers.NotaFiscalController;
import com.lucasrznd.marinkedemandsapi.dtos.request.NotaFiscalRequest;
import com.lucasrznd.marinkedemandsapi.dtos.response.NotaFiscalResponse;
import com.lucasrznd.marinkedemandsapi.services.NotaFiscalService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequiredArgsConstructor
public class NotaFiscalControllerImpl implements NotaFiscalController {

    private final NotaFiscalService service;

    @Override
    public ResponseEntity<NotaFiscalResponse> save(NotaFiscalRequest request) {
        return ResponseEntity.status(CREATED).body(service.save(request));
    }

    @Override
    public ResponseEntity<List<NotaFiscalResponse>> findAll() {
        return ResponseEntity.ok().body(service.findAll());
    }

    @Override
    public ResponseEntity<NotaFiscalResponse> update(Long id, NotaFiscalRequest request) {
        return ResponseEntity.ok().body(service.update(id, request));
    }

    @Override
    public ResponseEntity<Void> delete(Long id) {
        service.delete(id);

        return ResponseEntity.noContent().build();
    }

}
