

import java.util.Date;

public class Movie extends Show {

    /**
     * Creates a new movie
     *
     * @param name        The name of the movie
     * @param description The description of the movie
     * @param genre       The genre of the movie
     * @param ageRating   The age rating of the movie
     * @param showTime    The time that the movie is being played
     * @param location    The theater that the movie is at.
     * @param price       The amount a ticket for the movie costs
     */
    public Movie(String name, String description, String genre, String ageRating, Date showTime, Theatre location, double price) {
        super(name, description, genre, ageRating, showTime, location, price);
    }

    /**
     * Returns the age required in order to see the movie based on its rating
     *
     * @return The minimum age required to see the movie
     */
    public int getAgeRating() {
        if (ageRating.equals("R"))
            return 17;
        else if (ageRating.equals("PG-13"))
            return 13;
        else
            return 0;
    }

}
