package com.lucasrznd.marinkedemandsapi.mappers;

import com.lucasrznd.marinkedemandsapi.dtos.request.TipoProdutoRequest;
import com.lucasrznd.marinkedemandsapi.dtos.response.TipoProdutoResponse;
import com.lucasrznd.marinkedemandsapi.entities.TipoProduto;
import org.mapstruct.*;

@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface TipoProdutoMapper {

    TipoProdutoResponse toResponse(final TipoProduto tipoProduto);

    @Mapping(target = "id", ignore = true)
    TipoProduto toEntity(final TipoProdutoRequest request);

    TipoProduto update(final TipoProdutoRequest request, @MappingTarget TipoProduto tipoProduto);

}
