package com.lucasrznd.marinkedemandsapi.dtos.request;

import com.lucasrznd.marinkedemandsapi.dtos.response.ContratadoResponse;
import com.lucasrznd.marinkedemandsapi.dtos.response.DemandaResponse;
import com.lucasrznd.marinkedemandsapi.dtos.response.TipoReembolsoResponse;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record ReembolsoRequest(
        @Schema(description = "Tipo de Reembolso", example = "{id: 1, descricao: Combustivel}")
        @NotNull(message = "Tipo Reembolso não pode ser nulo")
        TipoReembolsoResponse tipoReembolso,

        @Schema(description = "Demanda", example = "{id: 1, numeroContrato: 4070, dataContrato: 2024-17-09...}")
        @NotNull(message = "Demanda não pode ser nula")
        DemandaResponse demanda,

        @Schema(description = "Data da Atividade", example = "2024-17-09")
        @NotNull(message = "Data não pode ser nula")
        LocalDate dataAtividade,

        @Schema(description = "Valor do Reembolso", example = "50.5")
        @NotNull(message = "Valor do Reembolso não pode ser nulo")
        Double valor,

        @Schema(description = "Contratado", example = "{id: 1, nome: Rogerio Marinke, telefone: 14988887777, email: marinke@gmail.com}")
        @NotNull(message = "Contratado não pode ser nulo")
        ContratadoResponse contratado,

        @Schema(description = "Link do Comprovante")
        String linkComprovante) {
}
