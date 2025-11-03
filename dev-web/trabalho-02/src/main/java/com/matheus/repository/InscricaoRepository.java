package com.matheus.repository;

import com.matheus.model.Inscricao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface InscricaoRepository extends JpaRepository<Inscricao, Long> {
    Page<Inscricao> findTurmaById(Long turmaId, Pageable pageable);
}
