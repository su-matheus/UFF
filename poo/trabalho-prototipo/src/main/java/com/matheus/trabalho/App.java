package com.matheus.trabalho;

import java.util.Scanner;


public class App {
    public static void main( String[] args ){
    	Scanner scanner = new Scanner(System.in);
    	StudentMenu studentMenu = new StudentMenu();
    	ProfessorMenu professorMenu = new ProfessorMenu();
    	ClazzMenu clazzMenu = new ClazzMenu();
    	InscriptionMenu inscriptionMenu = new InscriptionMenu();

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
    			case 6:
    				System.out.print('\f');
    				System.exit(0);
    				return;
				default:
					System.out.println("Invalid choice. Please try again.");
    		}
    	}
	}
}
