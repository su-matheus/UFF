package com.matheus.service;

import com.matheus.model.Aluno;
import com.matheus.model.Inscricao;
import com.matheus.model.InscricaoDTO;
import com.matheus.model.Turma;
import com.matheus.repository.AlunoRepository;
import com.matheus.repository.InscricaoRepository;
import com.matheus.repository.TurmaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.matheus.exception.EntidadeNaoEncontradaException;

@RequiredArgsConstructor
@Service
public class InscricaoService {
    private final InscricaoRepository inscricaoRepository;
    private final TurmaRepository turmaRepository;
    private final AlunoRepository alunoRepository;

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
    public void removerInscricaoPorId(Long id) {
        if (!inscricaoRepository.existsById(id)) {
            throw new EntidadeNaoEncontradaException(
                    "Inscrição com id = " + id + " não encontrada.");
        }
        inscricaoRepository.deleteById(id);
    }
}
