package com.lucasrznd.marinkedemandsapi.entities;

import com.lucasrznd.marinkedemandsapi.entities.enums.TipoPrestacaoServico;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_demanda")
public class Demanda {

    @Id
    private String idContratacao;
    private int numeroContrato;
    private LocalDate dataContrato;

    @ManyToOne
    private Demandante demandante;
    private String nomeResponsavel;
    private String publicoAlvo;

    @ManyToOne
    private TipoProduto tipoProduto;

    private String descricaoProduto;

    @ManyToOne
    private TipoServico tipoServico;

    @ManyToOne
    private AreaConhecimento areaConhecimento;

    @Enumerated(EnumType.STRING)
    private TipoPrestacaoServico tipoPrestacaoServico;
    private int cargaHoraria;
    private Boolean statusContrato;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "demanda")
    private List<Agendamento> agendamentos;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "demanda")
    private List<Reembolso> reembolsos;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "demanda")
    private List<DemandaContratado> contratados;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "demanda")
    private List<NotaFiscal> notasFiscais;

}
