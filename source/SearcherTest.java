import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SearcherTest {
    private ArrayList<Theatre> theatres;
    private ArrayList<Show> shows;
    private Searcher searcher;

    @BeforeEach
    void OneTimeSetup() {
        ArrayList<String> cast = new ArrayList<>();
        cast.add("person1");
        cast.add("person2");
        ArrayList<Rating> ratings1 = new ArrayList<>();
        ArrayList<Rating> ratings2 = new ArrayList<>();
        Rating a = new Rating(1, "Asmith", "cool film");
        Rating b = new Rating(4.3, "Bsmith", "bad film");
        Rating c = new Rating(4.9, "ff", "ff");
        ratings1.add(a);
        ratings1.add(b);
        ratings2.add(c);

        Show show1 = new Show("frozen", "show", "horror", "R", new Date(2000, Calendar.JANUARY, 10), "123 theatre", 10);
        show1.setCast(cast);
        show1.setRatings(ratings1);
        Show show2 = new Show("X men", "show", "Action", "PG", new Date(2000, Calendar.JANUARY, 10), "123 theatre", 15);
        show2.setRatings(ratings2);
        Movie show3 = new Movie("Jungle Book", "Movie", "Romance", "PG-13", new Date(2000, Calendar.JANUARY, 10), "123 theatre", 50);
        String name = "name";
        String address = "address";
        Layout layout = new Layout("layout", new Seat[5][5]);
        ArrayList<Rating> ratings = new ArrayList<>();
        shows = new ArrayList<>();
        shows.add(show1);
        shows.add(show2);
        shows.add(show3);
        Theatre t = new Theatre(name, address, layout, ratings, shows);
        t.setRatings(ratings1);
        Theatre t2 = new Theatre(name + "2", address + "2", layout, ratings, shows);
        t2.setRatings(ratings2);
        theatres = new ArrayList<>();
        theatres.add(t);
        theatres.add(t2);


        searcher = new Searcher(theatres, shows);
    }

    @Test
    void testSearcher() {
        searcher = new Searcher(theatres, shows);

        assertEquals(theatres, searcher.getTheatres());
        assertEquals(shows, searcher.getShows());
    }

    @Test
    void testSearchShowRatings() {
        assertEquals(shows.get(1).getAvgRating(), searcher.searchShowRatings().get(1).getAvgRating());
    }

    @Test
    void testSearchTheatreRatings() {
        assertEquals(theatres.get(1).getAvgRating(), searcher.searchTheatreRatings().get(0).getAvgRating());
    }

    @Test
    void testSearchGenre() {
        String searchString = "horror";
        assertEquals(searchString, searcher.searchGenre(searchString).get(0).genre);
    }

    @Test
    void testSearchShowNames() {
        String searchString = "X men";
        assertEquals(searchString, searcher.searchShowNames(searchString).get(0).name);
    }

    @Test
    void testSearchTheatreNames() {
        String searchString = "name2";
        assertEquals(searchString, searcher.searchTheatreNames(searchString).get(0).getName());
    }

    @Test
    void testSearchCast() {
        String castMember = "person2";
        assertEquals(castMember, searcher.searchCast(castMember).get(0).getCast().get(1));
    }

    @Test
    void testSearchType() {
        assertEquals(shows.get(2), searcher.searchType("Movie").get(0));
    }

    @Test
    void testReverseList() {
        ArrayList<Object> nums = new ArrayList<>();
        nums.add(1);
        nums.add(2);
        nums.add(3);
        ArrayList<Object> revNums = new ArrayList<>();
        revNums.add(3);
        revNums.add(2);
        revNums.add(1);

        searcher.reverseList(nums);

        for (int i = 0; i < nums.size(); ++i)
            assertEquals(revNums.get(i), nums.get(i));
    }

    @Test
    void testSetTheatres() {
        assertEquals(theatres, searcher.getTheatres());
    }

    @Test
    void testSetShows() {
        assertEquals(shows, searcher.getShows());
    }

}
