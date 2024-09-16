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
@Table(name = "tb_reembolso")
public class Reembolso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private TipoReembolso tipoReembolso;

    @ManyToOne
    private Demanda demanda;
    private LocalDate dataAtividade;
    private Double valor;

    @ManyToOne
    private Contratado contratado;

    @Column(columnDefinition = "TEXT")
    private String linkComprovante;

}
