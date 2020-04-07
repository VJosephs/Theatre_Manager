

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class TheatreDriver {
    public static ArrayList<User> users = new ArrayList<>();
    public static ArrayList<Theatre> theatres = new ArrayList<>();
    public static ArrayList<Layout> layouts = new ArrayList<>();
    private static JSONWriter jsonWriter = new JSONWriter(users, theatres);
    private static JSONReader jsonReader = new JSONReader();
    public static boolean quitter = false;
    public static Scanner keyboard = new Scanner(System.in);
    public static User signedInUser = new User();
    public static Employee signedInEmployee = new Employee();

    public static void main(String[] args) {

        System.out.println("******************************************************************");
        System.out.println("*********    Welcome to the Theatre Management System    *********");
        System.out.println("******************************************************************");
        System.out.println();
        getUnsignedInUI();
        unsignedInUI();

    }

    public static void signedInUI() {
        getSignedInUI();
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
                    //TODO move this to the right place
                    break;
                case 4:
                    ConcessionMenu();
                    break;
                case 5:
                    printSystemSupport();
                    break;
                case 6:
                    signOut();
                case 7:
                    quitter = true;
                    printGoodbye();
                    break;
                case 8:
                    jsonWriter.writeToFile();
                case 9:
                    load();
            }
            System.out.println();

        }
    }

    public static void load() {
        theatres = jsonReader.getTheatres();
        users = jsonReader.getUsers();
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
        System.out.println("To save enter 8");
        System.out.println("To Load enter 9");

    }

    public static void getSignedInUI() {
        System.out.println("To get this menu again enter 0");
        System.out.println("To find a theatre enter 1");
        System.out.println("To view your rewards points enter 2");
        System.out.println("To view your Tickets enter 3");
        System.out.println("To view concessions enter 4");
        System.out.println("For support enter 5");
        System.out.println("To sign out enter 6");
        System.out.println("To save enter 8");
        System.out.println("To Load enter 9");
    }

    public static void getEmployeeUI() {
        System.out.println("To get this menu again enter 0");
        System.out.println("To perform a refund enter 1");
        System.out.println("To view ticket sales enter 2");
        System.out.println("To add a show enter 3");
        System.out.println("To view concessions enter 4");
        System.out.println("To add a theatre enter 5");
        System.out.println("To sing out enter 6");
        System.out.println("To save enter 8");
        System.out.println("To Load enter 9");
    }

    public static void EmployeeUI() {
        while (!quitter) {
            getEmployeeUI();
            keyboard.nextLine();
            int choice = keyboard.nextInt();
            switch (choice) {
                case 0:
                    getEmployeeUI();
                    break;
                case 1:
                    System.out.println("enter the username of the user to refund");
                    String username = keyboard.nextLine();
                    signedInEmployee.refund(username, users);
                    break;
                case 2:
                    System.out.println("$" + signedInEmployee.getLocation().getTicketSales());
                    break;
                case 3:
                    addNewShow();
                    break;

                case 4:
                    ConcessionMenu();
                    break;
                case 5:
                    theatres.add(createNewTheatreUI(keyboard));
                    break;
                case 6:
                    signOut();
                case 7:
                    quitter = true;
                    printGoodbye();
                    break;
                case 8:
                    jsonWriter.writeToFile();
                    break;
                case 9:
                    load();
            }
            System.out.println();

        }
    }


    public static void printGoodbye() {
        System.out.println("****************************************");
        System.out.println("*              Goodbye!!               *");
        System.out.println("****************************************");
    }

    public static int createAccount() {
        keyboard.nextLine();
        System.out.println("Are you an Employee?(Answer 'yes' or 'no'");
        String emp = keyboard.nextLine();

        if (emp.equalsIgnoreCase("yes")) {
            creatEmployee();
            return 1;
        } else {
            createAverageUser();
            return 2;
        }
    }

    public static User createUser() {
        System.out.println("What is your first name?");
        String firstName = keyboard.nextLine();
        System.out.println("What is your last name?");
        String lastName = keyboard.nextLine();
        Date birthday = getDate();
        System.out.println("What do you want as your username?");
        String username = keyboard.nextLine();
        System.out.println("What is your password?");
        String password = keyboard.nextLine();
        getSignedInUI();
        return new User(firstName, lastName, username, birthday, password);
    }

    public static void creatEmployee() {
        System.out.println("What is your first name?");
        String firstName = keyboard.nextLine();
        System.out.println("What is your last name?");
        String lastName = keyboard.nextLine();
        Date birthday = getDate();
        System.out.println("What do you want as your username?");
        String username = keyboard.nextLine();
        System.out.println("What is your password?");
        String password = keyboard.nextLine();
        Employee user = new Employee(firstName, lastName, username, birthday, password);
        System.out.println("**   Account Created !!   **");
        System.out.println();
        System.out.println("**     Logging you in.     **");
        System.out.println();
        if (theatres.size() > 0) {
            System.out.println("What theatre do you work at?(please choose the number)");
            printTheatres();
            int choice = keyboard.nextInt();
            Theatre location = theatres.get(choice);
            user.setTheatre(location);
        }
        users.add(user);
        signedInUser = user;
        signedInEmployee = user;
    }

    public static void createAverageUser() {
        User user = createUser();
        if (users.contains(user)) {
            System.out.println("Account in use.....");
            return;
        }
        System.out.println("**   Account Created !!   **");
        System.out.println();
        System.out.println("**     Logging you in.     **");
        System.out.println();
        users.add(user);
        signedInUser = user;
    }


    public static Date getShowtime() {
        System.out.println("When is the show Date? mm/dd/yy");
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
        } else {
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

    public static void printTheatres() {
        for (int i = 0; i < theatres.size(); i++) {
            System.out.println(i + ": " + theatres.get(i).toString());
        }
    }

    public static void addNewShow() {
        Theatre theatre = signedInEmployee.getLocation();
        System.out.println("What type of show is it?(Enter the Number)");
        System.out.println("1. Movie");
        System.out.println("2. Concert");
        System.out.println("3. Play");
        int choice = keyboard.nextInt();
        keyboard.nextLine();
        System.out.println("What is the name of the play?");
        String name = keyboard.nextLine();
        System.out.println("Give a Description of the show.");
        String desc = keyboard.nextLine();
        System.out.println("What Genre is it?");
        String genre = keyboard.nextLine();
        Date showTime = getShowtime();
        System.out.println("What is the price of admission(Enter just a number)");
        double price = keyboard.nextDouble();
        keyboard.nextLine();
        if (choice == 1) {
            System.out.println("What is the age rating for the Movie?");
            String ageRating = keyboard.nextLine();
            Movie movie = new Movie(name, desc, genre, ageRating, showTime, theatre.getAddress(), price);
            theatre.addShow(movie);
        } else if (choice == 2) {
            System.out.println("What is the age rating for the Concert?");
            String ageRating = keyboard.nextLine();
            Concert concert = new Concert(name, desc, genre, ageRating, showTime, theatre.getAddress(), price);
            theatre.addShow(concert);
        } else if (choice == 3) {
            System.out.println("What is the age rating for the Play?");
            String ageRating = keyboard.nextLine();
            Play play = new Play(name, desc, genre, ageRating, showTime, theatre.getAddress(), price);
            theatre.addShow(play);
        }
    }

    public static void signOut() {
        signedInUser = null;
        signedInEmployee = null;
        System.out.println("**     Signing you out     **");
        unsignedInUI();
    }

    public static void unsignedInUI() {
        while (!quitter) {

            int choice = keyboard.nextInt();
            switch (choice) {
                case 0:
                    getUnsignedInUI();
                    break;
                case 1:
                    int i = createAccount();
                    if (i == 1)
                        EmployeeUI();
                    else if (i == 2)
                        signedInUI();
                    break;
                case 2:
                    keyboard.nextLine();
                    System.out.println("Enter Username: ");
                    String un = keyboard.nextLine();
                    System.out.println("Enter password");
                    String pw = keyboard.nextLine();
                    if (!signIn(un, pw)) {
                        getUnsignedInUI();
                    } else {
                        signedInUI();
                    }
                    break;
                case 3:
                    printTheatres();
                case 4:
                    break;
                case 5:
                    buyTicket();
                    break;
                case 6:
                    printSystemSupport();
                    break;
                case 7:
                    printGoodbye();
                    quitter = true;
                    break;
                case 8:
                    jsonWriter.writeToFile();
                case 9:
                    load();
            }
            System.out.println();

        }
    }

    public static void buyTicket() {
        System.out.println("To what theatre will you be going? Type the number");
        printTheatres();
        int theatreNum = keyboard.nextInt();
        keyboard.nextLine();
        Theatre t = theatres.get(theatreNum);
        System.out.println("To what show will you be going?");
        printShows(t);
        int showNum = keyboard.nextInt();
        keyboard.nextLine();

        selectSeats(t, t.getShows().get(showNum));

    }

    public static void printShows(Theatre t) {
        for (Show s : t.getShows())
            System.out.println(s.getName());
    }

    public static void selectSeats(Theatre t, Show s) {
        String input = "";
        while (!input.equalsIgnoreCase("done")) {
            Ticket ticket = new Ticket(s.name, s.getLocation(), s.getPrice());
            if (signedInUser != null) {
                signedInUser.getCart().addTicket(ticket);
            }
            System.out.println("Which seats will you buy?");
            System.out.println("Seat format Column Letter row number 'A12'");
            input = keyboard.nextLine();
            String seatString = takeSeat(input, t);
            ticket.print(s, seatString);
        }
    }

    public static String takeSeat(String s, Theatre t) {
        while (!s.matches("[A-Za-z][0-9]+")) {
            if (s.equalsIgnoreCase("done")) {
                return "";
            }
            System.out.println("This is an invalid seat please try again");
            s = keyboard.nextLine();
        }
        int j = s.charAt(0) - 65;
        int i = Integer.parseInt(s.replaceAll("[a-zA-Z]", ""));

        t.getLayout().getSeats()[i][j] = new Seat("unavailable");
        t.getLayout().printLayout();
        return s;
    }


}
