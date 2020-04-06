import java.util.Date;

public class Concert extends Show {

    public Concert(String name, String description, String genre, String showRating, Date showTime, Theatre location, double price) {
        super(name, description, genre,showRating,showTime, location, price);
    }

    public int getAgeRating() {
    	if(showRating.equals("18+"))
        	return 18;
        else
        	return 0;
    }


}
