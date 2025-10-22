package com.matheus.repository;

import com.matheus.model.Professor;
import com.matheus.model.Turma;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface TurmaRepository extends JpaRepository<Turma, Long> {
    @Query(value = "select * from Turma", nativeQuery = true)
    List<Turma> recuperarTurmas();

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("select t from Turma t where t.id = :id")
    Optional<Turma> recuperarTurmaPorIdComLock(@Param("id") Long id);
}
