package com.matheus.repository;


import com.matheus.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
    List<Aluno> findByNome(String nome);

//        SELECT a
//        FROM Aluno a
//        JOIN a.inscricoes i
//        WHERE i.turma.id = :turmaId

    @Query("""        
        SELECT a
        FROM Aluno a
        LEFT OUTER JOIN FETCH a.inscricao i
        WHERE i.turma.id = :turmaId
    """)
    List<Aluno> findByTurmaId(@Param("turmaId") Long turmaId);

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("select a from Aluno a where a.id = :id")
    Optional<Aluno> recuperarAlunoPorIdComLock(@Param("id") Long id);

    @Query(value = "select * from Aluno", nativeQuery = true)
    List<Aluno> recuperarAlunos();

    @Query("select a from Aluno a left outer join fetch a.inscricao where a.id = :id")
    Optional<Aluno> recuperarAlunoPorIdComInscricao(@Param("id") Long id);

    @Query("select a from Aluno a where a.id = :id")
    Optional<Aluno> recuperarAlunoPorIdSemInscricao(@Param("id") Long id);


//    @Query("select p from Produto p left outer join fetch p.categoria where p.id = :id")
//    Optional<Produto> recuperarProdutoPorIdComCategoria(@Param("id") Long id);


}
