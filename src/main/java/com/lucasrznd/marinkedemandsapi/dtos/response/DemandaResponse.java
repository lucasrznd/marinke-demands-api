package com.lucasrznd.marinkedemandsapi.dtos.response;

import com.lucasrznd.marinkedemandsapi.entities.enums.TipoPrestacaoServico;

import java.time.LocalDate;

public record DemandaResponse(String idContratacao,
                              int numeroContrato,
                              LocalDate dataContrato,
                              String nomeDemandante,
                              String unidadeDemandante,
                              String nomeResponsavel,
                              String publicoAlvo,
                              String tipoProduto,
                              String descricaoProduto,
                              String tipoServico,
                              String areaConhecimento,
                              TipoPrestacaoServico tipoPrestacaoServico,
                              int cargaHoraria,
                              Boolean statusContrato) {
}
