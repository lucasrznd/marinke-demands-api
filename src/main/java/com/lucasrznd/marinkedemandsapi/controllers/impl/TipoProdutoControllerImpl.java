package com.lucasrznd.marinkedemandsapi.controllers.impl;

import com.lucasrznd.marinkedemandsapi.controllers.TipoProdutoController;
import com.lucasrznd.marinkedemandsapi.dtos.request.TipoProdutoRequest;
import com.lucasrznd.marinkedemandsapi.dtos.response.TipoProdutoResponse;
import com.lucasrznd.marinkedemandsapi.services.TipoProdutoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequiredArgsConstructor
public class TipoProdutoControllerImpl implements TipoProdutoController {

    private final TipoProdutoService service;

    @Override
    public ResponseEntity<TipoProdutoResponse> save(TipoProdutoRequest request) {
        return ResponseEntity.status(CREATED).body(service.save(request));
    }

    @Override
    public ResponseEntity<List<TipoProdutoResponse>> findAll() {
        return ResponseEntity.ok().body(service.findAll());
    }

    @Override
    public ResponseEntity<TipoProdutoResponse> update(Long id, TipoProdutoRequest request) {
        return ResponseEntity.ok().body(service.update(id, request));
    }

    @Override
    public ResponseEntity<Void> delete(Long id) {
        service.delete(id);

        return ResponseEntity.noContent().build();
    }

}
