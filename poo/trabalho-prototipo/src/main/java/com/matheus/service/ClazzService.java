package com.matheus.service;

import java.util.List;

import com.matheus.dao.ClazzDAO;
import com.matheus.exception.ObjectDoesntExist;
import com.matheus.model.Clazz;
import com.matheus.util.DAOFactory;

public class ClazzService {
private final ClazzDAO clazzDao = DAOFactory.getDAO(ClazzDAO.class);
	
	public Clazz addClazz(Clazz clazz) {
		return clazzDao.include(clazz);
	}
	
	public Clazz getClazz(Integer id) {
		Clazz clazz = clazzDao.getById(id);
		if (clazz == null) {
			throw new ObjectDoesntExist("Class doesn't exist!");
		}
		return clazz;
	}

	public void deleteClazz(Integer id) {
		Clazz tempClazz = getClazz(id);
		clazzDao.remove(tempClazz.getId());
	}

	public List<Clazz> getAllClazzes(){
		return clazzDao.getAll();
	}
}
