import java.util.Date;

public class Concert extends Show {

    /**
     * Creates a new concert
     *
     * @param name        The name of the concert
     * @param description The description of the concert
     * @param genre       The genre of the concert
     * @param ageRating   The age rating of the concert
     * @param showTime    The time that the concert is being played
     * @param location    The theater that the concert is at.
     * @param price       The amount a ticket for the concert costs
     * @return n/a   its a constructor
     * @exception  n/a
     */
    public Concert(String name, String description, String genre, String ageRating, Date showTime, String location, double price) {
        super(name, description, genre, ageRating, showTime, location, price);
    }

    /**
     * Returns the age required to go to the concert based on its rating
     * @param         none
     * @return int    the minimum age required to go to the concert
     * @exception     n/a
     */
    public int getAgeRating() {
        if (ageRating.equals("18+"))
            return 18;
        else if (ageRating.equals("21+"))
            return 21;
        else
            return 0;
    }


}
