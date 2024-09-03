package com.lucasrznd.marinkedemandsapi.controllers;

import com.lucasrznd.marinkedemandsapi.controllers.exceptions.StandardError;
import com.lucasrznd.marinkedemandsapi.dtos.request.TipoServicoRequest;
import com.lucasrznd.marinkedemandsapi.dtos.response.TipoServicoResponse;
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

@Tag(name = "TipoServicoController", description = "Controller responsavél por operações de tipos de serviços")
@RequestMapping("/tipos-servicos")
public interface TipoServicoController {

    @Operation(summary = "Save new Tipo Servico")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Tipo Servico created", content = @Content(
                    mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = TipoServicoResponse.class))),
            @ApiResponse(responseCode = "400", description = "Bad request", content = @Content(
                    mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = StandardError.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content(
                    mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = StandardError.class)))
    })
    @PostMapping
    ResponseEntity<TipoServicoResponse> save(@RequestBody @Valid final TipoServicoRequest request);

    @Operation(summary = "Find all Tipos Servicos")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Tipos Servicos founded", content = @Content(
                    mediaType = APPLICATION_JSON_VALUE, array = @ArraySchema(schema = @Schema(implementation = TipoServicoResponse.class)))),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content(
                    mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = StandardError.class)))
    })
    @GetMapping
    ResponseEntity<List<TipoServicoResponse>> findAll();

    @Operation(summary = "Update Tipo Servico")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Tipo Servico updated", content = @Content(
                    mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = TipoServicoResponse.class))),
            @ApiResponse(responseCode = "400", description = "Bad request", content = @Content(
                    mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = StandardError.class))),
            @ApiResponse(responseCode = "404", description = "Tipo Servico not found", content = @Content(
                    mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = StandardError.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content(
                    mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = StandardError.class)))
    })
    @PutMapping("/{id}")
    ResponseEntity<TipoServicoResponse> update(@Parameter(description = "Tipo Servico Id", required = true, example = "1")
                                               @PathVariable(name = "id") final Long id,
                                               @RequestBody @Valid final TipoServicoRequest request);

    @Operation(summary = "Delete Tipo Servico")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Tipo Servico deleted"),
            @ApiResponse(responseCode = "400", description = "Bad request", content = @Content(
                    mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = StandardError.class))),
            @ApiResponse(responseCode = "404", description = "Tipo Servico not found", content = @Content(
                    mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = StandardError.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content(
                    mediaType = APPLICATION_JSON_VALUE, array = @ArraySchema(schema = @Schema(implementation = StandardError.class))))
    })
    @DeleteMapping("/{id}")
    ResponseEntity<Void> delete(@Parameter(description = "Tipo Servico Id", required = true, example = "1")
                                @PathVariable(name = "id") final Long id);

}
