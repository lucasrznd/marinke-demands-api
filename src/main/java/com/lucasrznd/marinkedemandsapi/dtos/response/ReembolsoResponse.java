package com.lucasrznd.marinkedemandsapi.dtos.response;

import java.time.LocalDate;

public record ReembolsoResponse(Long id,
                                String tipoReembolsoDescricao,
                                int numeroContrato,
                                LocalDate dataAtividade,
                                Double valor,
                                String nomeContratado,
                                String linkComprovante) {
}
