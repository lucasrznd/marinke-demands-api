package com.lucasrznd.marinkedemandsapi.mappers;

import com.lucasrznd.marinkedemandsapi.dtos.request.DemandanteRequest;
import com.lucasrznd.marinkedemandsapi.dtos.request.UpdateDemandanteRequest;
import com.lucasrznd.marinkedemandsapi.dtos.response.DemandanteResponse;
import com.lucasrznd.marinkedemandsapi.entities.Demandante;
import org.mapstruct.*;

@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface DemandanteMapper {

    DemandanteResponse toResponse(final Demandante demandante);

    @Mapping(target = "id", ignore = true)
    Demandante toEntity(final DemandanteRequest request);

    Demandante update(final UpdateDemandanteRequest request, @MappingTarget Demandante demandante);

}
