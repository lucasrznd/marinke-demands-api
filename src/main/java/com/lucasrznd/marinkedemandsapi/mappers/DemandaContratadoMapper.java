package com.lucasrznd.marinkedemandsapi.mappers;

import com.lucasrznd.marinkedemandsapi.dtos.request.DemandaContratadoRequest;
import com.lucasrznd.marinkedemandsapi.dtos.response.DemandaContratadoResponse;
import com.lucasrznd.marinkedemandsapi.entities.DemandaContratado;
import org.mapstruct.*;

@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        uses = {DemandaMapper.class, ContratadoMapper.class})
public interface DemandaContratadoMapper {

    @Mapping(target = "idContratacao", source = "demanda.idContratacao")
    @Mapping(target = "nomeContratado", source = "contratado.nome")
    @Mapping(target = "descricaoTipoProduto", source = "demanda.tipoProduto.descricao")
    DemandaContratadoResponse toResponse(final DemandaContratado demandaContratado);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "demanda.idContratacao", source = "idContratacao")
    @Mapping(target = "contratado.id", source = "contratadoId")
    DemandaContratado toEntity(final DemandaContratadoRequest request);

    @Mapping(target = "demanda.idContratacao", source = "idContratacao")
    @Mapping(target = "contratado.id", source = "contratadoId")
    DemandaContratado update(final DemandaContratadoRequest request, @MappingTarget DemandaContratado demandaContratado);

}
