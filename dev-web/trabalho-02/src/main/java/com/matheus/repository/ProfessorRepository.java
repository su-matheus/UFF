package com.matheus.repository;

import com.matheus.model.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {
    List<Professor> findByNome(String nome);

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("select p from Professor p where p.id = :id")
    Optional<Professor> recuperarProfessorPorIdComLock(@Param("id") Long id);

    @Query("select p from Professor p where p.id = :id")
    Optional<Professor> recuperarProfessorPorIdSemLock(@Param("id") Long id);

    @Query(value = "select * from Professor", nativeQuery = true)
    List<Professor> recuperarProfessores();

//    @Query("select p from Professor p left outer join fetch p.turma where p.id = :id")
//    Optional<Professor> recuperarProfessorPorIdComTurma(@Param("id") Long id);

    @Query("select p from Professor p where p.id = :id")
    Optional<Professor> recuperarProfessorPorIdSemTurma(@Param("id") Long id);


}
