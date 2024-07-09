package com.matheus.service;

import java.util.List;

import com.matheus.dao.InscriptionDAO;
import com.matheus.exception.ObjectDoesntExist;
import com.matheus.exception.ObjectWithAssociation;
import com.matheus.model.Inscription;
import com.matheus.model.Inscription.Presence;
import com.matheus.util.DAOFactory;


public class InscriptionService {
	InscriptionDAO inscriptionDao = DAOFactory.getDAO(InscriptionDAO.class);
	
	public Inscription addInscription(Inscription inscription) {
		return inscriptionDao.include(inscription);
	}
	
	public Inscription getInscription(Integer id) {
		Inscription inscription = inscriptionDao.getById(id);
		if (inscription == null) {
			throw new ObjectDoesntExist("Inscription doesn't exist!");
		}
		return inscription;
		//return inscriptionDao.getById(id);//não sei se dará certo pois método get pede um objeto, talvez tenha que colocar id como Integer
	}
	
	public Inscription updateScoreInscription(Inscription oldScore, double newScore) {
		//studentDao.update(oldName);
		oldScore.setScore(newScore);
		return oldScore;
	}
	
	public Inscription updatePresenceInscription (Inscription inscription, Presence newFrequency) {
		inscription.setPresence(newFrequency);
		return inscription;
	}
	
	public void deleteInscription(Integer id) {
		Inscription tempInscription = getInscription(id);
		if (tempInscription.getClasses().isEmpty()) {
			inscriptionDao.remove(tempInscription.getId());			
		} else {
			throw new ObjectWithAssociation("Inscription is associated with a class. Delete class first!");
		}
	}
	
	public Inscription getInscriptionById(int id) {
		Inscription tempInscription = inscriptionDao.getById(id);
		if (tempInscription == null) {
			throw new Error("Inscription doesn't exist.");
		}
		return tempInscription;
	}

	public List<Inscription> getAllInscriptions(){
		return inscriptionDao.getAll();
		//return (Map<Integer, Student>) studentDao.getAll();
	}
}
