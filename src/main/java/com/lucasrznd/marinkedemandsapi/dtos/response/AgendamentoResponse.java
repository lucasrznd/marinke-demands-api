package com.lucasrznd.marinkedemandsapi.dtos.response;

import java.time.LocalDate;

public record AgendamentoResponse(Long id,
                                  String idContratacao,
                                  String raTurma,
                                  String dataHoraPrevista,
                                  String dataHoraExecucao,
                                  String endereco,
                                  Double valorReceber,
                                  boolean statusPagamento,
                                  LocalDate dataPagamento) {
}
