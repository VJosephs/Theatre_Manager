

import java.util.Date;

public class Play extends Show {

    public Play(String name, String description, String genre, String showRating, Date showTime, Theatre location, double price) {
        super(name, description, genre,showRating,showTime, location, price);
    }

    public int getAgeRating() {
    	if(showRating.equals("18+"))
        	return 18;
    	else if(showRating.equals("16+"))
    		return 16;
    	else if(showRating.equals("13+"))
    		return 13;
    	else if(showRating.equals("10+"))
    		return 10;
        else
        	return 0;
    }
}
