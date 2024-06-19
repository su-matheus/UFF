package com.matheus.dao;

import java.util.List;

import com.matheus.model.Professor;

public interface ProfessorDAO extends GenericDAO<Professor> {
	List<Professor> getProfessorByName();
}
