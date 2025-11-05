package com.matheus.model;

import org.springframework.data.domain.Page;

import java.util.List;

public record TurmaAlunoPaginadoDTO (
        Long id,
        String nome,
        int ano,
        String periodo,
        String professor,
        String disciplina,
        List<AlunoDTO> alunos
){ }
