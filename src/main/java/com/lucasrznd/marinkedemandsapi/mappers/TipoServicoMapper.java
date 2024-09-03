package com.lucasrznd.marinkedemandsapi.mappers;

import com.lucasrznd.marinkedemandsapi.dtos.request.TipoServicoRequest;
import com.lucasrznd.marinkedemandsapi.dtos.response.TipoServicoResponse;
import com.lucasrznd.marinkedemandsapi.entities.TipoServico;
import org.mapstruct.*;

@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface TipoServicoMapper {

    TipoServicoResponse toResponse(final TipoServico tipoServico);

    @Mapping(target = "id", ignore = true)
    TipoServico toEntity(final TipoServicoRequest request);

    TipoServico update(TipoServicoRequest request, @MappingTarget TipoServico tipoServico);

}
