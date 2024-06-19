package com.matheus.dao;

import java.util.List;

import com.matheus.model.Inscription;

public interface InscriptionDAO extends GenericDAO<Inscription> {
	List<Inscription> getInscriptionByScore();
}
