package com.lucasrznd.marinkedemandsapi.dtos.response;

import java.util.List;

public record ContratadoResponse(Long id,
                                 String nome,
                                 String telefone,
                                 String email,
                                 List<DemandaContratadoResponse> demandas) {
}
