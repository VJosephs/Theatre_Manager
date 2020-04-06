

import java.util.Date;

public class Movie extends Show {
    public Movie(String name, String description, String genre, String ageRating, Date showTime, Theatre location, double price) {
        super(name, description, genre,ageRating,showTime, location, price);
    }

    /**
     * Returns the age required in order to see the movie based on its rating
     * @return The minimum age required to see the movie
     */
    public int getAgeRating() {
        if(ageRating.equals("R"))
        	return 17;
        else if(ageRating.equals("PG-13"))
        	return 13;
        else
        	return 0;
    }

}
