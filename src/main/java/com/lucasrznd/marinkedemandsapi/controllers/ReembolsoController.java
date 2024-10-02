package com.lucasrznd.marinkedemandsapi.controllers;

import com.lucasrznd.marinkedemandsapi.controllers.exceptions.StandardError;
import com.lucasrznd.marinkedemandsapi.dtos.request.ReembolsoRequest;
import com.lucasrznd.marinkedemandsapi.dtos.response.ReembolsoResponse;
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

@Tag(name = "ReembolsoController", description = "Controller responsavél por operações de reembolsos")
@RequestMapping("/reembolsos")
public interface ReembolsoController {

    @Operation(summary = "Save new Reembolso")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Reembolso created", content = @Content(
                    mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = ReembolsoResponse.class))),
            @ApiResponse(responseCode = "400", description = "Bad request", content = @Content(
                    mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = StandardError.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content(
                    mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = StandardError.class)))
    })
    @PostMapping
    ResponseEntity<ReembolsoResponse> save(@RequestBody @Valid final ReembolsoRequest request);

    @Operation(summary = "Find all Reembolsos")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Reembolsos founded", content = @Content(
                    mediaType = APPLICATION_JSON_VALUE, array = @ArraySchema(schema = @Schema(implementation = ReembolsoResponse.class)))),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content(
                    mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = StandardError.class)))
    })
    @GetMapping
    ResponseEntity<List<ReembolsoResponse>> findAll();

    @Operation(summary = "Update Reembolso")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Reembolso updated", content = @Content(
                    mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = ReembolsoResponse.class))),
            @ApiResponse(responseCode = "400", description = "Bad request", content = @Content(
                    mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = StandardError.class))),
            @ApiResponse(responseCode = "404", description = "Reembolso not found", content = @Content(
                    mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = StandardError.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content(
                    mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = StandardError.class)))
    })
    @PutMapping("/{id}")
    ResponseEntity<ReembolsoResponse> update(@Parameter(description = "Reembolso Id", required = true, example = "1")
                                             @PathVariable(name = "id") final Long id,
                                             @RequestBody @Valid final ReembolsoRequest request);

    @Operation(summary = "Delete Reembolso")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Reembolso deleted"),
            @ApiResponse(responseCode = "400", description = "Bad request", content = @Content(
                    mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = StandardError.class))),
            @ApiResponse(responseCode = "404", description = "Reembolso not found", content = @Content(
                    mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = StandardError.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content(
                    mediaType = APPLICATION_JSON_VALUE, array = @ArraySchema(schema = @Schema(implementation = StandardError.class))))
    })
    @DeleteMapping("/{id}")
    ResponseEntity<Void> delete(@Parameter(description = "Reembolso Id", required = true, example = "1")
                                @PathVariable(name = "id") final Long id);

}
