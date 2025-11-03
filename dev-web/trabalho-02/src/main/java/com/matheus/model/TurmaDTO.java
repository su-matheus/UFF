package com.matheus.model;


public record TurmaDTO(
        Long id,
        String nome,
        int ano,
        String periodo,
        Professor professor,
        Disciplina disciplina
//        Long professorId,
//        Long disciplinaId
) {
}
