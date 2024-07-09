package com.matheus.trabalho;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.matheus.exception.ObjectDoesntExist;
import com.matheus.model.Clazz;
import com.matheus.model.Inscription;
import com.matheus.model.Inscription.Presence;
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
        		System.out.println("Enter score inscription:");
        		double score = scanner.nextDouble();
        		System.out.println("Enter inscription frequency option (0.Sufficient / 1.Unsifficient):");
        		int presenceOption = scanner.nextInt();
        		
        		try {
            		student = studentService.getStudent(studentId);
            		inscription = new Inscription(student, score, Presence.values()[presenceOption]);
            		inscriptionService.addInscription(inscription);
            		String formatter = "dd-MM-yy HH:mm";
            		SimpleDateFormat date = new SimpleDateFormat(formatter);
            		inscription.setDate(date.format(new Date()));
            		
            		student.addInscription(inscription);
            		System.out.println("Inscription " + inscription.getId() + " added successfully!");
        		} catch(ObjectDoesntExist e) {
        			System.out.println("\n" + e.getMessage());
        		}
        		break;
        		
    		
        	case 2:
        		System.out.println("Insert inscription ID you intend to update:");
        		id = scanner.nextInt();
        		
        		try {
            		inscription = inscriptionService.getInscription(id);
        			System.out.println("------------UPDATE INSCRIPTION MENU-------------");
            		System.out.println("Type the option you intend to update:");
            		System.out.println("1. Update score:");
            		System.out.println("2. Update frequency:");
            		System.out.println("3. Back menu");
            		int option = scanner.nextInt();
            		
            		switch(option) {
            		case 1:
            			System.out.println("Type the new score:");
            			double newScore = scanner.nextDouble();
            			//inscription = new Inscription(inscription.getStudent(), newScore, inscription.getPresence());
            			inscriptionService.updateScoreInscription(inscription, newScore);
            			System.out.println("Score updated succesfully!");
            			break;
            			
            		case 2:
            			System.out.println("Type the new frequency (0.Sufficient / 1.Unsifficient):");
            			int newFrequency = scanner.nextInt();
            			inscriptionService.updatePresenceInscription(inscription, Presence.values()[newFrequency]);
            			System.out.println("Presence updated succesfully!");
            			break;
            		case 3:
            			return;
        			default:
        				System.out.println("\n" + "Invalid option!");
            		}
        		} catch (ObjectDoesntExist e) {
        			System.out.println("\n" + e.getMessage());
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

