import java.util.ArrayList;
import java.util.Date;

public class Show {

    protected String name, genre, description, ageRating;
    private Date showTime;
    private double price;
    private Theatre location;
    private ArrayList<String> cast;
    private ArrayList<Rating> ratings;
    private ArrayList<Ticket> purchasedTickets;

    public Show(String name, String description, String genre, String ageRating, Date showTime, Theatre location, double price) {
        this.name = name;
        this.description = description;
        this.showTime = showTime;
        this.location = location;
        this.price = price;
        this.ageRating = ageRating;
        this.genre = genre;
    }

    public String getName() {
        return name;
    }

    public String getGenre() {
        return genre;
    }

    public String getDescription() {

        return description;
    }

    public String getShowRating() {
        return ageRating;
    }

    public Date getShowTime() {
        return showTime;
    }

    public double getPrice() {
        return price;
    }

    public double getAvgRating() {
        double sum = 0;
        for(Rating r : ratings) {
            sum += r.getRating();
        }
        return sum / ratings.size();
    }

    public Theatre getLocation() {
        return location;
    }

    public ArrayList<String> getCast() {
        return cast;
    }

    public ArrayList<Rating> getRatings() {
        return ratings;
    }

    public ArrayList<Ticket> getPurchasedTickets() {
        return purchasedTickets;
    }

    public String toString() {
        //TODO write toString
    	return null;
    }
}