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
@Table(name = "tb_demanda_contratado")
public class DemandaContratado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Demanda demanda;

    @ManyToOne
    private Contratado contratado;

    private Integer cargaHoraria;
    private Double valorPagar;
    private Boolean statusPagamento;
    private LocalDate dataPagamento;

}
