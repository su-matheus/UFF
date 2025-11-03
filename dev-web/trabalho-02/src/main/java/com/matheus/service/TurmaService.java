package com.matheus.service;

import com.matheus.exception.EntidadeNaoEncontradaException;
import com.matheus.model.*;
import com.matheus.repository.DisciplinaRepository;
import com.matheus.repository.InscricaoRepository;
import com.matheus.repository.TurmaRepository;
import com.matheus.repository.ProfessorRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class TurmaService {
    private final TurmaRepository turmaRepository;
    private final ProfessorRepository professorRepository;
    private final DisciplinaRepository disciplinaRepository;
    private final InscricaoRepository inscricaoRepository;

    public List<TurmaDTO> recuperarTurmas() {
//        return turmaRepository.recuperarTurmas();
        return turmaRepository.findAll()
                .stream()
                .map(t -> new TurmaDTO(
                        t.getId(),
                        t.getNome(),
                        t.getAno(),
                        t.getPeriodo(),
                        t.getProfessor(),
                        t.getDisciplina()
//                        t.getProfessor().getId(),
//                        t.getDisciplina().getId()
                ))
                .toList();
    }
//    @Transactional
//    public TurmaAlunoPaginadoDTO buscarPorIdComAlunosPaginados(Long id, Pageable pageable) {
//        Turma turma = turmaRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException(String.format("Turma com id"+ id + "não encontrada")));
//
////        Page<Inscricao> paginaDeInscricoes = inscricaoRepository.findByTurmaId(id, pageable);
//        Page<Inscricao> paginaInscricoes = inscricaoRepository.findTurmaById(id, pageable);
//
//        Page<AlunoResponseDTO> paginaDeAlunosDTO = paginaDeInscricoes
//                .map(inscricao -> modelMapper.criarAlunoResponseDTO(inscricao.getAluno()));
//
//        return new TurmaResponseComAlunosPaginadosDTO(
//                turma.getId(),
//                turma.getAno(),
//                turma.getPeriodo(),
//                modelMapper.criarProfessorResponseDTO(turma.getProfessor()),
//                modelMapper.criarDisciplinaDTO(turma.getDisciplina()),
//                paginaDeAlunosDTO
//        );
//    }

    public Page<Turma> recuperarTurmasPaginadas(Pageable pageable, String nome){
        return turmaRepository.recuperarTurmasComPaginacao(pageable, "%" + nome + "%");
    }

    @Transactional
    public Turma cadastrarTurma(TurmaDTO turmaDTO){
        Professor professor = professorRepository.findById(turmaDTO.professor().getId())
                .orElseThrow(() -> new EntidadeNaoEncontradaException(
                        "Professor com id = " + turmaDTO.professor() + "não encontrado."
                ));

        Disciplina disciplina = disciplinaRepository.findById(turmaDTO.disciplina().getId()).
                orElseThrow(() -> new EntidadeNaoEncontradaException(
                        "Disciplina com id = " + turmaDTO.disciplina() + "não encontrado."
                ));

        Turma turma = new Turma(turmaDTO.nome(), turmaDTO.ano(), turmaDTO.periodo(), professor, disciplina);
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
