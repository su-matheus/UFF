package com.matheus.service;

import com.matheus.exception.EntidadeNaoEncontradaException;
import com.matheus.model.Aluno;
import com.matheus.model.AlunoDTO;
import com.matheus.repository.AlunoRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AlunoService {
    private final AlunoRepository alunoRepository;

    public List<AlunoDTO> recuperarAlunos() {
        return alunoRepository.findAll()
                .stream()
                .map(a -> new AlunoDTO(
                        a.getId(),
                        a.getNome(),
                        a.getEmail()
                ))
                .toList();
    }

    public Aluno cadastrarAluno(Aluno aluno) {
        return alunoRepository.save(aluno);
    }

    @Transactional
    public Aluno alterarAluno(Aluno aluno) {
        alunoRepository.recuperarAlunoPorIdComLock(aluno.getId())
                .orElseThrow(() -> new EntidadeNaoEncontradaException(
                        "Aluno com id = " + aluno.getId() + " não encontrado."));
        return alunoRepository.save(aluno);
    }


    public List<AlunoDTO> recuperarPorTurma(Long turmaId) {
        List<Aluno> alunos = alunoRepository.findByTurmaId(turmaId);

        return alunos.stream()
                .map(a -> new AlunoDTO(
                        a.getId(),
                        a.getNome(),
                        a.getEmail()
                ))
                .toList();
    }


    public Aluno recuperarAlunoPorIdComInscricao(Long id) {
        Aluno aluno = alunoRepository.findById(id)
                .orElseThrow(() -> new EntidadeNaoEncontradaException(
                        "Aluno com id = " + id + " não encontrado."));

        // Inicializa a coleção lazy
        aluno.getInscricao().size();

        return aluno;

    };

    public Aluno recuperarAlunoPorIdSemInscricao(Long id) {
        return alunoRepository.recuperarAlunoPorIdSemInscricao(id)
                .orElseThrow(() -> new EntidadeNaoEncontradaException(
                        "Produto com id = " + id + " não encontrado."));
    }


    public void removerAlunoPorId(Long id){
        alunoRepository.deleteById(id);
    }

}
