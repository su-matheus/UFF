package com.matheus.service;

import com.matheus.exception.EntidadeNaoEncontradaException;
import com.matheus.model.Aluno;
import com.matheus.repository.AlunoRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AlunoService {
    private final AlunoRepository alunoRepository;

    public List<Aluno> recuperarAlunos() {
        return alunoRepository.recuperarAlunos();
    }

    public Aluno cadastrarAluno(Aluno aluno) {
        return alunoRepository.save(aluno);
    }

    @Transactional
    public Aluno alterarAluno(Aluno aluno) {
        // Aqui (recuperarProdutoPorIdComLock) retorna um Optional<Produto>
        alunoRepository.recuperarAlunoPorIdComLock(aluno.getId())
                .orElseThrow(() -> new EntidadeNaoEncontradaException(
                        "Aluno com id = " + aluno.getId() + " não encontrado."));
        return alunoRepository.save(aluno);
    }

    public Aluno recuperarAlunoPorIdComInscricao(Long id) {
        // findById() retorna um Optional<T>
//        return alunoRepository.recuperarAlunoPorIdComInscricao(id)
//                .orElseThrow(() -> new EntidadeNaoEncontradaException(
//                        "Aluno com id= " + id + " não encontrado."
//                ));
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


//    public Aluno recuperarAlunoPorId(Long id) {
//    return alunoRepository.recuperarAlunoPorIdComLock(id)
//            .orElseThrow(() -> new EntidadeNaoEncontradaException(
//                    "Aluno com id = " + id + " não encontrado."));
//    }

    public void removerAlunoPorId(Long id){
        alunoRepository.deleteById(id);
    }

}
