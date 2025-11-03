package com.matheus.service;

import com.matheus.exception.EntidadeNaoEncontradaException;
import com.matheus.model.Professor;
import com.matheus.model.ProfessorDTO;
import com.matheus.repository.ProfessorRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ProfessorService {
    private final ProfessorRepository professorRepository;

    public List<ProfessorDTO> recuperarProfessores() {
        return professorRepository.findAll()
                .stream()
                .map(p -> new ProfessorDTO(
                        p.getId(),
                        p.getNome(),
                        p.getEmail()
                ))
                .toList();
    }

    public Professor cadastrarProfessor(Professor professor) {
        return professorRepository.save(professor);
    }

    @Transactional
    public Professor alterarProfessor(Professor professor) {
        professorRepository.recuperarProfessorPorIdComLock(professor.getId())
                .orElseThrow(() -> new EntidadeNaoEncontradaException(
                        "Professor com id = " + professor.getId() + " não encontrado."));
        return professorRepository.save(professor);
    }


    public Professor recuperarProfessorPorIdSemTurma(Long id) {
        return professorRepository.recuperarProfessorPorIdSemTurma(id)
                .orElseThrow(() -> new EntidadeNaoEncontradaException(
                        "Professor com id = " + id + " não encontrado."));
    }


    public Professor recuperarProfessorPorId(Long id) {
        return professorRepository.recuperarProfessorPorIdSemLock(id)
                .orElseThrow(() -> new EntidadeNaoEncontradaException(
                        "Professor com id = " + id + " não encontrado."));
    }

    public void removerProfessorPorId(Long id){
        professorRepository.deleteById(id);
    }

}
