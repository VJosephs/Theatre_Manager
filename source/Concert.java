import java.util.Date;

public class Concert extends Show {

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
