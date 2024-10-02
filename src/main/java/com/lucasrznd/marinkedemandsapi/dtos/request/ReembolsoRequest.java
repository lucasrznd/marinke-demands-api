package com.lucasrznd.marinkedemandsapi.dtos.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record ReembolsoRequest(
        @Schema(description = "Tipo de Reembolso", example = "id: 1")
        @NotNull(message = "Tipo Reembolso não pode ser nulo")
        Long tipoReembolsoId,

        @Schema(description = "Demanda", example = "id: 1")
        @NotNull(message = "Demanda não pode ser nula")
        String demandaId,

        @Schema(description = "Data da Atividade", example = "2024-17-09")
        @NotNull(message = "Data não pode ser nula")
        LocalDate dataAtividade,

        @Schema(description = "Valor do Reembolso", example = "50.5")
        @NotNull(message = "Valor do Reembolso não pode ser nulo")
        Double valor,

        @Schema(description = "Contratado", example = "id: 1")
        Long contratadoId,

        @Schema(description = "Link do Comprovante")
        String linkComprovante) {
}
