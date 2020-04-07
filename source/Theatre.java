

import java.util.ArrayList;

public class Theatre implements Comparable<Theatre> {

    private String name;
    private String address;
    private Layout layout;
    private ArrayList<Rating> ratings = new ArrayList<>();
    private ArrayList<Show> shows = new ArrayList<>();


    /**
     * @param name    name of the theater
     * @param address adress of the theater or its location
     * @param layout  layout of the seating at this specific theater
     * @param ratings ratings of events at the theater
     * @param shows   what type of shows will be shwon at the theater
     */
    public Theatre(String name, String address, Layout layout, ArrayList<Rating> ratings,
                   ArrayList<Show> shows) {
        this.name = name;
        this.address = address;
        this.layout = layout;
        setRatings(ratings);
        setShows(shows);
    }

    public Theatre(String name, String address, Layout layout) {
        this.name = name;
        this.address = address;
        this.layout = layout;
        this.ratings = new ArrayList<>();
        this.shows = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Theatre [name=" + name + ", address=" + address + "  " + getAvgRating() + "/5]";
    }

    public void addShow(Show show) {
        shows.add(show);
    }

    public void removeShow(Show show) {
        shows.remove(show);
    }

    public void addRating(Rating rating) {
        ratings.add(rating);
    }

    public void removeRating(Rating rating) {
        ratings.remove(rating);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Layout getLayout() {
        return layout;
    }

    public ArrayList<Rating> getRatings() {
        return ratings;
    }

    public ArrayList<Show> getShows() {
        return shows;
    }

    public void setLayout(Layout layout) {
        this.layout = layout;
    }

    public double getAvgRating() {
        double sum = 0;
        for (Rating r : ratings) {
            sum += r.getRating();
        }
        return sum / ratings.size();
    }

    public void setRatings(ArrayList<Rating> ratings) {
        if (ratings == null)
            ratings = new ArrayList<>();
        this.ratings = ratings;
    }

    public void setShows(ArrayList<Show> shows) {
        if (shows == null)
            shows = new ArrayList<>();
        this.shows = shows;
    }

    @Override
    public int compareTo(Theatre o) {
        return Double.compare(this.getAvgRating(), o.getAvgRating());
    }

    public void removeTheatreRating(Rating rating) {
        for (Rating rating1 : ratings) {
            if (rating1.equals(rating)) {
                ratings.remove(rating);
            }
        }
    }

    public double getTicketSales() {
        double sales = 0;
        for (Show show : shows) {
            sales += show.getTicketSale();
        }
        return sales;
    }
}
