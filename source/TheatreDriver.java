

import java.util.ArrayList;
import java.util.Scanner;

public class TheatreDriver {
    public ArrayList<User> users;
    public ArrayList<Theatre> theatres;
    public Scanner input;
    private static JSONReader reader;
    public static boolean quitter = false;
    public static Scanner keyboard = new Scanner(System.in);

    public static void main(String[] args) {
    	System.out.println("******************************************************************");
    	System.out.println("*********    Welcome to the Theatre Management System    *********");
    	System.out.println("******************************************************************");
    	System.out.println();
    	while(quitter == false) {
    		getUI();
    		int choice = keyboard.nextInt();
    		switch(choice) {
    			case 1:
    				break;
    			case 2:
    				break;
    			case 3:
    				break;
    			case 4:
    				break;
    			case 5:
    				ConcessionMenu();
    				break;
    			case 6:
    				printSystemSupport();
    				break;
    			case 7:
    				quitter = true;
    				break;
    		}
    		System.out.println();
    		System.out.println();
    				
    	}
    	
    }

    public static void printSystemSupport() {
       System.out.println("****************************************");
       System.out.println("*  Support Line Number: (803)555-5555  *");
       System.out.println("****************************************");
    }

    public static void ConcessionMenu() {
        //TODO add method body
    	System.out.println("****************************************");
    	System.out.println("*            Coming Soon!              *");
    	System.out.println("****************************************");
    }
    
    public static void getUI() {
    	System.out.println("To create an account enter 1");
    	System.out.println("To find a theatre enter 2");
    	System.out.println("To view your rewards points enter 3");
    	System.out.println("To view your Tickets enter 4");
    	System.out.println("To view concessions enter 5");
    	System.out.println("For support enter 6");
    	System.out.println("To quit enter 7");
    	
    }
    
    public static void printGoodbye() {
    	System.out.println("****************************************");
    	System.out.println("*              Goodbye!!               *");
    	System.out.println("****************************************");
    }

}