

import java.util.Date;

public class Movie extends Show {
    public Movie(String name, String description, String genre, String showRating, Date showTime, Theatre location, double price) {
        super(name, description, genre,showRating,showTime, location, price);
    }

    public int getAgeRating() {
        //TODO add method body
        return 0;
    }

}
