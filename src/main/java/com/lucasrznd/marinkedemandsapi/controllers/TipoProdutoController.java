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

    @Operation(summary = "Save new Tipo Produto")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Tipo Produto created", content = @Content(
                    mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = TipoProdutoResponse.class))),
            @ApiResponse(responseCode = "400", description = "Bad request", content = @Content(
                    mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = StandardError.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content(
                    mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = StandardError.class)))
    })
    @PostMapping
    ResponseEntity<TipoProdutoResponse> save(@RequestBody @Valid final TipoProdutoRequest request);

    @Operation(summary = "Find all Tipos Produtos")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Tipos Produtos founded", content = @Content(
                    mediaType = APPLICATION_JSON_VALUE, array = @ArraySchema(schema = @Schema(implementation = TipoProdutoResponse.class)))),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content(
                    mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = StandardError.class)))
    })
    @GetMapping
    ResponseEntity<List<TipoProdutoResponse>> findAll();

    @Operation(summary = "Update Tipo Produto")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Tipo Produto updated", content = @Content(
                    mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = TipoProdutoResponse.class))),
            @ApiResponse(responseCode = "400", description = "Bad request", content = @Content(
                    mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = StandardError.class))),
            @ApiResponse(responseCode = "404", description = "Tipo produto not found", content = @Content(
                    mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = StandardError.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content(
                    mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = StandardError.class)))
    })
    @PutMapping("/{id}")
    ResponseEntity<TipoProdutoResponse> update(@Parameter(description = "Tipo Produto Id", required = true, example = "1")
                                               @PathVariable(name = "id") final Long id,
                                               @RequestBody @Valid final TipoProdutoRequest request);

    @Operation(summary = "Delete Tipo Produto")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Tipo Produto deleted"),
            @ApiResponse(responseCode = "400", description = "Bad request", content = @Content(
                    mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = StandardError.class))),
            @ApiResponse(responseCode = "404", description = "Tipo Produto not found", content = @Content(
                    mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = StandardError.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content(
                    mediaType = APPLICATION_JSON_VALUE, array = @ArraySchema(schema = @Schema(implementation = StandardError.class))))
    })
    @DeleteMapping("/{id}")
    ResponseEntity<Void> delete(@Parameter(description = "Tipo Produto Id", required = true, example = "1")
                                @PathVariable(name = "id") final Long id);

}
