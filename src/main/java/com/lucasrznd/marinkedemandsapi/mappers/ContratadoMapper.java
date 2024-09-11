package com.lucasrznd.marinkedemandsapi.mappers;

import com.lucasrznd.marinkedemandsapi.dtos.request.ContratadoRequest;
import com.lucasrznd.marinkedemandsapi.dtos.response.ContratadoResponse;
import com.lucasrznd.marinkedemandsapi.entities.Contratado;
import org.mapstruct.*;

@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface ContratadoMapper {

    ContratadoResponse toResponse(final Contratado contratado);

    @Mapping(target = "id", ignore = true)
    Contratado toEntity(final ContratadoRequest request);

    Contratado update(final ContratadoRequest request, @MappingTarget Contratado contratado);

}
