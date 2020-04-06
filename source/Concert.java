import java.util.Date;

public class Concert extends Show {

	/**
     * Creates a new concert
     * @param name The name of the concert
     * @param description The description of the concert
     * @param genre The genre of the concert
     * @param ageRating The age rating of the concert
     * @param showTime The time that the concert is being played
     * @param location The theater that the concert is at.
     * @param price The amount a ticket for the concert costs
     */
    public Concert(String name, String description, String genre, String ageRating, Date showTime, Theatre location, double price) {
        super(name, description, genre,ageRating,showTime, location, price);
    }

    /**
     * Returns the age required to go to the concert based on its rating
     * @return The minimum age required to go to the concert
     */
    public int getAgeRating() {
    	if(ageRating.equals("18+"))
        	return 18;
        else
        	return 0;
    }


}
