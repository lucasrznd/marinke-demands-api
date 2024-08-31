package com.lucasrznd.marinkedemandsapi.controllers;

import com.lucasrznd.marinkedemandsapi.controllers.exceptions.StandardError;
import com.lucasrznd.marinkedemandsapi.dtos.request.DemandanteRequest;
import com.lucasrznd.marinkedemandsapi.dtos.request.UpdateDemandanteRequest;
import com.lucasrznd.marinkedemandsapi.dtos.response.DemandanteResponse;
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

@Tag(name = "DemandanteController", description = "Controller responsavél por operações de demandantes")
@RequestMapping("/demandantes")
public interface DemandanteController {

    @Operation(summary = "Save new demandante")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Demandante created", content = @Content(
                    mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = DemandanteResponse.class))),
            @ApiResponse(responseCode = "400", description = "Bad request", content = @Content(
                    mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = DemandanteResponse.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content(
                    mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = DemandanteResponse.class)))
    })
    @PostMapping
    ResponseEntity<DemandanteResponse> save(@RequestBody @Valid final DemandanteRequest request);

    @Operation(summary = "Find all demandantes")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Demandantes founded", content = @Content(
                    mediaType = APPLICATION_JSON_VALUE, array = @ArraySchema(schema = @Schema(implementation = DemandanteResponse.class)))),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content(
                    mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = StandardError.class)))
    })
    @GetMapping
    ResponseEntity<List<DemandanteResponse>> findAll();

    @Operation(summary = "Update demandante")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Demandante updated", content = @Content(
                    mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = DemandanteResponse.class))),
            @ApiResponse(responseCode = "400", description = "Bad request", content = @Content(
                    mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = StandardError.class))),
            @ApiResponse(responseCode = "404", description = "Demandante not found", content = @Content(
                    mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = StandardError.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content(
                    mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = StandardError.class)))
    })
    @PutMapping("/{id}")
    ResponseEntity<DemandanteResponse> update(@Parameter(description = "Demandante Id", required = true, example = "1")
                                              @PathVariable(name = "id") final Long id,
                                              @RequestBody @Valid final UpdateDemandanteRequest request);

    @Operation(summary = "Delete demandante")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Demandante deleted"),
            @ApiResponse(responseCode = "400", description = "Bad request", content = @Content(
                    mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = StandardError.class))),
            @ApiResponse(responseCode = "404", description = "Demandante not found", content = @Content(
                    mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = StandardError.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content(
                    mediaType = APPLICATION_JSON_VALUE, array = @ArraySchema(schema = @Schema(implementation = StandardError.class))))
    })
    @DeleteMapping("/{id}")
    ResponseEntity<Void> delete(@Parameter(description = "Demandante Id", required = true, example = "1")
                                @PathVariable(name = "id") final Long id);

}
