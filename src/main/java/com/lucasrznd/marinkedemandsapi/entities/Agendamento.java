package com.lucasrznd.marinkedemandsapi.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_agendamento")
public class Agendamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Demanda demanda;

    private String raTurma;
    private String dataHoraPrevista;
    private String dataHoraExecucao;
    private String endereco;
    private Double valorReceber;
    private boolean statusPagamento;
    private LocalDate dataPagamento;

}
