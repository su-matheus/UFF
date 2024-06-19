package com.matheus.dao;

import java.util.List;

import com.matheus.model.Clazz;

public interface ClazzDAO extends GenericDAO<Clazz> {
	List<Clazz> getClazzByName();
}
