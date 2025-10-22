package com.matheus.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

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
    private int ano;
    private String periodo;
//    @JsonIgnore
    @JoinColumn(name = "professor_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Professor professor;
    @JsonIgnore
    @OneToMany(mappedBy = "turma")
    private List<Inscricao> inscricao;

//    @JsonIgnore
    @JoinColumn(name= "disciplina_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Disciplina disciplina;

    public Turma(int ano, String periodo, Professor professor, Disciplina disciplina){
        this.ano = ano;
        this.periodo = periodo;
        this.professor = professor;
        this.disciplina = disciplina;
    }
}
