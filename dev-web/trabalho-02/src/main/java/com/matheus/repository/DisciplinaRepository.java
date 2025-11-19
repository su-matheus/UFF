package com.matheus.repository;

import com.matheus.model.Disciplina;
import com.matheus.model.Inscricao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DisciplinaRepository extends JpaRepository<Disciplina, Long> {
    @Query("""        
        SELECT d
        FROM Disciplina d
        JOIN d.turma t
        WHERE t.id = :turmaId
    """)
    List<Disciplina> findByTurmaId(@Param("turmaId") Long turmaId);

}
