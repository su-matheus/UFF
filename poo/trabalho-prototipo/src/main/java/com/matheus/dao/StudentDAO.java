package com.matheus.dao;

import java.util.List;

import com.matheus.model.Student;

public interface StudentDAO extends GenericDAO<Student> {
	List<Student> getStudentByName();
}
