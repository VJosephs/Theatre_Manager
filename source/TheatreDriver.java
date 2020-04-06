

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class TheatreDriver {
    public static ArrayList<User> users = new ArrayList<User>();
    public static ArrayList<Theatre> theatres = new ArrayList<Theatre>();
    public Scanner input;
    private static JSONReader reader;
    public static boolean quitter = false;
    public static Scanner keyboard = new Scanner(System.in);
    public static User signedInUser = new User();

    public static void main(String[] args) {
    	System.out.println("******************************************************************");
    	System.out.println("*********    Welcome to the Theatre Management System    *********");
    	System.out.println("******************************************************************");
    	System.out.println();
		getUnsignedInUI();
    	while(!quitter) {

    		int choice = keyboard.nextInt();
    		switch(choice) {
    			case 0:
    				getUnsignedInUI();
    			;
    			case 1:
    				users.add(createAccount());
    				signedInUI();
    				break;
    			case 2:
    				System.out.println("Enter Username: ");
    				String un = keyboard.nextLine();
    				keyboard.nextLine();
    				System.out.println("Enter password");
    				String pw = keyboard.nextLine();
    				signIn(un, pw);
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
    				printGoodbye();
    				quitter = true;
    				break;
    		}
    		System.out.println();
    		System.out.println();
    				
    	}
    	
    }
    
    public static void signedInUI() {
    	while(!quitter) {

    		int choice = keyboard.nextInt();
    		switch(choice) {
    			case 0:
    				getSignedInUI();
    			;
    			case 1:
    				break;
    			case 2:
    				getRewardPoints();
    				break;
    			case 3:
    				break;

    			case 4:
    				ConcessionMenu();
    				break;
    			case 5:
    				printSystemSupport();
    				break;
    			case 6:
    				quitter = true;
    				printGoodbye();
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
    
    public static void getUnsignedInUI() {
    	System.out.println("To get this menu again press 0");
    	System.out.println("To create an account enter 1");
    	System.out.println("To sign in enter 2");
    	System.out.println("To find a theatre enter 3");
    	System.out.println("To view your Tickets enter 4");
    	System.out.println("To view concessions enter 5");
    	System.out.println("For support enter 6");
    	System.out.println("To quit enter 7");
    	
    }
    
    public static void getSignedInUI() {
    	System.out.println("To get this menu again press 0");
    	System.out.println("To find a theatre enter 1");
    	System.out.println("To view your rewards points enter 2");
    	System.out.println("To view your Tickets enter 3");
    	System.out.println("To view concessions enter 4");
    	System.out.println("For support enter 5");
    	System.out.println("To quit enter 6");
    }
    
    public static void printGoodbye() {
    	System.out.println("****************************************");
    	System.out.println("*              Goodbye!!               *");
    	System.out.println("****************************************");
    }
    
    public static User createAccount() {
    	System.out.println("What is your first name?");
    	String firstName = keyboard.nextLine();
    	keyboard.nextLine();
    	System.out.println("What is your last name?");
    	String lastName = keyboard.nextLine();
    	Date birthday = new Date();
    	System.out.println("What month were you born in?(Please use the number of the month you were born in)");
    	birthday.setMonth(keyboard.nextInt());
    	keyboard.nextLine();
    	System.out.println("What day were you born?");
    	birthday.setDate(keyboard.nextInt());
    	keyboard.nextLine();
    	System.out.println("What year were you born?");
    	birthday.setYear(keyboard.nextInt());
    	keyboard.nextLine();
    	System.out.println("What do you want as your username?");
    	String username = keyboard.nextLine();
    	System.out.println("What is your password?");
    	String password = keyboard.nextLine();
    	User user = new User(firstName, lastName,  username, birthday, password);
    	if(users.contains(user)) {
    		System.out.println("Account in use.....");
    		return null;
    	}
    	System.out.println("**   Account Created !!   **");
    	System.out.println();
    	System.out.println("**     Logging you in.     **");
    	System.out.println();
    	return user;
    }
    
    public static boolean signIn(String username, String password) {
    	for(User user: users) {
    		if(user.getUsername() == username && user.getPassword() == password) {
    			signedInUser = user;
    			return true;
    		}
    	}
    	System.out.println("!!!!!!!!!!!!!!!!!!!");
    	System.out.println("!  Access DENIED  !");
    	System.out.println("!!!!!!!!!!!!!!!!!!!");
    	return false;
    }
    public static void getRewardPoints() {
    	
    	System.out.println("**************************************");
    	System.out.println("You have " + signedInUser.getRewardpoints() + " rewards points");
    	System.out.println("**************************************");
    	
    }

}