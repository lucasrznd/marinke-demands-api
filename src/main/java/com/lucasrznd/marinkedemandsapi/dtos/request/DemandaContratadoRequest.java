package com.lucasrznd.marinkedemandsapi.dtos.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record DemandaContratadoRequest(
        @Schema(description = "Código de Contratação", example = "SP062")
        @NotBlank(message = "Código de Contratação não pode ser vazio")
        String idContratacao,

        @Schema(description = "Código do Contratado", example = "1")
        @NotNull(message = "Código do Contratado não pode ser vazio")
        Long contratadoId,

        @Schema(description = "Carga Horária", example = "10")
        @NotNull(message = "Carga Horária não pode ser vazio")
        Integer cargaHoraria,

        @Schema(description = "Valor a Pagar", example = "500")
        @NotNull(message = "Valor a Pagar não pode ser vazio")
        Double valorPagar,

        @Schema(description = "Status do Pagamento", example = "true")
        boolean statusPagamento,

        @Schema(description = "Data de Pagamento", example = "2024-17-09")
        LocalDate dataPagamento) {
}
