package com.lucasrznd.marinkedemandsapi.dtos.response;

public record NotaFiscalResponse(Long id,
                                 String idContratacao,
                                 String descricaoTipoProduto,
                                 String nomeDemandante,
                                 String numeroNf) {
}
