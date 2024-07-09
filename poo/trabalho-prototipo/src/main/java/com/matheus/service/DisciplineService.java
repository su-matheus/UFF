package com.matheus.service;

import java.util.List;

import com.matheus.dao.DisciplineDAO;
import com.matheus.exception.ObjectDoesntExist;
import com.matheus.exception.ObjectWithAssociation;
import com.matheus.model.Discipline;
import com.matheus.util.DAOFactory;

public class DisciplineService {
private final DisciplineDAO disciplineDao = DAOFactory.getDAO(DisciplineDAO.class);
	
	
	public Discipline addDiscipline(Discipline disciplineName) {
		return disciplineDao.include(disciplineName);
	}
	
	public Discipline getDiscipline(Integer id) {
		Discipline discipline = disciplineDao.getById(id);
		if (discipline == null) {
			throw new ObjectDoesntExist("Discipline doesn't exits!");
		}
		return discipline;
	}

	public void deleteDiscipline(Integer id) {
		Discipline tempDiscipline = getDiscipline(id);
		if (tempDiscipline.getPreRequisites().isEmpty() && tempDiscipline.getClasses().isEmpty()) {
			disciplineDao.remove(tempDiscipline.getId());			
		} else {
			throw new ObjectWithAssociation("Discipline is associated with a prerequisite or a class. Delete them first!");
		}
	}

	public List<Discipline> getAllDisciplines(){
		return disciplineDao.getAll();
	}
}
