package com.matheus.model;
import com.matheus.model.Turma;

import java.util.List;

public record DisciplinaTurmaDTO(
        Long id,
        String nome,
        int cargaHoraria,
        List<Turma> turma) {
}
