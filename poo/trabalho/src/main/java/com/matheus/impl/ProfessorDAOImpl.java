package com.matheus.impl;

import java.util.List;

import com.matheus.dao.ProfessorDAO;
import com.matheus.model.Professor;

public class ProfessorDAOImpl extends GenericDAOImpl<Professor> implements ProfessorDAO {

	@Override
	public List<Professor> getProfessorByName() {
		// TODO Auto-generated method stub
		return (List<Professor>) genericMap.values();
	}
	
	
}
