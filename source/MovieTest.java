import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MovieTest {

	@Test
	void testMovie() {
		Date date = new Date(10,Calendar.JANUARY,2000);
		Movie m =new Movie("name", "desc", "genre", "R", date, "location", 10);
		assertEquals("name", m.getName());
		assertEquals("desc",m.getDescription());
		assertEquals("genre", m.getGenre());
		assertEquals(17, m.getAgeRating());
		assertEquals(date, m.getShowTime());
		assertEquals("location", m.getLocation());
		assertEquals(10, m.getPrice());
	}

	@Test
	void testGetAgeRating() {
		Date date = new Date(10, Calendar.JANUARY,2000);
		Movie m =new Movie("name", "desc", "genre", "R", date, "location", 10);
		assertEquals(17, m.getAgeRating());
	}

	@Test
	void testGetAgeRatingNC() {
		Date date = new Date(10,Calendar.JANUARY,2000);
		Movie m =new Movie("name", "desc", "genre", "NC-17", date, "location", 10);
		assertEquals(18, m.getAgeRating());
	}

	@Test
	void testGetAvgRatingPG13() {
		Date date = new Date(10,Calendar.JANUARY,2000);
		Movie m =new Movie("name", "desc", "genre", "PG-13", date, "location", 10);
		assertEquals(13, m.getAgeRating());
	}

	@Test
	void testGetAvgRatingPG() {
		Date date = new Date(10,Calendar.JANUARY,2000);
		Movie m =new Movie("name", "desc", "genre", "PG", date, "location", 10);
		assertEquals(0, m.getAgeRating());
	}

}
