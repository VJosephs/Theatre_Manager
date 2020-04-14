import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ShowTest {

    @Test
    void testShow() {
    	String name = "frozen";
    	String description = "show";
    	String genre = "Horror";
    	String ageRating = "R";
    	String location = "123 theatre";
    	double price = 10;
    	Date date = new Date(2000, Calendar.JANUARY, 10);
        Show show = new Show(name, description, genre, ageRating, date, location, price);
        assertEquals(name, show.getName());
        assertEquals(description, show.getDescription());
		assertEquals(genre, show.getGenre());
		assertEquals(ageRating, show.ageRating);
		assertEquals(location, show.getLocation());
		assertEquals(price, show.getPrice());
		assertEquals(date, show.getShowTime());

    }

    @Test
    void testGetName() {
        Show show = new Show("frozen", "show", "horror", "R", new Date(2000, Calendar.JANUARY, 10), "123 theatre", 10);
        assertEquals("frozen", show.getName());
    }

    @Test
    void testGetGenre() {
        Show show = new Show("frozen", "show", "horror", "R", new Date(2000, Calendar.JANUARY, 10), "123 theatre", 10);
        assertEquals("horror", show.getGenre());
    }

    @Test
    void testGetDescription() {
        Show show = new Show("frozen", "show", "horror", "R", new Date(2000, Calendar.JANUARY, 10), "123 theatre", 10);
        assertEquals("show", show.getDescription());
    }

    @Test
    void testGetShowRating() {
        Show show = new Show("frozen", "show", "horror", "R", new Date(2000, Calendar.JANUARY, 10), "123 theatre", 10);
        assertEquals("R", show.getShowRating());
    }

    @Test
    void testGetShowTime() {
        Show show = new Show("frozen", "show", "horror", "R", new Date(2000, Calendar.JANUARY, 10), "123 theatre", 10);
        assertEquals(new Date(2000, Calendar.JANUARY, 10), show.getShowTime());
    }

    @Test
    void testGetPrice() {
        Show show = new Show("frozen", "show", "horror", "R", new Date(2000, Calendar.JANUARY, 10), "123 theatre", 10);
        assertEquals(10, show.getPrice());
    }

    @Test
    void testGetAvgRating() {
        Show show = new Show("frozen", "show", "horror", "R", new Date(2000, Calendar.JANUARY, 10), "123 theatre", 10);
        show.receiveRating(new Rating(3.5, "Jsmith", "comment"));
        assertEquals(3.5, show.getAvgRating());
    }

    @Test
    void testGetLocation() {
        Show show = new Show("frozen", "show", "horror", "R", new Date(2000, Calendar.JANUARY, 10), "123 theatre", 10);
        assertEquals("123 theatre", show.getLocation());
    }

    @Test
    void testGetRatings() {
        Show show = new Show("frozen", "show", "horror", "R", new Date(2000, Calendar.JANUARY, 10), "123 theatre", 10);
        show.receiveRating(new Rating(3.5, "Jsmith", "comment"));
        ArrayList<Rating> tester = new ArrayList<Rating>();
        tester.add(new Rating(3.5, "Jsmith", "comment"));
        assertEquals(tester, show.getRatings());
    }

    @Test
    void testCompareTo() {
		String name = "frozen";
		String description = "show";
		String genre = "Horror";
		String ageRating = "R";
		String location = "123 theatre";
		double price = 10;
		Date date = new Date(2000, Calendar.JANUARY, 10);
		Show show1 = new Show(name, description, genre, ageRating, date, location, price);
		Show show2 = new Show(name, description, genre, ageRating, date, location, price);

        assertEquals(0, show1.compareTo(show2));
    }

    @Test
    void testRecieveRating() {
        Show show = new Show("frozen", "show", "horror", "R", new Date(2000, Calendar.JANUARY, 10), "123 theatre", 10);
        show.receiveRating(new Rating(3.5, "Jsmith", "comment"));
        assertEquals(3.5, show.getAvgRating());
    }

}
