package com.matheus.service;

import java.util.List;

import com.matheus.dao.ClazzDAO;
import com.matheus.model.Clazz;
import com.matheus.util.DAOFactory;

public class ClazzService {
private final ClazzDAO clazzDao = DAOFactory.getDAO(ClazzDAO.class);
	
	public Clazz addClazz(Clazz clazz) {
		return clazzDao.include(clazz);
	}
	
	public Clazz getClazz(Integer id) {
		return clazzDao.getById(id);//não sei se dará certo pois método get pede um objeto, talvez tenha que colocar id como Integer
	}
	
	public Clazz updateYearClazz(Clazz oldYear, Integer newYear) {
		//studentDao.update(oldName);
		oldYear.setYear(newYear);
		return oldYear;
	}
	
	public void deleteClazz(Integer id) {
		Clazz tempClazz = getClazzById(id);
		clazzDao.remove(tempClazz.getId());
	}
	
	public Clazz getClazzById(int id) {
		Clazz tempClazz = clazzDao.getById(id);
		if (tempClazz == null) {
			throw new Error("Class doesn't exist.");
		}
		return tempClazz;
	}

	public List<Clazz> getAllClazzes(){
		return clazzDao.getAll();
		//return (Map<Integer, Student>) studentDao.getAll();
	}
}
