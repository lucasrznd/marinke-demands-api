package com.lucasrznd.marinkedemandsapi.dtos.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record AgendamentoRequest(
        @Schema(description = "Código de Contratação", example = "SP062")
        @NotBlank(message = "Código de Contratação não pode ser vazio")
        String idContratacao,

        @Schema(description = "Ra da Turma", example = "T1")
        String raTurma,

        @Schema(description = "Data e Hora Prevista", example = "02/set 18h30m as 19h30")
        String dataHoraPrevista,

        @Schema(description = "Data e Hora Execucao", example = "02/set 18h30m as 19h30")
        String dataHoraExecucao,

        @Schema(description = "Endereço", example = "Rua Exemplo, 141, Centro, Ourinhos")
        String endereco,

        @Schema(description = "Valor a Receber", example = "1000")
        @NotNull(message = "Valor a Receber não pode ser nulo")
        Double valorReceber,

        @Schema(description = "Status do Pagamento", example = "false")
        boolean statusPagamento,

        @Schema(description = "Data de Pagamento", example = "2024-10-02")
        LocalDate dataPagamento) {
}
