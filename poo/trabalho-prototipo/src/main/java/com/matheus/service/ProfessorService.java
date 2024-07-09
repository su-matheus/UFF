package com.matheus.service;

import java.util.List;

import com.matheus.dao.ProfessorDAO;
import com.matheus.exception.ObjectDoesntExist;
import com.matheus.exception.ObjectWithAssociation;
import com.matheus.model.Professor;
import com.matheus.util.DAOFactory;

public class ProfessorService {
	private final ProfessorDAO professorDao = DAOFactory.getDAO(ProfessorDAO.class);
	
	public Professor addProfessor(Professor professorName) {
		return professorDao.include(professorName);
	}
	
	public Professor getProfessor(Integer id) {
		Professor professor = professorDao.getById(id);
		if (professor == null) {
			throw new ObjectDoesntExist("Professor doesn't exist!");
		} else {
			return professor;
		}
	}
	
	public Professor updateProfessorName(Professor oldName, String newName) {
		oldName.setName(newName);
		return oldName;
	}
	
	public Professor updateProfessorEmail(Professor professor, String newEmail) {
		professor.setEmail(newEmail);
		return professor;
	}
	
	public Professor deleteProfessor(Integer id) {
		Professor tempProfessor = getProfessor(id);
		if (tempProfessor.getClazzes().isEmpty()) {
			professorDao.remove(tempProfessor.getId());
		} else {
			throw new ObjectWithAssociation("Professor is associated with a class. Delete class first!");
			//System.out.println("Professor is associated with a class. Delete class first!");
		}
		return tempProfessor;
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
