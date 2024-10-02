package com.lucasrznd.marinkedemandsapi.mappers;

import com.lucasrznd.marinkedemandsapi.dtos.request.NotaFiscalRequest;
import com.lucasrznd.marinkedemandsapi.dtos.response.NotaFiscalResponse;
import com.lucasrznd.marinkedemandsapi.entities.NotaFiscal;
import org.mapstruct.*;

@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        uses = {DemandaMapper.class})
public interface NotaFiscalMapper {

    @Mapping(target = "idContratacao", source = "demanda.idContratacao")
    @Mapping(target = "descricaoTipoProduto", source = "demanda.tipoProduto.descricao")
    @Mapping(target = "nomeDemandante", source = "demanda.demandante.nome")
    NotaFiscalResponse toResponse(final NotaFiscal notaFiscal);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "demanda.idContratacao", source = "idContratacao")
    NotaFiscal toEntity(final NotaFiscalRequest request);

    @Mapping(target = "demanda.idContratacao", source = "idContratacao")
    NotaFiscal update(final NotaFiscalRequest request, @MappingTarget NotaFiscal notaFiscal);

}
