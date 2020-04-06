import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

public class Searcher {

    private ArrayList<Theatre> theatres;
    private ArrayList<Show> shows;

    public Searcher(ArrayList<Theatre> theatres, ArrayList<Show> shows) {
        setTheatres(theatres);
        setShows(shows);
    }

    public ArrayList<Show> searchShowRatings() {
        shows.sort(Show::compareTo);
        return shows;
    }

    public ArrayList<Theatre> searchTheatreRatings() {
        theatres.sort(Theatre::compareTo);
        return theatres;
    }

    public ArrayList<Show> searchGenre(String genre) {
        ArrayList<Show> retShows = new ArrayList<>();
        for (Show show : shows) {
            if (show.getGenre().contains(genre))
                retShows.add(show);
        }
        return retShows;
    }

    public ArrayList<Show> searchShowNames(String name) {
        ArrayList<Show> retShows = new ArrayList<>();
        for (Show show : shows) {
            if (show.getName().contains(name))
                retShows.add(show);
        }
        return retShows;
    }

    public ArrayList<Theatre> searchTheatreNames(String name) {
        ArrayList<Theatre> retTheatres = new ArrayList<>();
        for (Theatre theatre : theatres) {
            if (theatre.getName().contains(name))
                retTheatres.add(theatre);
        }
        return retTheatres;
    }

    public ArrayList<Show> searchCast(String castMember) {
        ArrayList<Show> retShows = new ArrayList<>();
        for (Show show : shows) {
            if (show.getCast().contains(castMember)) {
                retShows.add(show);
            }
        }
        return retShows;
    }

    // TODO probably fix this
    public ArrayList<Show> searchType(String type) {
        ArrayList<Show> retShows = new ArrayList<>();
        for (Show show : shows) {
            if (type.equalsIgnoreCase("Movie")) {
                if (show.getClass() == Movie.class)
                    retShows.add(show);
            }
            else if (type.equalsIgnoreCase("Play")) {
                if(show.getClass() == Play.class)
                    retShows.add(show);
            }
            else if (type.equalsIgnoreCase("Concert")) {
                if (show.getClass() == Concert.class)
                    retShows.add(show);
            }
            else {
                return retShows;
            }
        }
        return retShows;
    }

    public void reverseList(ArrayList<Object> list) {
        Collections.reverse(list);
    }

    public void printList(ArrayList<Object> list) {
        for (Object o : list) {
            System.out.println(o.toString());
        }
    }

    public void setTheatres(ArrayList<Theatre> theatres) {
        this.theatres = Objects.requireNonNullElseGet(theatres, ArrayList::new);
    }

    public void setShows(ArrayList<Show> shows) {
        this.shows = Objects.requireNonNullElseGet(shows, ArrayList::new);
    }
}