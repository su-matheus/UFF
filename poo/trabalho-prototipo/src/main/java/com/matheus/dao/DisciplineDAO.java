package com.matheus.dao;

import java.util.List;

import com.matheus.model.Discipline;

public interface DisciplineDAO extends GenericDAO<Discipline> {
	List<Discipline> getDisciplineByName();
}
