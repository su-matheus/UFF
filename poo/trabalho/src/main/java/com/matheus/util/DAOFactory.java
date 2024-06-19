package com.matheus.util;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.reflections.Reflections;

public class DAOFactory {
	private static final Map<Class<?>, Object> genericMap = new HashMap<>();
	
	public static <G> G getDAO(Class<G> genericDAOType) {
		Object obj = genericMap.get(genericDAOType);
		if (obj == null) {
			Reflections reflection = new Reflections("com.matheus.impl");
			Set<Class<? extends G>> possibleSubtypesDAOSet = reflection.getSubTypesOf(genericDAOType);
			if (possibleSubtypesDAOSet.size() != 1) {
				throw new RuntimeException("Must be just one class that implements " + genericDAOType.getName());
			}
			Class<? extends G> DAOClass = possibleSubtypesDAOSet.iterator().next();
			try {
				obj = DAOClass.getDeclaredConstructor().newInstance();
				genericMap.put(genericDAOType, obj);
			} catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
				e.printStackTrace();
			}
		}		
		return (G) obj;
	}
}
