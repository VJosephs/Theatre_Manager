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
	
	@Test
	void testGetAgeRating16() {
		Date date = new Date(10,10,2000);
		Play p =new Play("name", "desc", "genre", "16+", date, "location", 10);
		assertEquals(16, p.getAgeRating());
	}
	
	@Test
	void testGetAgeRating13() {
		Date date = new Date(10,10,2000);
		Play p =new Play("name", "desc", "genre", "13+", date, "location", 10);
		assertEquals(13, p.getAgeRating());
	}
	
	@Test
	void testGetAgeRating10() {
		Date date = new Date(10,10,2000);
		Play p =new Play("name", "desc", "genre", "10+", date, "location", 10);
		assertEquals(10, p.getAgeRating());
	}
	
	@Test
	void testGetAgeRating0() {
		Date date = new Date(10,10,2000);
		Play p =new Play("name", "desc", "genre", "0", date, "location", 10);
		assertEquals(0, p.getAgeRating());
	}

}
