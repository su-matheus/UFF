package com.matheus.service;

import com.matheus.model.Aluno;
import com.matheus.model.Inscricao;
import com.matheus.model.InscricaoDTO;
import com.matheus.model.Turma;
import com.matheus.repository.AlunoRepository;
import com.matheus.repository.InscricaoReposiroty;
import com.matheus.repository.TurmaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.matheus.exception.EntidadeNaoEncontradaException;

@RequiredArgsConstructor
@Service
public class InscricaoService {
    private final InscricaoReposiroty inscricaoRepository;
    private final TurmaRepository turmaRepository;
    private final AlunoRepository alunoRepository;

    @Transactional
    public Inscricao cadastrarInscricao(InscricaoDTO dto) {
        // Busca o aluno completo
        Aluno aluno = alunoRepository.findById(dto.getAlunoId())
                .orElseThrow(() -> new EntidadeNaoEncontradaException(
                        "Aluno com id = " + dto.getAlunoId() + " não encontrado."));

        // Busca a turma completa
        Turma turma = turmaRepository.findById(dto.getTurmaId())
                .orElseThrow(() -> new EntidadeNaoEncontradaException(
                        "Turma com id = " + dto.getTurmaId() + " não encontrada."));

        // Cria a inscrição com as entidades completas
        Inscricao inscricao = new Inscricao(aluno, turma);

        return inscricaoRepository.save(inscricao);
    }

//    @Transactional
//    public Inscricao cadastrarInscricao(Inscricao inscricao){
//        Aluno aluno = alunoRepository.findById(inscricao.getAluno().getId()).
//                orElseThrow( () -> new EntidadeNaoEncontradaException(
//                        "Aluno com id = " + inscricao.getAluno().getId() + " não encontrado."
//        ));
//        inscricao.setAluno(aluno);
//
//        Turma turma = turmaRepository.findById(inscricao.getTurma().getId()).
//                orElseThrow(() -> new EntidadeNaoEncontradaException(
//                        "Turma com id =" + inscricao.getTurma().getId() + " não encontrado"
//                ));
//        inscricao.setTurma(turma);
//
//        return inscricaoRepository.save(inscricao);
//    }

    @Transactional
    public void removerInscricaoPorId(Long id) {
        if (!inscricaoRepository.existsById(id)) {
            throw new EntidadeNaoEncontradaException(
                    "Inscrição com id = " + id + " não encontrada.");
        }
        inscricaoRepository.deleteById(id);
    }
}
