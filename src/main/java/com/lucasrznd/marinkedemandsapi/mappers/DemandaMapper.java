package com.lucasrznd.marinkedemandsapi.mappers;

import com.lucasrznd.marinkedemandsapi.dtos.request.DemandaRequest;
import com.lucasrznd.marinkedemandsapi.dtos.response.DemandaResponse;
import com.lucasrznd.marinkedemandsapi.entities.Demanda;
import org.mapstruct.*;

@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        uses = {DemandanteMapper.class, TipoProdutoMapper.class, TipoServicoMapper.class, AreaConhecimentoMapper.class})
public interface DemandaMapper {

    @Mapping(target = "nomeDemandante", source = "demandante.nome")
    @Mapping(target = "unidadeDemandante", source = "demandante.unidade")
    @Mapping(target = "tipoProduto", source = "tipoProduto.descricao")
    @Mapping(target = "tipoServico", source = "tipoServico.descricao")
    @Mapping(target = "areaConhecimento", source = "areaConhecimento.descricao")
    DemandaResponse toResponse(final Demanda demanda);

    Demanda toEntity(final DemandaRequest request);

    Demanda update(final DemandaRequest request, @MappingTarget Demanda demanda);

}
