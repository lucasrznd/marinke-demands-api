package com.lucasrznd.marinkedemandsapi.controllers;

import com.lucasrznd.marinkedemandsapi.controllers.exceptions.StandardError;
import com.lucasrznd.marinkedemandsapi.dtos.request.ContratadoRequest;
import com.lucasrznd.marinkedemandsapi.dtos.response.ContratadoResponse;
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

@Tag(name = "ContratadoController", description = "Controller responsavél por operações de contratados")
@RequestMapping("/contratados")
public interface ContratadoController {

    @Operation(summary = "Salvar novo contratado")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Contratado criado", content = @Content(
                    mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = ContratadoResponse.class))),
            @ApiResponse(responseCode = "400", description = "Bad request", content = @Content(
                    mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = StandardError.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content(
                    mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = StandardError.class)))
    })
    @PostMapping
    ResponseEntity<ContratadoResponse> save(@RequestBody @Valid final ContratadoRequest request);

    @Operation(summary = "Encontrar todos contratados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Contratados encontrados", content = @Content(
                    mediaType = APPLICATION_JSON_VALUE, array = @ArraySchema(schema = @Schema(implementation = ContratadoResponse.class)))),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content(
                    mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = StandardError.class)))
    })
    @GetMapping
    ResponseEntity<List<ContratadoResponse>> findAll();

    @Operation(summary = "Atualizar contratado")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Contratado atualizado", content = @Content(
                    mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = ContratadoResponse.class))),
            @ApiResponse(responseCode = "400", description = "Bad request", content = @Content(
                    mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = StandardError.class))),
            @ApiResponse(responseCode = "404", description = "Contratado não encontrado", content = @Content(
                    mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = StandardError.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content(
                    mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = StandardError.class)))
    })
    @PutMapping("/{id}")
    ResponseEntity<ContratadoResponse> update(@Parameter(description = "Contratado Id", required = true, example = "1")
                                              @PathVariable(name = "id") final Long id,
                                              @RequestBody @Valid final ContratadoRequest request);

    @Operation(summary = "Remover contratado")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Contratado removido"),
            @ApiResponse(responseCode = "400", description = "Bad request", content = @Content(
                    mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = StandardError.class))),
            @ApiResponse(responseCode = "404", description = "Contratado não encontrado", content = @Content(
                    mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = StandardError.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content(
                    mediaType = APPLICATION_JSON_VALUE, array = @ArraySchema(schema = @Schema(implementation = StandardError.class))))
    })
    @DeleteMapping("/{id}")
    ResponseEntity<Void> delete(@Parameter(description = "Contratado Id", required = true, example = "1")
                                @PathVariable(name = "id") final Long id);

}
