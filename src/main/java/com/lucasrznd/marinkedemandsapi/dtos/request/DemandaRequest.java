package com.lucasrznd.marinkedemandsapi.dtos.request;

import com.lucasrznd.marinkedemandsapi.entities.enums.TipoPrestacaoServico;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record DemandaRequest(
        @Schema(description = "Código de Contratação", example = "SP062")
        @NotBlank(message = "Código de Contratação não pode ser vazio")
        @Size(max = 100, message = "Código de Contratação deve conter no máximo 100 caracteres")
        String idContratacao,

        @Schema(description = "Número do Contrato", example = "4070")
        @NotNull(message = "Número do Contrato não pode ser nulo")
        int numeroContrato,

        @Schema(description = "Data do Contrato", example = "2024-06-01")
        @NotNull(message = "Data do Contrato não pode ser nula")
        LocalDate dataContrato,

        @Schema(description = "Demandante", example = "id: 1")
        @NotNull(message = "Demandante não pode ser nulo")
        Long demandanteId,

        @Schema(description = "Nome do Responsavél", example = "Jorge")
        @NotBlank(message = "Nome do Responsavél não pode ser vazio")
        @Size(max = 100, message = "Nome do Responsavél deve conter no máximo 100 caracteres")
        String nomeResponsavel,

        @Schema(description = "Publico Alvo", example = "App de Controle Financeiro")
        @NotBlank(message = "Publico Alvo não pode ser vazio")
        String publicoAlvo,

        @Schema(description = "Tipo de Produto", example = "id: 1")
        @NotNull(message = "Tipo de Produto não pode ser nulo")
        Long tipoProdutoId,

        @Schema(description = "Descrição do Produto", example = "Descrição detalhada do Produto")
        String descricaoProduto,

        @Schema(description = "Tipo de Serviço", example = "id: 1")
        @NotNull(message = "Tipo de Serviço não pode ser nulo")
        Long tipoServicoId,

        @Schema(description = "Area de Conhecimento", example = "id: 1")
        @NotNull(message = "Area de Conhecimento não pode ser nula")
        Long areaConhecimentoId,

        @Schema(description = "Tipo de Prestação de Servico", example = "REMOTO")
        @NotNull(message = "Tipo de Prestação de Servico não pode ser nulo")
        TipoPrestacaoServico tipoPrestacaoServico,

        @Schema(description = "Carga Horária", example = "20")
        @NotNull(message = "Carga Horária não pode ser nula")
        int cargaHoraria,

        @Schema(description = "Status do Contrato", example = "true")
        @NotNull(message = "Status do Contrato não pode ser nulo")
        Boolean statusContrato) {
}
