

import java.util.Date;

public class Play extends Show {

    /**
     * Creates a new play
     *
     * @param name        The name of the play
     * @param description The description of the play
     * @param genre       The genre of the play
     * @param ageRating   The age rating of the play
     * @param showTime    The time that the play is being played
     * @param location    The theater that the play is at.
     * @param price       The amount a ticket for the play costs
     */
    public Play(String name, String description, String genre, String ageRating, Date showTime, Theatre location, double price) {
        super(name, description, genre, ageRating, showTime, location, price);
    }

    /**
     * Returns the age required to see a play based on its rating
     *
     * @return The minimum age required to see the play
     */
    public int getAgeRating() {
        switch (ageRating) {
            case "18+":
                return 18;
            case "16+":
                return 16;
            case "13+":
                return 13;
            case "10+":
                return 10;
            default:
                return 0;
        }
    }
}
