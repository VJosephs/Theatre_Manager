import java.util.ArrayList;
import java.util.Objects;

public class Searcher {

    private ArrayList<Theatre> theatres;

    public Searcher(ArrayList<Theatre> theatres) {
        setTheatres(theatres);
    }

    public ArrayList<Show> searchRatings() {
        //TODO add method body
        return null;
    }

    public ArrayList<Show> searchGenre() {
        //TODO add method body
        return null;
    }

    public ArrayList<Show> searchNames() {
        //TODO add method body
        return null;
    }

    public ArrayList<Show> searchCast() {
        //TODO add method body
        return null;
    }


    public void setTheatres(ArrayList<Theatre> theatres) {
        this.theatres = Objects.requireNonNullElseGet(theatres, ArrayList::new);
    }
}