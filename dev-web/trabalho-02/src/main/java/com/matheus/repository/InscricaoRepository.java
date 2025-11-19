package com.matheus.repository;

import com.matheus.model.Aluno;
import com.matheus.model.Inscricao;
import com.matheus.model.InscricaoDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface InscricaoRepository extends JpaRepository<Inscricao, Long> {
    Page<Inscricao> findTurmaById(Long turmaId, Pageable pageable);

    @Query("""        
        SELECT i
        FROM Inscricao i
        WHERE i.turma.id = :turmaId
    """)
    List<Inscricao> findByTurmaId(@Param("turmaId") Long turmaId);


    boolean existsByTurmaIdAndAlunoId(Long turmaId, Long alunoId);

    @Query("""
        SELECT new com.matheus.model.InscricaoDTO(
            a,
            t
        )
        FROM Inscricao i
        JOIN i.aluno a
        JOIN i.turma t
        WHERE i.turma.id = :turmaId
        ORDER BY i.id DESC
    """)
    List<InscricaoDTO> buscarInscricoesPorTurma(@Param("turmaId") Long turmaId);

}
