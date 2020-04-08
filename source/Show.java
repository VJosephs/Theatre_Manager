import java.util.ArrayList;
import java.util.Date;

public class Show implements Comparable<Show> {

    protected String name, genre, description, ageRating;
    private Date showTime;
    private double price;
    private String location;
    private ArrayList<String> cast = new ArrayList<String>();
    private ArrayList<Rating> ratings = new ArrayList<Rating>();
    private ArrayList<Ticket> purchasedTickets = new ArrayList<Ticket>();

    /**
     * Creates a new show
     *
     * @param name        The name of the Show
     * @param description The description of the Show
     * @param genre       The genre of the Show
     * @param ageRating   The age rating of the show
     * @param showTime    The time that the show is being played
     * @param location    The theater that the show is at.
     * @param price       The amount a ticket for the show costs
     * @return n/a     its a constructor
     * @throws n/a
     */
    public Show(String name, String description, String genre, String ageRating, Date showTime, String location, double price) {
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

    /**
     * Averages together all of the ratings of a show
     *
     * @return The average rating of the show
     */
    public double getAvgRating() {
        double sum = 0;
        for (Rating r : ratings) {
            sum += r.getRating();
        }
        return sum / ratings.size();
    }

    public String getLocation() {
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


    @Override
    public int compareTo(Show o) {
        return Double.compare(this.getAvgRating(), o.getAvgRating());
    }

    public void removeShowRating(Rating rating) {
        for (Rating rating1 : ratings) {
            if (rating1.equals(rating)) {
                ratings.remove(rating);
            }
        }
    }

    public double getTicketSale() {
        int ticketSold = purchasedTickets.size() + 1;
        return price * ticketSold;
    }

    public void recieveRating(Rating rating) {
    	this.ratings.add(rating);
    }
}
