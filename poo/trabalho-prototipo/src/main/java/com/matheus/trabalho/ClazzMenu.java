package com.matheus.trabalho;

import java.util.List;
import java.util.Scanner;

import com.matheus.exception.ObjectDoesntExist;
import com.matheus.model.Clazz;
import com.matheus.model.Discipline;
import com.matheus.model.Inscription;
import com.matheus.model.Inscription.Presence;
import com.matheus.model.Professor;
import com.matheus.service.ClazzService;
import com.matheus.service.DisciplineService;
import com.matheus.service.ProfessorService;
import com.matheus.service.InscriptionService;

public class ClazzMenu {
	private static Scanner scanner = new Scanner(System.in);
	private static ClazzService clazzService = new ClazzService();
	private static ProfessorService professorService = new ProfessorService();
	private static DisciplineService disciplineService = new DisciplineService();
	private static InscriptionService inscriptionService = new InscriptionService();

	public void main() {
		int id;
		Integer year;
		Integer period;
		Professor professor;
		Inscription inscription;
		Discipline discipline;
		Clazz clazz;

        boolean printMenu = true;
        while (printMenu) {
        	System.out.println("------------CLASS MENU-------------");
        	System.out.println("1. Add Class");
        	System.out.println("2. Add Inscription");
        	System.out.println("3. Delete Class");
        	System.out.println("4. List All Classes");
        	System.out.println("5. List Approved Students in a Class");
        	System.out.println("6. Back Menu");
        	
        	int choice = scanner.nextInt();
        	scanner.nextLine();

        	switch(choice) {
        	case 1:
        		System.out.println("Enter class year:");
        		year = scanner.nextInt();
        		System.out.println("Enter class period (1 or 2):");
        		period = scanner.nextInt();
        		System.out.println("Enter professor ID of the class:");
        		int professorId= scanner.nextInt();
        		System.out.println("Enter discipline ID of the class:");
        		int disciplineId = scanner.nextInt();
        		
        		if (period > 2 || period < 1) {
        			System.out.println("Academic year just has two periods!");
        			return;
        		}
        		
        		try {
            		professor = professorService.getProfessor(professorId);
            		discipline = disciplineService.getDiscipline(disciplineId);
            		clazz = new Clazz(year, period, professor, discipline);
            		clazzService.addClazz(clazz);
            		
            		discipline.addClass(clazz);
            		professor.addClazz(clazz);
            		System.out.println("Class " + clazz.getId() + " added successfully!");
        		} catch (ObjectDoesntExist e) {
        			System.out.println("\n" + e.getMessage());
        		}
        		break;
        		        		
        	
        	case 2:
        		System.out.println("Insert class you intend to add an inscription:");
        		int classId = scanner.nextInt();
        		System.out.println("Insert inscription ID you intend to add:");
        		int inscriptionId = scanner.nextInt();
        		
        		try {
            		clazz = clazzService.getClazz(classId);
            		inscription = inscriptionService.getInscription(inscriptionId);
            		if (inscription.getScore() >= 6 && inscription.getPresence() == Presence.SUFFICIENT) {
            			clazz.addInscription(inscription);
            			inscription.addClazz(clazz);
                		System.out.println("Inscription " + inscription.getId() + " added successfully!");            			
            		} else {
            			System.out.println("Student doesn't have the basic requirements!");
            		}
        		} catch (ObjectDoesntExist e) {
        			System.out.println("\n" + e.getMessage());
        		}
        		break;

    		
        	case 3:
        		System.out.println("Insert Class ID you intend to delete:");
        		id = scanner.nextInt();
        		
        		try {
            		clazz = clazzService.getClazz(id);
            		professor = clazz.getProfessor();
            		discipline = clazz.getDiscipline();
            		for (Inscription currentInscription : clazz.getInscriptions()) {
            			currentInscription.removeClazz(clazz);
            		}
            		professor.removeClazz(clazz);
            		discipline.removeClass(clazz);
            		clazzService.deleteClazz(id);
            		System.out.println("Class deleted successfully!");
        		} catch (ObjectDoesntExist e) {
        			System.out.println(e.getMessage());
        		}
        		break;
        		
        	case 4:
        		//studentService.getAllStudents().values().forEach(System.out::println);
        		List<Clazz> clazzes= clazzService.getAllClazzes();
        		for (Clazz currentClazz : clazzes) {
        			System.out.println(currentClazz);
        		}
        		break;
        		
        	case 5:
        		System.out.println("Insert class ID:");
        		id = scanner.nextInt();
        		
        		clazz = clazzService.getClazz(id);
        		int count = 0;
        		for (Inscription currentInscription : clazz.getInscriptions()) {
        			count++;
        		}
        		System.out.println("Quantity of approved students: " + count);
        		break;
        		
        	case 6:
        		//printMenu = false;
        		return;
        	default:
        		System.out.println("\n" + "Invalid option!");        		
        	}
        }
	}
}

