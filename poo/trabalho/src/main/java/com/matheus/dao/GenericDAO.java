package com.matheus.dao;

import java.util.List;
import java.util.Map;

public interface GenericDAO<G> {
	Map<Integer, G> getAnyMap();
	void setAnyMap(Map<Integer, G> anyMap);
	Integer getCounter();
	void setCounter(Integer count);
	G include(G obj);
	G update(G obj);
	G remove(Integer id);
	G getById(Integer id);
	List<G> getAll();
}
