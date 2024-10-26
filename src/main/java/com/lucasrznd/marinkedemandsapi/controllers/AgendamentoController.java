package com.lucasrznd.marinkedemandsapi.controllers;

import com.lucasrznd.marinkedemandsapi.controllers.exceptions.StandardError;
import com.lucasrznd.marinkedemandsapi.dtos.request.AgendamentoRequest;
import com.lucasrznd.marinkedemandsapi.dtos.response.AgendamentoResponse;
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

@Tag(name = "AgendamentoController", description = "Controller responsavél por operações de agendamentos")
@RequestMapping("/agendamentos")
public interface AgendamentoController {

    @Operation(summary = "Salvar novo Agendamento")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Agendamento criado", content = @Content(
                    mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = AgendamentoResponse.class))),
            @ApiResponse(responseCode = "400", description = "Bad request", content = @Content(
                    mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = StandardError.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content(
                    mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = StandardError.class)))
    })
    @PostMapping
    ResponseEntity<AgendamentoResponse> save(@RequestBody @Valid final AgendamentoRequest request);

    @Operation(summary = "Encontrar todos Agendamentos")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Agendamentos encontrados", content = @Content(
                    mediaType = APPLICATION_JSON_VALUE, array = @ArraySchema(schema = @Schema(implementation = AgendamentoResponse.class)))),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content(
                    mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = StandardError.class)))
    })
    @GetMapping
    ResponseEntity<List<AgendamentoResponse>> findAll();

    @Operation(summary = "Atualizar Agendamento")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Agendamento atualizado", content = @Content(
                    mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = AgendamentoResponse.class))),
            @ApiResponse(responseCode = "400", description = "Bad request", content = @Content(
                    mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = StandardError.class))),
            @ApiResponse(responseCode = "404", description = "Agendamento não encontrado", content = @Content(
                    mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = StandardError.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content(
                    mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = StandardError.class)))
    })
    @PutMapping("/{id}")
    ResponseEntity<AgendamentoResponse> update(@Parameter(description = "Agendamento Id", required = true, example = "1")
                                               @PathVariable(name = "id") final Long id,
                                               @RequestBody @Valid final AgendamentoRequest request);

    @Operation(summary = "Remover Agendamento")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Agendamento removido"),
            @ApiResponse(responseCode = "400", description = "Bad request", content = @Content(
                    mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = StandardError.class))),
            @ApiResponse(responseCode = "404", description = "Agendamento não encontrado", content = @Content(
                    mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = StandardError.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content(
                    mediaType = APPLICATION_JSON_VALUE, array = @ArraySchema(schema = @Schema(implementation = StandardError.class))))
    })
    @DeleteMapping("/{id}")
    ResponseEntity<Void> delete(@Parameter(description = "Agendamento Id", required = true, example = "1")
                                @PathVariable(name = "id") final Long id);

}
