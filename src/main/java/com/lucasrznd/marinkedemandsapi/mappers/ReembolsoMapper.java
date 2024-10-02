package com.lucasrznd.marinkedemandsapi.mappers;

import com.lucasrznd.marinkedemandsapi.dtos.request.ReembolsoRequest;
import com.lucasrznd.marinkedemandsapi.dtos.response.ReembolsoResponse;
import com.lucasrznd.marinkedemandsapi.entities.Reembolso;
import org.mapstruct.*;

@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        uses = {DemandaMapper.class})
public interface ReembolsoMapper {

    @Mapping(target = "tipoReembolsoDescricao", source = "tipoReembolso.descricao")
    @Mapping(target = "numeroContrato", source = "demanda.numeroContrato")
    @Mapping(target = "nomeContratado", source = "contratado.nome")
    ReembolsoResponse toResponse(final Reembolso reembolso);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "tipoReembolso.id", source = "tipoReembolsoId")
    @Mapping(target = "demanda.idContratacao", source = "demandaId")
    @Mapping(target = "contratado.id", source = "contratadoId")
    Reembolso toEntity(final ReembolsoRequest request);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "tipoReembolso.id", source = "tipoReembolsoId")
    @Mapping(target = "demanda.idContratacao", source = "demandaId")
    @Mapping(target = "contratado.id", source = "contratadoId")
    Reembolso update(final ReembolsoRequest request, @MappingTarget Reembolso reembolso);

}
