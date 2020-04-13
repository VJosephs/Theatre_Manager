import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.Test;

class MovieTest {

	@Test
	void testMovie() {
		Date date = new Date(10,10,2000);
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
		Date date = new Date(10,10,2000);
		Movie m =new Movie("name", "desc", "genre", "R", date, "location", 10);
		assertEquals(17, m.getAgeRating());
	}

}
