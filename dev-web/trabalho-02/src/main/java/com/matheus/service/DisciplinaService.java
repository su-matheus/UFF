package com.matheus.service;

import com.matheus.model.Disciplina;
import com.matheus.repository.DisciplinaRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class DisciplinaService {
    private final DisciplinaRepository disciplinaRepository;

    @Transactional
    public Disciplina cadastrarDisciplina(Disciplina disciplina) {
        return disciplinaRepository.save(disciplina);
    }

    public void removerDisciplinaPorId(Long id){
        disciplinaRepository.deleteById(id);
    }
}
