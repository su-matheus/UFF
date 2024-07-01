package com.matheus.trabalho;

import java.util.List;
import java.util.Scanner;

import com.matheus.model.Clazz;
import com.matheus.model.Professor;
import com.matheus.service.ClazzService;
import com.matheus.service.ProfessorService;

public class ClazzMenu {
	private static Scanner scanner = new Scanner(System.in);
	private static ClazzService clazzService = new ClazzService();
	private static ProfessorService professorService = new ProfessorService();

	public void main() {
		int id;
		Integer year;
		Integer period;
		Professor professor;
		Clazz clazz;

        boolean printMenu = true;
        while (printMenu) {
        	System.out.println("------------CLASS MENU-------------");
        	System.out.println("1. Add Class");
        	System.out.println("2. Update Class");
        	System.out.println("3. Delete Class");
        	System.out.println("4. List All Classes");
        	System.out.println("5. Back Menu");
        	
        	int choice = scanner.nextInt();
        	scanner.nextLine();

        	switch(choice) {
        	case 1:
        		System.out.println("Enter class year:");
        		year = scanner.nextInt();
        		System.out.println("Enter class period:");
        		period = scanner.nextInt();
        		System.out.println("Enter professor ID of the class:");
        		int professorId= scanner.nextInt();
        		/*
        		String professorName = scanner.nextLine();
        		professor = professorService.getProfessorByName(professorName);
        		*/
        		professor = professorService.getProfessorById(professorId);
        		clazz = new Clazz(year, period, professor);
        		clazzService.addClazz(clazz);
        		professor.addClazz(clazz);
        		
        		System.out.println("Class " + clazz.getId() + " added successfully!");
        		break;
        		
        		
        	case 2:
        		System.out.println("Insert class ID you intend to update:");
        		id = scanner.nextInt();
        		clazz = clazzService.getClazz(id);
        		
        		if(clazz != null) {
        			System.out.println("Enter new clazz year:");
        			year = scanner.nextInt();
        			clazz = new Clazz(year, clazz.getPeriod(), clazz.getProfessor());
        			clazzService.updateYearClazz(clazz, year);
	        		System.out.println("Class updated successfully!");
        		}
        		break;
        		
        	case 3:
        		System.out.println("Insert Class ID you intend to delete:");
        		id = scanner.nextInt();
        		clazzService.deleteClazz(id);
        		System.out.println("Class deleted successfully!");
        		break;
        		
        	case 4:
        		//studentService.getAllStudents().values().forEach(System.out::println);
        		List<Clazz> clazzes= clazzService.getAllClazzes();
        		for (Clazz currentClazz : clazzes) {
        			System.out.println(currentClazz);
        		}
        		break;
        		
        	case 5:
        		//printMenu = false;
        		return;
        	default:
        		System.out.println("\n" + "Invalid option!");        		
        	}
        }
	}
}

