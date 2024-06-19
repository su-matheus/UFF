package com.matheus.impl;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.matheus.dao.GenericDAO;
import com.matheus.util.Id;

public class GenericDAOImpl<G> implements GenericDAO<G> {
	protected Map<Integer, G> genericMap = new LinkedHashMap<>();
	private int count;

	@Override
	public Map<Integer, G> getAnyMap() {
		return genericMap;
	}

	@Override
	public void setAnyMap(Map<Integer, G> anyMap) {
		this.genericMap = anyMap;
	}

	@Override
	public Integer getCounter() {
		return count;
	}

	@Override
	public void setCounter(Integer count) {
		this.count = count;
		
	}

	@Override
	public G include(G obj) {
		for (Method methodToBeUsed : obj.getClass().getDeclaredMethods()) {
			if (methodToBeUsed.isAnnotationPresent(Id.class)) {
				try {
					String idMethodString = methodToBeUsed.getName().replace("get", "set");
					obj.getClass().getMethod(idMethodString, Integer.class).invoke(obj, ++count);
					return genericMap.put((Integer)methodToBeUsed.invoke(obj), obj);
				} catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					throw new RuntimeException(e);
				}
			}
		}
		return obj;
	}

	@Override
	public G update(G obj) {
		for (Method methodToBeUsed : obj.getClass().getDeclaredMethods()) {
			if (methodToBeUsed.isAnnotationPresent(Id.class)) {
				try {
					String idMethodString = methodToBeUsed.getName().replace("get", "set");
					obj.getClass().getMethod(idMethodString, Integer.class).invoke(obj, ++count);
					return genericMap.put((Integer)methodToBeUsed.invoke(obj), obj);
				} catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return obj;
	}

	@Override
	public G remove(Integer id) {
		return genericMap.remove(id);
	}

	@Override
	public G getById(Integer id) {
		return genericMap.get(id);
	}

	@Override
	public List<G> getAll() {
		return new ArrayList<>(genericMap.values());
	}
}
