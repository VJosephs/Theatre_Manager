import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.Test;

class PlayTest {

	@Test
	void testPlay() {
		Date date = new Date(10,10,2000);
		Play p =new Play("name", "desc", "genre", "18+", date, "location", 10);
		assertEquals("name", p.getName());
		assertEquals("desc", p.getDescription());
		assertEquals("genre", p.getGenre());
		assertEquals(18, p.getAgeRating());
		assertEquals(date, p.getShowTime());
		assertEquals("location", p.getLocation());
		assertEquals(10, p.getPrice());
	}

	@Test
	void testGetAgeRating() {
		Date date = new Date(10,10,2000);
		Play p =new Play("name", "desc", "genre", "18+", date, "location", 10);
		assertEquals(18, p.getAgeRating());
	}

}
