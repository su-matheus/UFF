package com.matheus.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@ToString

@Entity
public class Inscricao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @CreationTimestamp
    private LocalDateTime dataHora;
//    @JsonIgnore
    @JsonIgnoreProperties("inscricao") // Evita recursão
    @JoinColumn(name = "aluno_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Aluno aluno;
    @JsonIgnore
    @JoinColumn(name = "turma_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Turma turma;


    public Inscricao(Aluno aluno, Turma turma){
        this.aluno = aluno;
        this.turma = turma;
    }
}
