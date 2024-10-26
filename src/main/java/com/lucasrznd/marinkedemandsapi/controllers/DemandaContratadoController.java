package com.lucasrznd.marinkedemandsapi.controllers;

import com.lucasrznd.marinkedemandsapi.controllers.exceptions.StandardError;
import com.lucasrznd.marinkedemandsapi.dtos.request.DemandaContratadoRequest;
import com.lucasrznd.marinkedemandsapi.dtos.response.DemandaContratadoResponse;
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

@Tag(name = "DemandaContratadoController", description = "Controller responsavél por operações de perfis contratados de demandas")
@RequestMapping("/demanda-contratados")
public interface DemandaContratadoController {

    @Operation(summary = "Salvar nova Demanda Contratado")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Demanda Contratado criada", content = @Content(
                    mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = DemandaContratadoResponse.class))),
            @ApiResponse(responseCode = "400", description = "Bad request", content = @Content(
                    mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = StandardError.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content(
                    mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = StandardError.class)))
    })
    @PostMapping
    ResponseEntity<DemandaContratadoResponse> save(@RequestBody @Valid final DemandaContratadoRequest request);

    @Operation(summary = "Encontrar todas Demandas Contratados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Demanda Contratados encontradas", content = @Content(
                    mediaType = APPLICATION_JSON_VALUE, array = @ArraySchema(schema = @Schema(implementation = DemandaContratadoResponse.class)))),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content(
                    mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = StandardError.class)))
    })
    @GetMapping
    ResponseEntity<List<DemandaContratadoResponse>> findAll();

    @Operation(summary = "Atualizar Demanda Contratado")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Demanda Contratado atualizada", content = @Content(
                    mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = DemandaContratadoResponse.class))),
            @ApiResponse(responseCode = "400", description = "Bad request", content = @Content(
                    mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = StandardError.class))),
            @ApiResponse(responseCode = "404", description = "Demanda Contratado não encontrada", content = @Content(
                    mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = StandardError.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content(
                    mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = StandardError.class)))
    })
    @PutMapping("/{id}")
    ResponseEntity<DemandaContratadoResponse> update(@Parameter(description = "Demanda Contratado Id", required = true, example = "1")
                                                     @PathVariable(name = "id") final Long id,
                                                     @RequestBody @Valid final DemandaContratadoRequest request);

    @Operation(summary = "Remover Demanda Contratado")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Demanda Contratado removida"),
            @ApiResponse(responseCode = "400", description = "Bad request", content = @Content(
                    mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = StandardError.class))),
            @ApiResponse(responseCode = "404", description = "Demanda Contratado não encontrada", content = @Content(
                    mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = StandardError.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content(
                    mediaType = APPLICATION_JSON_VALUE, array = @ArraySchema(schema = @Schema(implementation = StandardError.class))))
    })
    @DeleteMapping("/{id}")
    ResponseEntity<Void> delete(@Parameter(description = "Demanda Contratado Id", required = true, example = "1")
                                @PathVariable(name = "id") final Long id);

}
