package com.matheus.service;

import com.matheus.dao.StudentDAO;
import com.matheus.exception.ObjectWithAssociation;
import com.matheus.model.Student;
import com.matheus.util.DAOFactory;

import java.util.List;


public class StudentService {
	//private Map<Integer, Student> studentMap;
	private final StudentDAO studentDao = DAOFactory.getDAO(StudentDAO.class);
	
	
	public Student addStudent(Student studentName) {
		return studentDao.include(studentName);
	}
	
	public Student getStudent(int id) {
		Student tempStudent = studentDao.getById(id);
		if (tempStudent == null) {
			throw new Error("Student doesn't exist!");
		}
		return tempStudent;
	}
	
	public Student updateStudentName(Student oldName, String newName) {
		//studentDao.update(oldName);
		oldName.setName(newName);
		return oldName;
	}
	
	public Student updateStudentEmail(Student student, String newEmail) {
		student.setEmail(newEmail);
		return student;
	}
	
	public void deleteStudent(Integer id) {
		Student tempStudent = getStudent(id);
		if (tempStudent.getInscriptions().isEmpty()) {
			studentDao.remove(tempStudent.getId());
		} else {
			throw new ObjectWithAssociation("Student is associated with an inscription. Delete inscription first!");
		}
	}
	
	
	public List<Student> getAllStudents(){
		return studentDao.getAll();
		//return (Map<Integer, Student>) studentDao.getAll();
	}
}
