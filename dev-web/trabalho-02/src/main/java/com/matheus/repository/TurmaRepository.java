package com.matheus.repository;

import com.matheus.model.*;
import jakarta.persistence.LockModeType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface TurmaRepository extends JpaRepository<Turma, Long> {
    @Query(value = "select * from Turma", nativeQuery = true)
    List<Turma> recuperarTurmas();

//    @Query("""
//            SELECT DISTINCT t FROM Turma t
//            LEFT JOIN FETCH t.inscricoes i
//            LEFT JOIN FETCH i.aluno a
//            LEFT JOIN FETCH t.professor p
//            LEFT JOIN FETCH t.disciplina d
//            WHERE t.id = :id
//            """)
//    Optional<Turma> recuperarPorIdComDetalhes(@Param("id") Long id);
//
//    Page<Turma> findByDisciplinaNomeContainingIgnoreCase(String nomeDisciplina, Pageable pageable);


//    @Query("""
//        SELECT new com.matheus.model.TurmaAlunoPaginadoDTO(
//            t.id,
//            t.nome,
//            t.ano,
//            t.periodo,
//            p.nome,
//            d.nome
//        )
//        FROM Turma t
//        JOIN t.professor p
//        JOIN t.disciplina d
//    """)
//    Page<TurmaAlunoPaginadoDTO> recuperarTurmasComPaginacao(Pageable pageable);


    @Query("""
        SELECT new com.matheus.model.TurmaListagemDTO(
            t.id,
            t.nome,
            t.ano,
            t.periodo,
            p.nome,
            d.nome
        )
        FROM Turma t
        JOIN t.professor p
        JOIN t.disciplina d
        WHERE LOWER(t.nome) LIKE LOWER(:nome)
    """)
    Page<TurmaListagemDTO> recuperarTurmasComPaginacao(Pageable pageable, @Param("nome") String nome);


    @Query("""
        SELECT new com.matheus.model.AlunoDTO(a.id, a.nome, a.email)
        FROM Inscricao i
        JOIN i.aluno a
        WHERE i.turma.id = :turmaId
    """)
    List<AlunoDTO> buscarAlunosPorTurma(@Param("turmaId") Long turmaId);

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("select t from Turma t where t.id = :id")
    Optional<Turma> recuperarTurmaPorIdComLock(@Param("id") Long id);
}
