package com.matheus.impl;

import java.util.List;

import com.matheus.dao.DisciplineDAO;
import com.matheus.model.Discipline;

public class DisciplineDAOImpl extends GenericDAOImpl<Discipline> implements DisciplineDAO {

	@Override
	public List<Discipline> getDisciplineByName() {
		// TODO Auto-generated method stub
		return (List<Discipline>) genericMap.values();
	}

}
