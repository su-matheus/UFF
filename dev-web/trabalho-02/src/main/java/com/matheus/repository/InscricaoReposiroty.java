package com.matheus.repository;

import com.matheus.model.Inscricao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InscricaoReposiroty extends JpaRepository<Inscricao, Long> {
}
