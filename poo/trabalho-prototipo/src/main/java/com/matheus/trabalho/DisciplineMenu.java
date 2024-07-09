package com.matheus.trabalho;

import java.util.List;
import java.util.Scanner;

import com.matheus.exception.InputHandler;
import com.matheus.exception.ObjectWithAssociation;
import com.matheus.model.Discipline;
import com.matheus.service.DisciplineService;


public class DisciplineMenu {
	private static Scanner scanner = new Scanner(System.in);
	private static DisciplineService disciplineService = new DisciplineService();
	
	
	public void main() {
		int id;
		String name;
		Integer courseLoad;
		Discipline discipline;

        boolean printMenu = true;
        while (printMenu) {
        	System.out.println("------------DISCIPLINE MENU-------------");
        	System.out.println("1. Add Discipline");
        	System.out.println("2. Add Prerequisite");
        	System.out.println("3. Delete Discipline");
        	System.out.println("4. Delete Prerequisite");
        	System.out.println("5. List All Disciplines");
        	System.out.println("6. Back Menu");
        	
        	int choice = scanner.nextInt();
        	scanner.nextLine();
        	
        	switch(choice) {
	        	case 1:
	        		System.out.println("Enter discipline name:");
	        		name = scanner.nextLine();
	        		System.out.println("Enter course load:");
	        		courseLoad = scanner.nextInt();
	        		
	        		if(!InputHandler.isUsernameValid(name)) {
	        			System.out.println("Invalid discipline name. Name must contain at least 3 words.");
	        			return;
	        		}
	        		
	        		discipline = new Discipline(name, courseLoad);
	        		disciplineService.addDiscipline(discipline);
	        		System.out.println("Discipline " + discipline.getId() + " added successfully!");
	        		break;
        		
	        	case 2:
	        		System.out.println("Insert discipline ID to insert a prerequisite:");
	        		int disciplineId = scanner.nextInt();
	        		discipline = disciplineService.getDiscipline(disciplineId);
	        		System.out.println("Enter discipline ID of prerequisite:");
        			int prerequisiteId = scanner.nextInt();
        			Discipline prerequisite = disciplineService.getDiscipline(prerequisiteId);
	        		
	        		if(discipline != null && prerequisite != null) {
	        			discipline.addPrerequisite(prerequisite);
		        		System.out.println("Prerequisite added successfully!");
	        		} else {
	        			System.out.println("Discipline or prerequisite doesn't exist!");
	        		}
	        		break;
        		
	        	case 3:
	        		System.out.println("Insert discipline ID you intend to delete:");
	        		id = scanner.nextInt();
	        		try {
		        		disciplineService.deleteDiscipline(id);
		        		System.out.println("Discipline deleted successfully!");	        			
	        		} catch (ObjectWithAssociation e) {
	        			System.out.println("\n" + e.getMessage());
	        		}
	        		break;
	        		
	        	case 4:
	        		System.out.println("Insert discipline ID you intend to delete prerequisites:");
	        		id = scanner.nextInt();
	        		try {
	        			discipline = disciplineService.getDiscipline(id);
        				discipline.getPreRequisites().clear();
		        		System.out.println("Prerequisites deleted successfully!");
	        			/*
	        			while (discipline.getPreRequisites()) {
	        				discipline.getPreRequisites().clear();
	        			}
	        			for (Discipline currentDiscipline : discipline.getPreRequisites()) {
	        				discipline.removePrerequisite(currentDiscipline);
	        			}
	        			*/
	        		} catch (ObjectWithAssociation e) {
	        			System.out.println("\n" + e.getMessage());
	        		}
	        		break;
	        		
	        		
	        	case 5:
	        		List<Discipline> disciplines = disciplineService.getAllDisciplines();
	        		for (Discipline currentDiscipline : disciplines) {
	        			System.out.println(currentDiscipline);
	        		}
	        		break;

	        	case 6:
	        		return;
	        	default:
	        		System.out.println("\n" + "Invalid option!");        		
        	}
        }
	}
}
