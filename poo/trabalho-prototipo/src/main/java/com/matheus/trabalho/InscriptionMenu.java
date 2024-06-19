package com.matheus.trabalho;

import java.util.List;
import java.util.Scanner;

import com.matheus.model.Clazz;
import com.matheus.model.Inscription;
import com.matheus.model.Student;
import com.matheus.service.ClazzService;
import com.matheus.service.InscriptionService;
import com.matheus.service.StudentService;

public class InscriptionMenu {
	private static Scanner scanner = new Scanner(System.in);
	private static ClazzService clazzService = new ClazzService();
	private static StudentService studentService = new StudentService();
	private static InscriptionService inscriptionService = new InscriptionService();

	public void main() {
		int id;
		Student student;
		Clazz clazz;
		Inscription inscription;
		
		boolean printMenu = true;
		while(printMenu) {
			System.out.println("------------INSCRIPTION MENU-------------");
	    	System.out.println("1. Add Inscription");
	    	System.out.println("2. Update Inscription");
	    	System.out.println("3. Delete Inscription");
	    	System.out.println("4. List All Inscription");
	    	System.out.println("5. Back Menu");

	    	int choice = scanner.nextInt();
        	scanner.nextLine();

        	switch(choice) {
        	case 1:
        		System.out.println("Enter student ID:");
        		int studentId = scanner.nextInt();
        		System.out.println("Enter class class:");
        		int clazzId = scanner.nextInt();
        		System.out.println("Enter score inscription:");
        		int score = scanner.nextInt();
        		student = studentService.getStudent(studentId);
        		clazz = clazzService.getClazz(clazzId);
        		inscription = new Inscription(student, score, clazz);
        		inscriptionService.addInscription(inscription);
        		System.out.println("Inscription " + inscription.getId() + " added successfully!");
        		break;
        		
        		
        	case 2:
        		System.out.println("Insert inscription ID you intend to update:");
        		id = scanner.nextInt();
        		inscription = inscriptionService.getInscription(id);
        		
        		if(inscription != null) {
        			System.out.println("Enter new inscription score:");
        			score = scanner.nextInt();
        			inscription = new Inscription(inscription.getStudent(), score, inscription.getClazz());
        			inscriptionService.updateScoreInscription(inscription, score);
	        		System.out.println("Inscription updated successfully!");
        		}
        		break;
        		
        	case 3:
        		System.out.println("Insert Inscription ID you intend to delete:");
        		id = scanner.nextInt();
        		inscriptionService.deleteInscription(id);
        		System.out.println("Inscription deleted successfully!");
        		break;
        		
        	case 4:
        		List<Inscription> inscriptions = inscriptionService.getAllInscriptions();
        		for (Inscription currentInscription : inscriptions) {
        			System.out.println(currentInscription);
        		}
        		break;
        		
        	case 5:
        		return;
        	default:
        		System.out.println("\n" + "Invalid option!");        		
        	}

		}
	
	}
}

