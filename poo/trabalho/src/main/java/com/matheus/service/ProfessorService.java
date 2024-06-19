package com.matheus.service;

import java.util.List;

import com.matheus.dao.ProfessorDAO;
import com.matheus.model.Professor;
import com.matheus.util.DAOFactory;

public class ProfessorService {
	private final ProfessorDAO professorDao = DAOFactory.getDAO(ProfessorDAO.class);
	
	public Professor addProfessor(Professor professorName) {
		return professorDao.include(professorName);
	}
	
	public Professor getProfessor(Integer id) {
		return professorDao.getById(id);
	}
	
	public Professor updateProfessorName(Professor oldName, String newName) {
		oldName.setName(newName);
		return oldName;
	}
	
	public void deleteProfessor(Integer id) {
		Professor tempStudent = getProfessorById(id);
		professorDao.remove(tempStudent.getId());
	}
	
	public Professor getProfessorById(int id) {
		Professor tempProfessor = professorDao.getById(id);
		if (tempProfessor== null) {
			throw new Error("Student doesn't exist.");
		}
		return tempProfessor;
	}
	
	public Professor getProfessorByName(String name) {
		for(Professor professor : getAllProfessors()) {
			if(professor.getName() == name) {
				return professor;
			}
		}
		return null;
	}
	
	public List<Professor> getAllProfessors(){
		return professorDao.getAll();
	}
}
