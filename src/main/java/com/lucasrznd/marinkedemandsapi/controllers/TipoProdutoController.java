package com.lucasrznd.marinkedemandsapi.controllers;

import com.lucasrznd.marinkedemandsapi.controllers.exceptions.StandardError;
import com.lucasrznd.marinkedemandsapi.dtos.request.TipoProdutoRequest;
import com.lucasrznd.marinkedemandsapi.dtos.response.TipoProdutoResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Tag(name = "TipoProdutoController", description = "Controller responsavél por operações de tipos de produtos")
@RequestMapping("/tipos-produtos")
public interface TipoProdutoController {

    @Operation(summary = "Salvar novo Tipo Produto")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Tipo Produto criado", content = @Content(
                    mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = TipoProdutoResponse.class))),
            @ApiResponse(responseCode = "400", description = "Bad request", content = @Content(
                    mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = StandardError.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content(
                    mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = StandardError.class)))
    })
    @PostMapping
    ResponseEntity<TipoProdutoResponse> save(@RequestBody @Valid final TipoProdutoRequest request);

    @Operation(summary = "Encontrar todos Tipos Produtos")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Tipos Produtos encontrados", content = @Content(
                    mediaType = APPLICATION_JSON_VALUE, array = @ArraySchema(schema = @Schema(implementation = TipoProdutoResponse.class)))),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content(
                    mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = StandardError.class)))
    })
    @GetMapping
    ResponseEntity<List<TipoProdutoResponse>> findAll();

    @Operation(summary = "Atualizar Tipo Produto")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Tipo Produto atualizado", content = @Content(
                    mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = TipoProdutoResponse.class))),
            @ApiResponse(responseCode = "400", description = "Bad request", content = @Content(
                    mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = StandardError.class))),
            @ApiResponse(responseCode = "404", description = "Tipo produto não encontrado", content = @Content(
                    mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = StandardError.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content(
                    mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = StandardError.class)))
    })
    @PutMapping("/{id}")
    ResponseEntity<TipoProdutoResponse> update(@Parameter(description = "Tipo Produto Id", required = true, example = "1")
                                               @PathVariable(name = "id") final Long id,
                                               @RequestBody @Valid final TipoProdutoRequest request);

    @Operation(summary = "Remover Tipo Produto")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Tipo Produto removido"),
            @ApiResponse(responseCode = "400", description = "Bad request", content = @Content(
                    mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = StandardError.class))),
            @ApiResponse(responseCode = "404", description = "Tipo Produto não encontrado", content = @Content(
                    mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = StandardError.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content(
                    mediaType = APPLICATION_JSON_VALUE, array = @ArraySchema(schema = @Schema(implementation = StandardError.class))))
    })
    @DeleteMapping("/{id}")
    ResponseEntity<Void> delete(@Parameter(description = "Tipo Produto Id", required = true, example = "1")
                                @PathVariable(name = "id") final Long id);

}
