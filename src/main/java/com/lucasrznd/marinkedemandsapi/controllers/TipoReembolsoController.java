package com.lucasrznd.marinkedemandsapi.controllers;

import com.lucasrznd.marinkedemandsapi.controllers.exceptions.StandardError;
import com.lucasrznd.marinkedemandsapi.dtos.request.TipoReembolsoRequest;
import com.lucasrznd.marinkedemandsapi.dtos.response.TipoReembolsoResponse;
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

@Tag(name = "TipoReembolsoController", description = "Controller responsavél por operações de tipos de reembolsos")
@RequestMapping("/tipos-reembolsos")
public interface TipoReembolsoController {

    @Operation(summary = "Salvar novo Tipo Reembolso")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Tipo Reembolso criado", content = @Content(
                    mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = TipoReembolsoResponse.class))),
            @ApiResponse(responseCode = "400", description = "Bad request", content = @Content(
                    mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = StandardError.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content(
                    mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = StandardError.class)))
    })
    @PostMapping
    ResponseEntity<TipoReembolsoResponse> save(@RequestBody @Valid final TipoReembolsoRequest request);

    @Operation(summary = "Encontrar todos Tipos Reembolsos")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Tipos Reembolsos encontrados", content = @Content(
                    mediaType = APPLICATION_JSON_VALUE, array = @ArraySchema(schema = @Schema(implementation = TipoReembolsoResponse.class)))),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content(
                    mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = StandardError.class)))
    })
    @GetMapping
    ResponseEntity<List<TipoReembolsoResponse>> findAll();

    @Operation(summary = "Atualizar Tipo Reembolso")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Tipo Reembolso atualizado", content = @Content(
                    mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = TipoReembolsoResponse.class))),
            @ApiResponse(responseCode = "400", description = "Bad request", content = @Content(
                    mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = StandardError.class))),
            @ApiResponse(responseCode = "404", description = "Tipo Reembolso não encontrado", content = @Content(
                    mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = StandardError.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content(
                    mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = StandardError.class)))
    })
    @PutMapping("/{id}")
    ResponseEntity<TipoReembolsoResponse> update(@Parameter(description = "Tipo Reembolso Id", required = true, example = "1")
                                                 @PathVariable(name = "id") final Long id,
                                                 @RequestBody @Valid final TipoReembolsoRequest request);

    @Operation(summary = "Remover Tipo Reembolso")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Tipo Reembolso removido"),
            @ApiResponse(responseCode = "400", description = "Bad request", content = @Content(
                    mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = StandardError.class))),
            @ApiResponse(responseCode = "404", description = "Tipo Reembolso não encontrado", content = @Content(
                    mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = StandardError.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content(
                    mediaType = APPLICATION_JSON_VALUE, array = @ArraySchema(schema = @Schema(implementation = StandardError.class))))
    })
    @DeleteMapping("/{id}")
    ResponseEntity<Void> delete(@Parameter(description = "Tipo Reembolso Id", required = true, example = "1")
                                @PathVariable(name = "id") final Long id);

}
