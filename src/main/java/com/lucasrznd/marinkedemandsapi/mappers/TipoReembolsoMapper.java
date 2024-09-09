package com.lucasrznd.marinkedemandsapi.mappers;

import com.lucasrznd.marinkedemandsapi.dtos.request.TipoReembolsoRequest;
import com.lucasrznd.marinkedemandsapi.dtos.response.TipoReembolsoResponse;
import com.lucasrznd.marinkedemandsapi.entities.TipoReembolso;
import org.mapstruct.*;

@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface TipoReembolsoMapper {

    TipoReembolsoResponse toResponse(final TipoReembolso tipoReembolso);

    @Mapping(target = "id", ignore = true)
    TipoReembolso toEntity(final TipoReembolsoRequest request);

    TipoReembolso update(TipoReembolsoRequest request, @MappingTarget TipoReembolso tipoReembolso);

}
