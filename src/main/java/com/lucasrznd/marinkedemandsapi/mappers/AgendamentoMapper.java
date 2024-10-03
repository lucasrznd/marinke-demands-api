package com.lucasrznd.marinkedemandsapi.mappers;

import com.lucasrznd.marinkedemandsapi.dtos.request.AgendamentoRequest;
import com.lucasrznd.marinkedemandsapi.dtos.response.AgendamentoResponse;
import com.lucasrznd.marinkedemandsapi.entities.Agendamento;
import org.mapstruct.*;

@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        uses = {DemandaMapper.class})
public interface AgendamentoMapper {

    @Mapping(target = "idContratacao", source = "demanda.idContratacao")
    AgendamentoResponse toResponse(final Agendamento agendamento);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "demanda.idContratacao", source = "idContratacao")
    Agendamento toEntity(final AgendamentoRequest request);

    Agendamento update(final AgendamentoRequest request, @MappingTarget Agendamento agendamento);

}
