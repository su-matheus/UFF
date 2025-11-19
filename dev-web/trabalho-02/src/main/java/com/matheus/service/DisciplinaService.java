package com.matheus.service;

import com.matheus.model.Disciplina;
import com.matheus.model.DisciplinaDTO;
import com.matheus.model.DisciplinaTurmaDTO;
import com.matheus.repository.DisciplinaRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


@RequiredArgsConstructor
@Service
public class DisciplinaService {
    private final DisciplinaRepository disciplinaRepository;

    public List<DisciplinaDTO> recuperarDisciplinas(){
        return disciplinaRepository.findAll()
                .stream()
                .map(d -> new DisciplinaDTO(
                        d.getId(),
                        d.getNome(),
                        d.getCargaHoraria()
                ))
                .toList();
    }

    public List<DisciplinaTurmaDTO> recuperarPorTurma(Long turmaId) {
        List<Disciplina> disciplinas = disciplinaRepository.findByTurmaId(turmaId);

        return disciplinas.stream()
                .map(d -> new DisciplinaTurmaDTO(
                        d.getId(),
                        d.getNome(),
                        d.getCargaHoraria(),
                        d.getTurma()
                ))
                .toList();
    }

    @Transactional
    public Disciplina cadastrarDisciplina(Disciplina disciplina) {
        return disciplinaRepository.save(disciplina);
    }

    public void removerDisciplinaPorId(Long id){
        disciplinaRepository.deleteById(id);
    }
}
