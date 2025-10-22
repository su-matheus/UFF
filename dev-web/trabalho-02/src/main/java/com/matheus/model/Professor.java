package com.matheus.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import com.matheus.model.Turma;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@ToString


@Entity
public class Professor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String slug;
    private String email;
    @JsonIgnoreProperties("professor")
    @OneToMany(mappedBy = "professor")
    private List<Turma> turma;


    public Professor(String nome, String slug, String email){
        this.nome = nome;
        this.slug = slug;
        this.email = email;
        this.turma = new ArrayList<>();
    }

}
