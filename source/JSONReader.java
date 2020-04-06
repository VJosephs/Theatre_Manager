import java.util.ArrayList;
import java.io.IOException;
import java.io.FileWriter;
import java.util.Date;

import org.json.JSONArray;
import org.json.JSONObject;

public class JSONReader extends JSONConstants {

    public String CONFIG_USERS;
    public String CONFIG_THEATRES;
    public final String FILE_NAME = "config/config.json";

    private ArrayList<User> users;
    private ArrayList<Theatre> theatres;

    JSONReader(ArrayList<User> users, ArrayList<Theatre> theatres) {
        this.users = users;
        this.theatres = theatres;
    }


    private String readJSON(String fileName) {
        //TODO add method body
        return null;
    }

    private void writeJSON() {
        JSONArray jsonTheatres = new JSONArray();
        for (Theatre theatre : theatres) {
            jsonTheatres.put(theatre);
        }

    }

    private JSONObject getTheatreJSON(Theatre theatre) {
        JSONObject theatreJSON = new JSONObject();
        theatreJSON.put(THEATRE_ADDRESS, theatre.getAddress());
        theatreJSON.put(THEATRE_LAYOUT, getLayoutJSON(theatre.getLayout()));
        theatreJSON.put(THEATRE_NAME, theatre.getName());
        theatreJSON.put(THEATRE_RATINGS, getRatingArrayJSON(theatre.getRatings()));
        theatreJSON.put(THEATRE_SHOWS, getShowArrayJSON(theatre.getShows()));
        return theatreJSON;
    }

    private JSONArray getShowArrayJSON(ArrayList<Show> shows) {
        JSONArray showsJSON = new JSONArray();
        for (Show show : shows) {
            showsJSON.put(getShowJSON(show));
        }
        return showsJSON;
    }


    private JSONObject getShowJSON(Show show) {
        JSONObject showJSON = new JSONObject();
        showJSON.put(SHOW_AGE_RATING, show.getShowRating());
        showJSON.put(SHOW_DESCRIPTION, show.getDescription());
        showJSON.put(SHOW_GENRE, show.getGenre());
        showJSON.put(SHOW_LOCATION, show.getLocation());
        showJSON.put(SHOW_SHOW_TIME, show.getShowTime());
        showJSON.put(SHOW_PRICE, show.getPrice());
        showJSON.put(SHOW_NAME, show.getName());
        showJSON.put(SHOW_CAST, getStringArrayJSON(show.getCast()));
        showJSON.put(SHOW_RATINGS, getRatingArrayJSON(show.getRatings()));
        showJSON.put(SHOW_PURCHASED_TICKETS, getTicketArray(show.getPurchasedTickets()));
        return showJSON;
    }

    private JSONArray getTicketArray(ArrayList<Ticket> tickets) {
        JSONArray ticketsArrayJSON = new JSONArray();
        for (Ticket ticket : tickets) {
            ticketsArrayJSON.put(getTicketJSON(ticket));
        }
        return ticketsArrayJSON;
    }

    private JSONObject getTicketJSON(Ticket ticket) {
        JSONObject ticketJSON = new JSONObject();
        ticketJSON.put(TICKET_LOCATION, ticket.getLocation());
        ticketJSON.put(TICKET_PRICE, ticket.getPrice());
        ticketJSON.put(TICKET_SHOW, ticket.getShow());
        return ticketJSON;
    }

    private JSONArray getStringArrayJSON(ArrayList<String> strings) {
        JSONArray stringsJSON = new JSONArray();
        for (String s : strings) {
            stringsJSON.put(s);
        }
        return stringsJSON;
    }

    private JSONObject getDateJSON(Date date) {
        JSONObject dateJSON = new JSONObject();
        //TODO do this later dateJSON.put("")
        return dateJSON;
    }


    private JSONArray getRatingArrayJSON(ArrayList<Rating> ratings) {
        JSONArray ratingsJSON = new JSONArray();
        for (Rating rating : ratings) {
            ratingsJSON.put(getRatingJSON(rating));
        }
        return ratingsJSON;
    }

    private JSONObject getRatingJSON(Rating rating) {
        JSONObject ratingJSON = new JSONObject();
        ratingJSON.put(RATING_COMMENT, rating.getComment());
        ratingJSON.put(RATING_RATING, rating.getRating());
        ratingJSON.put(RATING_USERNAME, rating.getUserName());
        return ratingJSON;
    }

    private JSONObject getLayoutJSON(Layout layout) {
        JSONObject layoutJSON = new JSONObject();
        layoutJSON.put(LAYOUT_NAME, layout.getName());
        layoutJSON.put(LAYOUT_SEAT_MATRIX, getSeatMatrixJSON(layout.seats));
        return layoutJSON;
    }

    private JSONArray getSeatMatrixJSON(Seat[][] seats) {
        JSONArray seatMatrixJSON = new JSONArray();
        for (Seat[] iSeats : seats) {
            seatMatrixJSON.put(getSeatArrayJSON(iSeats));
        }
        return seatMatrixJSON;
    }

    private JSONArray getSeatArrayJSON(Seat[] seats) {
        JSONArray seatsJOSN = new JSONArray();
        for (Seat seat : seats) {
            seatsJOSN.put(getSeatJSON(seat));
        }
        return seatsJOSN;
    }

    private JSONObject getSeatJSON(Seat seat) {
        JSONObject seatJSON = new JSONObject();
        seatJSON.put(SEAT_TYPE, seat.getType());
        return seatJSON;

    }
}