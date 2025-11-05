package com.matheus.model;

import org.springframework.data.domain.Page;

public record TurmaAlunoPaginadoDTO (
        Long id,
        String nome,
        int ano,
        String periodo,
        String professor,
        String disciplina
//        Page<AlunoDTO> alunos
){ }
