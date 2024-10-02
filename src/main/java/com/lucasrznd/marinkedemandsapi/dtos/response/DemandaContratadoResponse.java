package com.lucasrznd.marinkedemandsapi.dtos.response;

import java.time.LocalDate;

public record DemandaContratadoResponse(Long id,
                                        String idContratacao,
                                        String descricaoTipoProduto,
                                        String nomeContratado,
                                        Integer cargaHoraria,
                                        Double valorPagar,
                                        boolean statusPagamento,
                                        LocalDate dataPagamento) {
}
