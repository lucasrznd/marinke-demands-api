package com.lucasrznd.marinkedemandsapi.dtos.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

public record NotaFiscalRequest(
        @Schema(description = "Código de Contratação", example = "SP062")
        @NotBlank(message = "Código de Contratação não pode ser vazio")
        String idContratacao,

        @Schema(description = "Numero da NF", example = "5500112345")
        @NotBlank(message = "Numero da NF não pode ser vazio")
        String numeroNf) {
}
