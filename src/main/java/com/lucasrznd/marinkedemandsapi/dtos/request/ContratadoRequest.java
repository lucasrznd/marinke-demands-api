package com.lucasrznd.marinkedemandsapi.dtos.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record ContratadoRequest(
        @Schema(description = "Nome do Contratado", example = "Rogerio Marinke")
        @NotBlank(message = "Nome do Contratado não pode ser vazio")
        @Size(min = 3, max = 100, message = "Nome do Contratado deve conter entre 3 e 100 caracteres")
        String nome,

        @Schema(description = "Telefone", example = "14988887777")
        @Size(min = 10, max = 11, message = "Telefone deve conter entre 10 e 11 caracteres")
        String telefone,

        @Schema(description = "Email", example = "marinke@gmail.com")
        @Email(message = "Email inválido")
        @Size(min = 10, max = 100, message = "Email deve conter entre 10 e 100 caracteres")
        String email) {
}
