package com.matheus.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@ToString


@Entity
public class Disciplina {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String cargaHoraria;
    @JsonIgnoreProperties("disciplina")
    @OneToMany(mappedBy = "disciplina")
    private List<Turma> turma;


    public Disciplina(String nome, String cargaHoraria){
        this.nome = nome;
        this.cargaHoraria = cargaHoraria;
        this.turma = new ArrayList<>();
    }

}
