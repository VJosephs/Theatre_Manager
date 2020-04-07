import java.util.ArrayList;
import java.io.IOException;
import java.io.FileWriter;
import java.util.Date;

import org.json.JSONArray;
import org.json.JSONObject;

public class JSONWriter extends JSONConstants {
    private ArrayList<User> users;
    private ArrayList<Theatre> theatres;

    JSONWriter(ArrayList<User> users, ArrayList<Theatre> theatres) {
        this.users = users;
        this.theatres = theatres;
    }

    public void writeToFile() {
        writeJSON();
    }

    private void writeJSON() {
        JSONArray jsonTheatres = new JSONArray();
        JSONArray jsonUsers = new JSONArray();
        for (Theatre theatre : theatres) {
            jsonTheatres.put(getTheatreJSON(theatre));
        }
        for (User user : users) {
            jsonUsers.put(getUserJSON(user));
        }
        writeFile(jsonTheatres, CONFIG_THEATRES);
        writeFile(jsonUsers, CONFIG_USERS);
    }

    private JSONObject getUserJSON(User user) {
        JSONObject userJSON = new JSONObject();
        userJSON.put(USER_BIRTHDAY, user.getBirthdayString());
        userJSON.put(USER_FIRST_NAME, user.getFirstName());
        userJSON.put(USER_LAST_NAME, user.getLastName());
        userJSON.put(USER_USERNAME, user.getUsername());
        userJSON.put(USER_PASSWORD, user.getPassword());
        userJSON.put(USER_REWARDS_POINTS, user.getRewardsPoints());
        userJSON.put(USER_CURRENT_TRANSACTIONS, getTicketArray(user.getCurrentTransactions()));
        userJSON.put(USER_PAST_TRANSACTIONS, getTicketArray(user.getPastTransactions()));
        userJSON.put(USER_SHOPPING_CART, getTicketArray(user.getCart().getCart()));
        return userJSON;
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
        showJSON.put(SHOW_SHOW_TIME, getDateJSON(show.getShowTime()));
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
        String dateString = "" + date.getMonth() + "-" + date.getDate() + "-" + date.getYear();
        dateJSON.put(DATE_STRING, dateString);
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
        layoutJSON.put(LAYOUT_HEIGHT, layout.getHEIGHT());
        layoutJSON.put(LAYOUT_WIDTH, layout.getWIDTH());
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

    public static void writeFile(JSONArray fileContentsJSON, String fileName) {
        try (FileWriter file = new FileWriter(GENERAL_FILE_PATH + fileName)) {
            file.write(fileContentsJSON.toString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}