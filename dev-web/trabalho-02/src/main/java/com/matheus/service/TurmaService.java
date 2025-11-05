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
import org.springframework.data.domain.PageImpl;
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
        return turmaRepository.findAll()
                .stream()
                .map(t -> new TurmaDTO(
                        t.getId(),
                        t.getNome(),
                        t.getAno(),
                        t.getPeriodo(),
                        t.getProfessor(),
                        t.getDisciplina()
                ))
                .toList();
    }


    public Page<TurmaListagemDTO> recuperarTurmasPaginadas(Pageable pageable, String nome){
        return turmaRepository.recuperarTurmasComPaginacao(pageable, "%" + nome + "%");
    }

    public Page<TurmaAlunoPaginadoDTO> recuperarTurmaComAlunos(Pageable pageable, String nome) {
        Page<TurmaListagemDTO> turmasPge = turmaRepository.recuperarTurmasComPaginacao(pageable, nome);

        List<TurmaAlunoPaginadoDTO> turmaComAlunos = turmasPge
                .stream()
                .map(turma -> {
                    List<AlunoDTO> alunos = turmaRepository.buscarAlunosPorTurma(turma.id());
                    return new TurmaAlunoPaginadoDTO(
                            turma.id(),
                            turma.nome(),
                            turma.ano(),
                            turma.periodo(),
                            turma.professor(),
                            turma.disciplina(),
                            alunos
                    );
                })
                .toList();
        return new PageImpl<>(turmaComAlunos, pageable, turmasPge.getTotalElements());
    }


//    @Transactional
//    public TurmaAlunoPaginadoDTO recuperarPorIdTurmaComAlunos(Long id, Pageable pageable) {
//        Turma turma = turmaRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException(String.format("Turma com id %d não encontrada", id)));
//
////        Page<Inscricao> paginaDeInscricoes = inscricaoRepository.findByTurmaId(id, pageable);
//        Page<Inscricao> paginaDeInscricoes = inscricaoRepository.findTurmaById(id, pageable);
//
//        Page<AlunoDTO> paginaDeAlunos = paginaDeInscricoes
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
