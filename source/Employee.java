import java.util.ArrayList;
import java.util.Date;

public class Employee extends User {
    private Theatre location;

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
}
