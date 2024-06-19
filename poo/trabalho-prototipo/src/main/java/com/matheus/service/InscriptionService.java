package com.matheus.service;

import java.util.List;

import com.matheus.dao.InscriptionDAO;
import com.matheus.model.Inscription;
import com.matheus.util.DAOFactory;

public class InscriptionService {
	InscriptionDAO inscriptionDao = DAOFactory.getDAO(InscriptionDAO.class);
	
	public Inscription addInscription(Inscription inscription) {
		return inscriptionDao.include(inscription);
	}
	
	public Inscription getInscription(Integer id) {
		return inscriptionDao.getById(id);//não sei se dará certo pois método get pede um objeto, talvez tenha que colocar id como Integer
	}
	
	public Inscription updateScoreInscription(Inscription oldScore, Integer newScore) {
		//studentDao.update(oldName);
		oldScore.setScore(newScore);
		return oldScore;
	}
	
	public void deleteInscription(Integer id) {
		Inscription tempInscription = getInscriptionById(id);
		inscriptionDao.remove(tempInscription.getId());
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
