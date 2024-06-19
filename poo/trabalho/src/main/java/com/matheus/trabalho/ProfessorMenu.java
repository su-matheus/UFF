package com.matheus.trabalho;

import java.util.List;
import java.util.Scanner;

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
	        		professor = new Professor(name, email);
	        		professorService.addProfessor(professor);
	        		System.out.println("Professor " + professor.getId() + " added successfully!");
	        		break;
        		case 2:
        			System.out.println("Insert professor ID you intend to update:");
	        		id = scanner.nextInt();
	        		professor = professorService.getProfessor(id);
	        		
	        		if(professor != null) {
	        			System.out.println("Enter new professor name:");
	        			name = scanner.nextLine();
	        			professor = new Professor(name, professor.getEmail());
	        			professorService.updateProfessorName(professor, name);
		        		System.out.println("Professor updated successfully!");
	        		}
	        		break;
	        	case 3:
	        		System.out.println("Insert professor ID you intend to delete:");
	        		id = scanner.nextInt();
	        		professorService.deleteProfessor(id);
	        		System.out.println("Professor deleted successfully!");
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
