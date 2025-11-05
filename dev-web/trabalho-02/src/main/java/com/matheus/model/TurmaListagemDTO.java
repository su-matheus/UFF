package com.matheus.model;

public record TurmaListagemDTO(
        Long id,
        String nome,
        int ano,
        String periodo,
        String professor,
        String disciplina
) {
}
