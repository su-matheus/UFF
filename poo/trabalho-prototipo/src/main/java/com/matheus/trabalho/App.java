package com.matheus.trabalho;

import java.util.Map;
import java.util.Scanner;

import com.matheus.dao.ClazzDAO;
import com.matheus.dao.DisciplineDAO;
import com.matheus.dao.InscriptionDAO;
import com.matheus.dao.ProfessorDAO;
import com.matheus.dao.StudentDAO;
import com.matheus.model.*;
import com.matheus.util.DAOFactory;

import java.io.*;


public class App {
    public static void main( String[] args ){
    	Scanner scanner = new Scanner(System.in);
    	StudentMenu studentMenu = new StudentMenu();
    	ProfessorMenu professorMenu = new ProfessorMenu();
    	ClazzMenu clazzMenu = new ClazzMenu();
    	InscriptionMenu inscriptionMenu = new InscriptionMenu();
    	DisciplineMenu disciplineMenu = new DisciplineMenu();
    	
    	readData();

    	boolean menuOptions = true;
    	while (menuOptions) {
    		System.out.println("--------------MAIN MENU---------------");
    		System.out.println("1. Student Menu");
    		System.out.println("2. Professor Menu");
    		System.out.println("3. Class Menu");
    		System.out.println("4. Inscription Menu");
    		System.out.println("5. Discipline Menu");
    		System.out.println("6. Exit");
    		System.out.println("Enter your choice: ");
    		System.out.println("--------------------------------------");
    		
    		int choice = scanner.nextInt();
    		scanner.nextLine();
    		
    		switch (choice) {
    			case 1:
    				studentMenu.main();
    				break;
    			case 2:
    				professorMenu.main();
    				break;
    			case 3:
    				clazzMenu.main();
    				break;
    			case 4:
    				inscriptionMenu.main();
    				break;
    			case 5:
    				disciplineMenu.main();
    				break;
    			case 6:
    				saveData();
    				//System.exit(0);
    				return;
				default:
					System.out.println("Invalid choice. Please try again.");
    		}
    	}
	}
    
    @SuppressWarnings("unchecked")
	private static void readData() {
		try {
			StudentDAO studentDao = DAOFactory.getDAO(StudentDAO.class);
			ProfessorDAO professorDao = DAOFactory.getDAO(ProfessorDAO.class);
			ClazzDAO clazzDao = DAOFactory.getDAO(ClazzDAO.class);
			InscriptionDAO inscriptionDao = DAOFactory.getDAO(InscriptionDAO.class);
			DisciplineDAO disciplineDao = DAOFactory.getDAO(DisciplineDAO.class);
			
			FileInputStream dbInput = new FileInputStream(new File("db.txt"));
			ObjectInputStream dbObject = new ObjectInputStream(dbInput);
			
			Map<Integer, Student> studentMap = (Map<Integer, Student>) dbObject.readObject(); 
			studentDao.setAnyMap(studentMap);
			Integer studentCount = (Integer) dbObject.readObject();
			studentDao.setCounter(studentCount);
			
			Map<Integer, Professor> professorMap = (Map<Integer, Professor>) dbObject.readObject();
			professorDao.setAnyMap(professorMap);
			Integer professorCount = (Integer) dbObject.readObject();
			professorDao.setCounter(professorCount);
			
			Map<Integer, Clazz> classMap = (Map<Integer, Clazz>) dbObject.readObject();
			clazzDao.setAnyMap(classMap);
			Integer classCount = (Integer) dbObject.readObject();
			clazzDao.setCounter(classCount);
			
			Map<Integer, Inscription> inscriptionMap = (Map<Integer, Inscription>) dbObject.readObject();
			inscriptionDao.setAnyMap(inscriptionMap);
			Integer inscriptionCount = (Integer) dbObject.readObject();
			inscriptionDao.setCounter(inscriptionCount);
			
			Map<Integer, Discipline> disciplineMap = (Map<Integer, Discipline>) dbObject.readObject();
			disciplineDao.setAnyMap(disciplineMap);
			Integer disciplineCount = (Integer) dbObject.readObject();
			disciplineDao.setCounter(disciplineCount);
			
		} catch (FileNotFoundException e) {
			System.out.println("File already created!");
		} catch(IOException e) {
			throw new RuntimeException(e);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
    
    private static void saveData() {
    	StudentDAO studentDao = DAOFactory.getDAO(StudentDAO.class);
		ProfessorDAO professorDao = DAOFactory.getDAO(ProfessorDAO.class);
		ClazzDAO clazzDao = DAOFactory.getDAO(ClazzDAO.class);
		InscriptionDAO inscriptionDao = DAOFactory.getDAO(InscriptionDAO.class);
		DisciplineDAO disciplineDao = DAOFactory.getDAO(DisciplineDAO.class);

		Map<Integer, Student> studentMap = studentDao.getAnyMap();
		Map<Integer, Professor> professorMap = professorDao.getAnyMap();
		Map<Integer, Clazz> classMap = clazzDao.getAnyMap();
		Map<Integer, Inscription> inscriptionMap = inscriptionDao.getAnyMap();
		Map<Integer, Discipline> disciplineMap = disciplineDao.getAnyMap();
		
		Integer studentCount = studentDao.getCounter();
		Integer professorCount = professorDao.getCounter();
		Integer classCount = clazzDao.getCounter();
		Integer inscriptionCount = inscriptionDao.getCounter();
		Integer disciplineCount = disciplineDao.getCounter();
		
    	try {
    		FileOutputStream dbOutput = new FileOutputStream(new File("db.txt"));
    		ObjectOutputStream dbObject = new ObjectOutputStream(dbOutput);
    		
    		dbObject.writeObject(studentMap);
    		dbObject.writeObject(studentCount);
    		
    		dbObject.writeObject(professorMap);
    		dbObject.writeObject(professorCount);
    		
    		dbObject.writeObject(classMap);
    		dbObject.writeObject(classCount);
    		
    		dbObject.writeObject(inscriptionMap);
    		dbObject.writeObject(inscriptionCount);
    		
    		dbObject.writeObject(disciplineMap);
    		dbObject.writeObject(disciplineCount);
    		
    	} catch (IOException e) {
    		throw new RuntimeException(e);
    	}
    }
}
