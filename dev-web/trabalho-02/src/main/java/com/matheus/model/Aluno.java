package com.matheus.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import com.matheus.model.Inscricao;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@ToString

@Entity
public class Aluno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String slug;
    private String email;
//    @JsonIgnore
    @JsonIgnoreProperties("aluno") // Em vez de @JsonIgnore
    @OneToMany(mappedBy = "aluno")
    private List<Inscricao> inscricao;


    public Aluno(String nome, String slug, String email){
        this.nome = nome;
        this.slug = slug;
        this.email = email;
        this.inscricao = new ArrayList<>();
    }

}
