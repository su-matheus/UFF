package com.matheus.service;

import com.matheus.model.*;
import com.matheus.repository.AlunoRepository;
import com.matheus.repository.InscricaoRepository;
import com.matheus.repository.TurmaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.matheus.exception.EntidadeNaoEncontradaException;

import java.util.List;

@RequiredArgsConstructor
@Service
public class InscricaoService {
    private final InscricaoRepository inscricaoRepository;
    private final TurmaRepository turmaRepository;
    private final AlunoRepository alunoRepository;

    public List<InscricaoDTO> recuperarInscricoes() {
        return inscricaoRepository.findAll()
                .stream()
                .map(i -> new InscricaoDTO(
//                        i.getId(),
                        i.getAluno(),
                        i.getTurma()
//                        i.getDataHora()
                ))
                .toList();
    }

    public List<InscricaoDTO> recuperarPorTurma(Long turmaId) {
        List<Inscricao> inscricoes = inscricaoRepository.findByTurmaId(turmaId);

        return inscricoes.stream()
                .map(a -> new InscricaoDTO(
                        a.getAluno(),
                        a.getTurma()
                ))
                .toList();
    }

    @Transactional
    public Inscricao cadastrarInscricao(InscricaoDTO dto) {
        Aluno aluno = alunoRepository.findById(dto.aluno().getId())
                .orElseThrow(() -> new EntidadeNaoEncontradaException(
                        "Aluno com id = " + dto.aluno() + " não encontrado."));

        Turma turma = turmaRepository.findById(dto.turma().getId())
                .orElseThrow(() -> new EntidadeNaoEncontradaException(
                        "Turma com id = " + dto.turma() + " não encontrada."));

        Inscricao inscricao = new Inscricao(aluno, turma);

        return inscricaoRepository.save(inscricao);
    }

    @Transactional
    public Inscricao inscreverAluno(Long idTurma, Long idAluno) {

        Turma turma = turmaRepository.findById(idTurma)
                .orElseThrow(() -> new EntidadeNaoEncontradaException(
                        "Turma não encontrada: " + idTurma));

        Aluno aluno = alunoRepository.findById(idAluno)
                .orElseThrow(() -> new EntidadeNaoEncontradaException(
                        "Aluno não encontrado: " + idAluno));

        // Verifica se já está inscrito
        boolean existe = inscricaoRepository.existsByTurmaIdAndAlunoId(idTurma, idAluno);
        if (existe) {
            throw new EntidadeNaoEncontradaException("Aluno já está inscrito nesta turma.");
        }

        Inscricao inscricao = new Inscricao(aluno, turma);
        return inscricaoRepository.save(inscricao);

//        return new InscricaoDTO(
//                aluno,
//                turma
//                inscricao.getId(),
//                aluno.getId(),
//                aluno.getNome(),
//                aluno.getEmail()
//        );
    }

    @Transactional
    public void removerInscricao(Long idTurma, Long idInscricao) {

        Inscricao inscricao = inscricaoRepository.findById(idInscricao)
                .orElseThrow(() -> new EntidadeNaoEncontradaException(
                        "Inscrição não encontrada: " + idInscricao));

        if (!inscricao.getTurma().getId().equals(idTurma)) {
            throw new EntidadeNaoEncontradaException("A inscrição não pertence a essa turma.");
        }
        inscricaoRepository.delete(inscricao);
    }

    @Transactional
    public void removerInscricaoPorId(Long id) {
        if (!inscricaoRepository.existsById(id)) {
            throw new EntidadeNaoEncontradaException(
                    "Inscrição com id = " + id + " não encontrada.");
        }
        inscricaoRepository.deleteById(id);
    }
}
