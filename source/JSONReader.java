import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.FileReader;
import java.util.ArrayList;
import java.io.IOException;
import java.util.Date;


public class JSONReader extends JSONConstants {


    public ArrayList<Theatre> getTheatres() {
        return getTheatresList(fileToString(CONFIG_THEATRES));
    }

    public ArrayList<User> getUsers() {
        return getUsersList(fileToString(CONFIG_USERS));
    }

    private static ArrayList<User> getUsersList(String s) {
        JSONArray ja = new JSONArray(new JSONTokener(s));
        ArrayList<User> users = new ArrayList<>();
        for (int i = 0; i < ja.length(); ++i) {
            users.add(getUser(ja.getJSONObject(i)));
        }
        return users;
    }

    private static User getUser(JSONObject jo) {
        Date birthday = getDate(jo.getJSONObject(USER_BIRTHDAY));
        String firstName = jo.getString(USER_FIRST_NAME);
        String lastName = jo.getString(USER_LAST_NAME);
        String username = jo.getString(USER_USERNAME);
        String password = jo.getString(USER_PASSWORD);
        int rewardsPoints = jo.getInt(USER_REWARDS_POINTS);
        ArrayList<Ticket> pastTransactions = getTicketArray(jo.getJSONArray(USER_PAST_TRANSACTIONS));
        ArrayList<Ticket> currentTransactions = getTicketArray(jo.getJSONArray(USER_CURRENT_TRANSACTIONS));
        ArrayList<Ticket> shoppingCart = getTicketArray(jo.getJSONArray(USER_SHOPPING_CART));
        User user = new User(firstName, lastName, username, birthday, password);
        user.addRewardPoints(rewardsPoints);
        //TODO add methods to set ticket arrays
        return user;
    }

    private static ArrayList<Ticket> getTicketArray(JSONArray ja) {
        ArrayList<Ticket> tickets = new ArrayList<>();
        for(int i = 0; i < ja.length(); ++i) {
            tickets.add(getTicket(ja.getJSONObject(i)));
        }
        return tickets;
    }

    private static Ticket getTicket(JSONObject jo) {
        return new Ticket(jo.getString(TICKET_SHOW), jo.getString(TICKET_LOCATION), jo.getDouble(TICKET_PRICE));
    }

    private ArrayList<Theatre> getTheatresList(String s) {
        JSONArray ja = new JSONArray(new JSONTokener(s));
        ArrayList<Theatre> theatres = new ArrayList<>();
        for (int i = 0; i < ja.length(); ++i) {
            theatres.add(getTheatre(ja.getJSONObject(i)));
        }
        return theatres;
    }
    private static Theatre getTheatre(JSONObject jo) {
        String address = jo.getString(THEATRE_ADDRESS);
        String name = jo.getString(THEATRE_NAME);
        ArrayList<Rating> ratings = getRatingsArray(jo.getJSONArray(THEATRE_RATINGS));
        ArrayList<Show> shows = getShowArray(jo.getJSONArray(THEATRE_SHOWS));
        Layout layout = getLayout(jo.getJSONObject(THEATRE_LAYOUT));

        return new Theatre(name, address, layout, ratings, shows);
    }

    private static ArrayList<Show> getShowArray(JSONArray ja) {
        ArrayList<Show> shows = new ArrayList<>();
        for (int i = 0; i < ja.length(); ++i) {
            shows.add(getShow(ja.getJSONObject(i)));
        }
        return shows;
    }

    private static Show getShow(JSONObject jo) {
        return new Show(jo.getString(SHOW_NAME), jo.getString(SHOW_DESCRIPTION),
                jo.getString(SHOW_GENRE), jo.getString(SHOW_AGE_RATING),
                getDate(jo.getJSONObject(SHOW_SHOW_TIME)), jo.getString(SHOW_LOCATION), jo.getDouble(SHOW_PRICE));
    }

    private static Date getDate(JSONObject jo) {
        String[] s = jo.getString(DATE_STRING).split("-");
        return new Date(Integer.parseInt(s[2]),Integer.parseInt(s[0]),Integer.parseInt(s[1]));
    }

    private static ArrayList<Rating> getRatingsArray(JSONArray ja) {
        ArrayList<Rating> ratings = new ArrayList<>();
        for (int i = 0; i < ja.length(); ++i) {
            ratings.add(getRating(ja.getJSONObject(i)));
        }
        return ratings;
    }

    private static Rating getRating(JSONObject jo) {
        return new Rating(jo.getDouble(RATING_RATING), jo.getString(RATING_USERNAME), jo.getString(RATING_COMMENT));
    }

    private static Layout getLayout(JSONObject jo) {
        Layout l = new Layout(jo.getString(LAYOUT_NAME), getSeatMatrix(jo.getJSONArray(LAYOUT_SEAT_MATRIX)));
        l.setHEIGHT(jo.getInt(LAYOUT_HEIGHT));
        l.setWIDTH(jo.getInt(LAYOUT_WIDTH));

        return l;
    }

    private static String fileToString(String fileName) {
        StringBuilder sb = new StringBuilder();
        int i;
        try {
            FileReader reader = new FileReader(GENERAL_FILE_PATH + fileName);
            while ((i = reader.read()) != -1) {
                sb.append((char) i);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString().trim();
    }

    private static Seat[][] getSeatMatrix(JSONArray ja) {
        Seat[][] seats = new Seat[ja.length()][ja.getJSONArray(0).length()];

        for (int i = 0; i < ja.length(); ++i) {
            Seat[] s = getSeatArray(ja.getJSONArray(i));
            System.arraycopy(s, 0, seats[i], 0, s.length);
        }
        return seats;
    }

    private static Seat[] getSeatArray(JSONArray ja) {
        Seat[] seats = new Seat[ja.length()];
        for (int i = 0; i < ja.length(); ++i) {
            seats[i] = getSeat(ja.getJSONObject(i));
        }
        return seats;
    }

    private static Seat getSeat(JSONObject jo) {
        return new Seat(jo.getString(SEAT_TYPE));
    }

}
