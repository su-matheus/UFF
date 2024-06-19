package com.matheus.impl;

import java.util.List;

import com.matheus.dao.ClazzDAO;
import com.matheus.model.Clazz;
import com.matheus.model.Professor;

public class ClazzDAOImpl extends GenericDAOImpl<Clazz> implements ClazzDAO {

	@Override
	public List<Clazz> getClazzByName() {
		// TODO Auto-generated method stub
		return (List<Clazz>) genericMap.values();
	}
	/*
	public Professor getProfessorByName(String name) {
		if(genericMap.containsValue(name)) {
			return (Professor) genericMap.values().getClass();
		}
		List<Professor> professorList = genericMap.values()	
	}
	*/
}
