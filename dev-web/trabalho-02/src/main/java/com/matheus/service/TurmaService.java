package com.matheus.service;

import com.matheus.exception.EntidadeNaoEncontradaException;
import com.matheus.model.Disciplina;
import com.matheus.model.Turma;
import com.matheus.model.Professor;
import com.matheus.model.TurmaDTO;
import com.matheus.repository.DisciplinaRepository;
import com.matheus.repository.TurmaRepository;
import com.matheus.repository.ProfessorRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class TurmaService {
    private final TurmaRepository turmaRepository;
    private final ProfessorRepository professorRepository;
    private final DisciplinaRepository disciplinaRepository;

    public List<Turma> recuperarTurmas() {
        return turmaRepository.recuperarTurmas();
    }

    @Transactional
    public Turma cadastrarTurma(TurmaDTO turmaDTO){
        Professor professor = professorRepository.findById(turmaDTO.getProfessorId()).
                orElseThrow(() -> new EntidadeNaoEncontradaException(
                        "Professor com id = " + turmaDTO.getProfessorId() + "não encontrado."
                ));

        Disciplina disciplina = disciplinaRepository.findById(turmaDTO.getDisciplinaId()).
                orElseThrow(() -> new EntidadeNaoEncontradaException(
                        "Disciplina com id = " + turmaDTO.getDisciplinaId() + "não encontrado."
                ));

        Turma turma = new Turma(turmaDTO.getAno(), turmaDTO.getPeriodo(), professor, disciplina);
        return turmaRepository.save(turma);
    }

    @Transactional
    public void removerTurmaPorId(Long id){
        if (!turmaRepository.existsById(id)){
            throw new EntidadeNaoEncontradaException(
                    "Turma com id = " + id + "não encontrada."
            );
        }
        turmaRepository.deleteById(id);
    }

}
