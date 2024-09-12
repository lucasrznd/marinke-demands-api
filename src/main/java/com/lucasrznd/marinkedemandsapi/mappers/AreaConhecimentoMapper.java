package com.lucasrznd.marinkedemandsapi.mappers;

import com.lucasrznd.marinkedemandsapi.dtos.request.AreaConhecimentoRequest;
import com.lucasrznd.marinkedemandsapi.dtos.response.AreaConhecimentoResponse;
import com.lucasrznd.marinkedemandsapi.entities.AreaConhecimento;
import org.mapstruct.*;

@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface AreaConhecimentoMapper {

    AreaConhecimentoResponse toResponse(final AreaConhecimento areaConhecimento);

    @Mapping(target = "id", ignore = true)
    AreaConhecimento toEntity(final AreaConhecimentoRequest request);

    AreaConhecimento update(final AreaConhecimentoRequest request, @MappingTarget AreaConhecimento areaConhecimento);

}
