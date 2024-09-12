package com.lucasrznd.marinkedemandsapi.dtos.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record AreaConhecimentoRequest(
        @Schema(description = "Descrição", example = "Marketing e Vendas")
        @NotBlank(message = "Descrição não pode ser vazio")
        @Size(max = 100, message = "Descrição deve conter no máximo 100 caracteres")
        String descricao) {
}
