import java.util.ArrayList;
import java.util.Date;

public class Employee extends User {
    private Theatre location;
    
    public Employee() {}
    
    /**
     * Creates a new show
     *
     * @param firstName      actual first name of the user for account
     * @param lastname       actual last name of the user for account
     * @param username       made up name for the users account  
     * @param bithday        actual birthday of the user to verify age restrictions
     * @param password       String to keep the account protected and private
     */

    public Employee(String firstName, String lastName, String username, Date birthday, String password) {
        super(firstName, lastName, username, birthday, password);
    }

    public void refund(String username, ArrayList<User> users) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                user.refundTicket();
            }
        }
    }

    public void addShow(Show show) {
        location.addShow(show);
    }

    public void viewTicketSales() {
        System.out.println(location.getTicketSales());

    }

    public void removeTheatreRating(Rating rating) {
        location.removeRating(rating);
    }

    public void removeShowRating(Rating rating, Show show) {
        show.removeShowRating(rating);
    }

    public void setTheatre(Theatre location) {
        this.location = location;
    }
    
    public Theatre getLocation() {
    	return this.location;
    }
}
