package com.matheus.impl;

import java.util.List;

import com.matheus.dao.StudentDAO;
import com.matheus.model.Student;

public class StudentDAOImpl extends GenericDAOImpl<Student> implements StudentDAO{

	@Override
	public List<Student> getStudentByName() {
		return (List<Student>) genericMap.values();
	}
	
}
