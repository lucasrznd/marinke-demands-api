package com.lucasrznd.marinkedemandsapi.controllers;

import com.lucasrznd.marinkedemandsapi.controllers.exceptions.StandardError;
import com.lucasrznd.marinkedemandsapi.dtos.request.NotaFiscalRequest;
import com.lucasrznd.marinkedemandsapi.dtos.response.NotaFiscalResponse;
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

@Tag(name = "NotaFiscalController", description = "Controller responsavél por operações de notas fiscais")
@RequestMapping("/notas-fiscais")
public interface NotaFiscalController {

    @Operation(summary = "Salvar nova Nota Fiscal")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Nota Fiscal criada", content = @Content(
                    mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = NotaFiscalResponse.class))),
            @ApiResponse(responseCode = "400", description = "Bad request", content = @Content(
                    mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = StandardError.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content(
                    mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = StandardError.class)))
    })
    @PostMapping
    ResponseEntity<NotaFiscalResponse> save(@RequestBody @Valid final NotaFiscalRequest request);

    @Operation(summary = "Encontrar todas Notas Fiscais")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Notas Fiscais encontradas", content = @Content(
                    mediaType = APPLICATION_JSON_VALUE, array = @ArraySchema(schema = @Schema(implementation = NotaFiscalResponse.class)))),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content(
                    mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = StandardError.class)))
    })
    @GetMapping
    ResponseEntity<List<NotaFiscalResponse>> findAll();

    @Operation(summary = "Atualizar Nota Fiscal")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Nota Fiscal atualizada", content = @Content(
                    mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = NotaFiscalResponse.class))),
            @ApiResponse(responseCode = "400", description = "Bad request", content = @Content(
                    mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = StandardError.class))),
            @ApiResponse(responseCode = "404", description = "Nota Fiscal não encontrada", content = @Content(
                    mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = StandardError.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content(
                    mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = StandardError.class)))
    })
    @PutMapping("/{id}")
    ResponseEntity<NotaFiscalResponse> update(@Parameter(description = "Nota Fiscal Id", required = true, example = "1")
                                              @PathVariable(name = "id") final Long id,
                                              @RequestBody @Valid final NotaFiscalRequest request);

    @Operation(summary = "Remover Nota Fiscal")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Nota Fiscal removida"),
            @ApiResponse(responseCode = "400", description = "Bad request", content = @Content(
                    mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = StandardError.class))),
            @ApiResponse(responseCode = "404", description = "Nota Fiscal não encontrada", content = @Content(
                    mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = StandardError.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content(
                    mediaType = APPLICATION_JSON_VALUE, array = @ArraySchema(schema = @Schema(implementation = StandardError.class))))
    })
    @DeleteMapping("/{id}")
    ResponseEntity<Void> delete(@Parameter(description = "Nota Fiscal Id", required = true, example = "1")
                                @PathVariable(name = "id") final Long id);

}
