

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class TheatreDriver {
    public static ArrayList<User> users = new ArrayList<>();
    public static ArrayList<Theatre> theatres = new ArrayList<>();
    public static ArrayList<Layout> layouts = new ArrayList<>();
    private static JSONReader reader = new JSONReader(users,theatres);
    public static boolean quitter = false;
    public static Scanner keyboard = new Scanner(System.in);
    public static User signedInUser = new User();

    public static void main(String[] args) {

        System.out.println("******************************************************************");
        System.out.println("*********    Welcome to the Theatre Management System    *********");
        System.out.println("******************************************************************");
        System.out.println();
        getUnsignedInUI();
        while (!quitter) {

            int choice = keyboard.nextInt();
            switch (choice) {
                case 0:
                    getUnsignedInUI();
                    break;
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
                    if (!signIn(un, pw)) {
                        getUnsignedInUI();
                    } else {
                        signedInUI();
                    }
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
            getUnsignedInUI();

        }


    }

    public static void signedInUI() {
        while (!quitter) {

            int choice = keyboard.nextInt();
            switch (choice) {
                case 0:
                    getSignedInUI();
                    break;
                case 1:
                    theatres.add(createNewTheatreUI(keyboard)); //TODO move this to the right place
                    break;
                case 2:
                    getRewardPoints();
                    break;
                case 3:
                    reader.writeToFile(); //TODO move this to the right place
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
            getSignedInUI();

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
        keyboard.nextLine();
        String firstName = keyboard.nextLine();
        System.out.println("What is your last name?");
        String lastName = keyboard.nextLine();
        Date birthday = getDate();

        System.out.println("What do you want as your username?");
        String username = keyboard.nextLine();
        System.out.println("What is your password?");
        String password = keyboard.nextLine();
        User user = new User(firstName, lastName, username, birthday, password);
        if (users.contains(user)) {
            System.out.println("Account in use.....");
            return null;
        }
        System.out.println("**   Account Created !!   **");
        System.out.println();
        System.out.println("**     Logging you in.     **");
        System.out.println();
        getSignedInUI();
        return user;
    }

    public static Date getDate() {
        System.out.println("Enter your date of birth mm/dd/yy");
        String birthDay = keyboard.nextLine();
        Date retDate;

        if (birthDay.matches("[0-9]{2}([/\\-])[0-9]{2}([/\\-])[0-9]{2,}")) {
            String[] birthDayParts = birthDay.split("[/\\-]");
            int month = Integer.parseInt(birthDayParts[0]);
            int day = Integer.parseInt(birthDayParts[1]);
            int year = Integer.parseInt(birthDayParts[2]);

            switch (month) {
                case 2:
                    month = Calendar.FEBRUARY;
                    break;
                case 3:
                    month = Calendar.MARCH;
                    break;
                case 4:
                    month = Calendar.APRIL;
                    break;
                case 5:
                    month = Calendar.MAY;
                    break;
                case 6:
                    month = Calendar.JUNE;
                    break;
                case 7:
                    month = Calendar.JULY;
                    break;
                case 8:
                    month = Calendar.AUGUST;
                    break;
                case 9:
                    month = Calendar.SEPTEMBER;
                    break;
                case 10:
                    month = Calendar.OCTOBER;
                    break;
                case 11:
                    month = Calendar.NOVEMBER;
                    break;
                case 12:
                    month = Calendar.DECEMBER;
                    break;
                default:
                    month = Calendar.JANUARY;

            }
            retDate = new Date(year, month, day);
        } else {
            retDate = getDate();
        }
        return retDate;
    }

    public static Theatre createNewTheatreUI(Scanner input) {
        input.nextLine();
        Layout layout;
        System.out.println("Enter Theatre Name: ");
        String name = input.nextLine();
        System.out.println("Enter Theatre address: ");
        String address = input.nextLine();
        System.out.println("You must not choose or create a layout, type 'choose' or 'create'");
        if (input.nextLine().equalsIgnoreCase("Choose")) {
            System.out.println("type a name of the layout you would like to use");
            layout = findLayout(input.nextLine());
            if (layout == null) {
                System.out.println("The layout was not found you must create a new one");
                layout = createNewLayout(input);
            }
        }
        else {
            layout = createNewLayout(input);
        }
        return new Theatre(name, address, layout);
    }

    public static Layout createNewLayout(Scanner input) {
        System.out.println("What will be the name of this layout?");
        String name = input.nextLine();
        Layout layout = new Layout(name);
        layout.makeLayout(input);
        return layout;
    }

    public static Layout findLayout(String name) {
        for (Layout l : layouts) {
            if (l.getName().equalsIgnoreCase(name))
                return l;
        }
        return null;
    }

    public static boolean signIn(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
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
        System.out.println("You have " + signedInUser.getRewardsPoints() + " rewards points");
        System.out.println("**************************************");

    }

}