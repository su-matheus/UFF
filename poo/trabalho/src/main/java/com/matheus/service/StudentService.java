package com.matheus.service;

import com.matheus.dao.StudentDAO;
import com.matheus.model.Student;
import com.matheus.util.DAOFactory;

import java.util.List;


public class StudentService {
	//private Map<Integer, Student> studentMap;
	private final StudentDAO studentDao = DAOFactory.getDAO(StudentDAO.class);
	
	
	public Student addStudent(Student studentName) {
		return studentDao.include(studentName);
	}
	
	public Student getStudent(Integer id) {
		return studentDao.getById(id);//não sei se dará certo pois método get pede um objeto, talvez tenha que colocar id como Integer
	}
	
	public Student updateStudentName(Student oldName, String newName) {
		//studentDao.update(oldName);
		oldName.setName(newName);
		return oldName;
	}
	
	public void deleteStudent(Integer id) {
		//Student tempStudent = getStudent(id);
		Student tempStudent = getStudentById(id);
		studentDao.remove(tempStudent.getId());
	}
	
	public Student getStudentById(int id) {
		Student tempStudent = studentDao.getById(id);
		if (tempStudent == null) {
			throw new Error("Student doesn't exist.");
		}
		return tempStudent;
	}
	
	public List<Student> getAllStudents(){
		return studentDao.getAll();
		//return (Map<Integer, Student>) studentDao.getAll();
	}
}
