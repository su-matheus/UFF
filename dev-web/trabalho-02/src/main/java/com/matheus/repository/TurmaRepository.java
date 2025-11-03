package com.matheus.repository;

import com.matheus.model.Professor;
import com.matheus.model.Turma;
import com.matheus.model.TurmaAlunoPaginadoDTO;
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
       SELECT t.id, t.nome, t.ano, t.periodo,
              p.id, p.nome,
              d.id, d.nome
       FROM Turma t
       JOIN t.professor p
       JOIN t.disciplina d
       """)
    Page<Turma> recuperarTurmasComPaginacao(Pageable pageable,  @Param("nome") String nome);

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("select t from Turma t where t.id = :id")
    Optional<Turma> recuperarTurmaPorIdComLock(@Param("id") Long id);
}
