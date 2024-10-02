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

    @Operation(summary = "Save new Nota Fiscal")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Nota Fiscal created", content = @Content(
                    mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = NotaFiscalResponse.class))),
            @ApiResponse(responseCode = "400", description = "Bad request", content = @Content(
                    mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = StandardError.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content(
                    mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = StandardError.class)))
    })
    @PostMapping
    ResponseEntity<NotaFiscalResponse> save(@RequestBody @Valid final NotaFiscalRequest request);

    @Operation(summary = "Find all Notas Fiscais")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Notas Fiscais founded", content = @Content(
                    mediaType = APPLICATION_JSON_VALUE, array = @ArraySchema(schema = @Schema(implementation = NotaFiscalResponse.class)))),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content(
                    mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = StandardError.class)))
    })
    @GetMapping
    ResponseEntity<List<NotaFiscalResponse>> findAll();

    @Operation(summary = "Update Nota Fiscal")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Nota Fiscal updated", content = @Content(
                    mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = NotaFiscalResponse.class))),
            @ApiResponse(responseCode = "400", description = "Bad request", content = @Content(
                    mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = StandardError.class))),
            @ApiResponse(responseCode = "404", description = "Nota Fiscal not found", content = @Content(
                    mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = StandardError.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content(
                    mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = StandardError.class)))
    })
    @PutMapping("/{id}")
    ResponseEntity<NotaFiscalResponse> update(@Parameter(description = "Nota Fiscal Id", required = true, example = "1")
                                              @PathVariable(name = "id") final Long id,
                                              @RequestBody @Valid final NotaFiscalRequest request);

    @Operation(summary = "Delete Nota Fiscal")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Nota Fiscal deleted"),
            @ApiResponse(responseCode = "400", description = "Bad request", content = @Content(
                    mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = StandardError.class))),
            @ApiResponse(responseCode = "404", description = "Nota Fiscal not found", content = @Content(
                    mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = StandardError.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content(
                    mediaType = APPLICATION_JSON_VALUE, array = @ArraySchema(schema = @Schema(implementation = StandardError.class))))
    })
    @DeleteMapping("/{id}")
    ResponseEntity<Void> delete(@Parameter(description = "Nota Fiscal Id", required = true, example = "1")
                                @PathVariable(name = "id") final Long id);

}
