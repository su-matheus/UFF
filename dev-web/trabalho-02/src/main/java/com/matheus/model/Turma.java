package com.matheus.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class Turma {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private int ano;
    private String periodo;

    @JoinColumn(name = "professor_id")
    @ManyToOne
    private Professor professor;

    @JoinColumn(name = "disciplina_id")
    @ManyToOne
    private Disciplina disciplina;

    @JsonIgnore
    @OneToMany(mappedBy = "turma", cascade = CascadeType.ALL)
    private List<Inscricao> inscricao;

    public Turma(String nome, int ano, String periodo, Professor professor, Disciplina disciplina){
        this.nome = nome;
        this.ano = ano;
        this.periodo = periodo;
        this.professor = professor;
        this.disciplina = disciplina;

        this.inscricao = new ArrayList<>();
    }
}
