package com.lucasrznd.marinkedemandsapi.dtos.response;

public record DemandanteResponse(Long id,
                                 String nome,
                                 String unidade,
                                 String telefone,
                                 String email) {
}
