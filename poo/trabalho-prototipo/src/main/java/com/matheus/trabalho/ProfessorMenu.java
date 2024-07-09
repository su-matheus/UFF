package com.matheus.trabalho;

import java.util.List;
import java.util.Scanner;

import com.matheus.exception.InputHandler;
import com.matheus.exception.ObjectDoesntExist;
import com.matheus.exception.ObjectWithAssociation;
import com.matheus.model.Professor;
import com.matheus.service.ProfessorService;

public class ProfessorMenu {
	private static Scanner scanner = new Scanner(System.in);
	private static ProfessorService professorService = new ProfessorService();
	
	public void main() {
		int id;
		String name;
		String email;
		Professor professor;
		
		boolean printMenu = true;
		while(printMenu) {
			System.out.println("------------PROFESSOR MENU-------------");
        	System.out.println("1. Add Professor");
        	System.out.println("2. Update Professor");
        	System.out.println("3. Delete Professor");
        	System.out.println("4. List All Professors");
        	System.out.println("5. Back Menu");
        	
        	int choice = scanner.nextInt();
        	scanner.nextLine();
        	
        	switch(choice) {
        		case 1:
        			System.out.println("Enter professor name:");
	        		name = scanner.nextLine();
	        		System.out.println("Enter professor email:");
	        		email = scanner.nextLine();
	        		
	        		if (!InputHandler.isEmailValid(email)) {
	        			System.out.println("Invalid Email. Email should follow the pattern 'user@email.com'.");
	        			return;
	        		} else if(!InputHandler.isUsernameValid(name)) {
	        			System.out.println("Invalid Username. Username must contain at least 3 words.");
	        			return;
	        		}
	        		
	        		professor = new Professor(name, email);
	        		professorService.addProfessor(professor);
	        		System.out.println("Professor " + professor.getId() + " added successfully!");
	        		break;
	        		
        		case 2:
        			System.out.println("Insert professor ID you intend to update:");
	        		id = scanner.nextInt();
	        		
	        		try {
	            		professor = professorService.getProfessor(id);
	        			System.out.println("------------UPDATE PROFESSOR MENU-------------");
	            		System.out.println("Type the option you intend to update:");
	            		System.out.println("1. Update name:");
	            		System.out.println("2. Update email:");
	            		System.out.println("3. Back menu");
	            		int option = scanner.nextInt();
		        		scanner.nextLine();
	            		
	            		switch(option) {
	            		case 1:
	            			System.out.println("Type the new name:");
	            			String newName = scanner.nextLine();
	            			if(!InputHandler.isUsernameValid(newName)) {
	    	        			System.out.println("Invalid Username. Username must contain at least 3 words.");
	    	        			return;
	    	        		}
	            			professorService.updateProfessorName(professor, newName);
	            			System.out.println("Name updated succesfully!");
	            			break;
	            			
	            		case 2:
	            			System.out.println("Type the new email:");
	            			String newEmail = scanner.nextLine();
	            			if (!InputHandler.isEmailValid(newEmail)) {
	    	        			System.out.println("Invalid Email. Email should follow the pattern 'user@email.com'.");
	    	        			return;
	    	        		}
	            			professorService.updateProfessorEmail(professor, newEmail);
	            			System.out.println("Email updated succesfully!");
	            			break;
	            		}
	        		} catch (ObjectDoesntExist e) {
	        			System.out.println("\n" + e.getMessage());
	        		}
	        		break;
	        		
	        	case 3:
	        		System.out.println("Insert professor ID you intend to delete:");
	        		id = scanner.nextInt();
	        		try {
		        		professorService.deleteProfessor(id);
		        		System.out.println("Professor deleted successfully!");	        			
	        		} catch (ObjectWithAssociation e) {
	        			System.out.println("\n" + e.getMessage());
	        		}
	        		break;
	        		
	        	case 4:
	        		//studentService.getAllStudents().values().forEach(System.out::println);
	        		List<Professor> professors = professorService.getAllProfessors();
	        		for (Professor currentProfessor: professors) {
	        			System.out.println(currentProfessor);
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
