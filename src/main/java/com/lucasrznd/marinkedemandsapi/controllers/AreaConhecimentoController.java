package com.lucasrznd.marinkedemandsapi.controllers;

import com.lucasrznd.marinkedemandsapi.controllers.exceptions.StandardError;
import com.lucasrznd.marinkedemandsapi.dtos.request.AreaConhecimentoRequest;
import com.lucasrznd.marinkedemandsapi.dtos.response.AreaConhecimentoResponse;
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

@Tag(name = "AreaConhecimentoController", description = "Controller responsavél por operações de áreas de conhecimento")
@RequestMapping("/areas-conhecimento")
public interface AreaConhecimentoController {

    @Operation(summary = "Save new area conhecimento")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Area Conhecimento created", content = @Content(
                    mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = AreaConhecimentoResponse.class))),
            @ApiResponse(responseCode = "400", description = "Bad request", content = @Content(
                    mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = StandardError.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content(
                    mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = StandardError.class)))
    })
    @PostMapping
    ResponseEntity<AreaConhecimentoResponse> save(@RequestBody @Valid final AreaConhecimentoRequest request);

    @Operation(summary = "Find all Areas Conhecimento")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Areas Conhecimento founded", content = @Content(
                    mediaType = APPLICATION_JSON_VALUE, array = @ArraySchema(schema = @Schema(implementation = AreaConhecimentoResponse.class)))),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content(
                    mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = StandardError.class)))
    })
    @GetMapping
    ResponseEntity<List<AreaConhecimentoResponse>> findAll();

    @Operation(summary = "Update Area Conhecimento")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Area Conhecimento updated", content = @Content(
                    mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = AreaConhecimentoResponse.class))),
            @ApiResponse(responseCode = "400", description = "Bad request", content = @Content(
                    mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = StandardError.class))),
            @ApiResponse(responseCode = "404", description = "Area Conhecimento not found", content = @Content(
                    mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = StandardError.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content(
                    mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = StandardError.class)))
    })
    @PutMapping("/{id}")
    ResponseEntity<AreaConhecimentoResponse> update(@Parameter(description = "Area Conhecimento Id", required = true, example = "1")
                                                    @PathVariable(name = "id") final Long id,
                                                    @RequestBody @Valid final AreaConhecimentoRequest request);

    @Operation(summary = "Delete Area Conhecimento")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Area Conhecimento deleted"),
            @ApiResponse(responseCode = "400", description = "Bad request", content = @Content(
                    mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = StandardError.class))),
            @ApiResponse(responseCode = "404", description = "Area Conhecimento not found", content = @Content(
                    mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = StandardError.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content(
                    mediaType = APPLICATION_JSON_VALUE, array = @ArraySchema(schema = @Schema(implementation = StandardError.class))))
    })
    @DeleteMapping("/{id}")
    ResponseEntity<Void> delete(@Parameter(description = "Area Conhecimento Id", required = true, example = "1")
                                @PathVariable(name = "id") final Long id);


}
