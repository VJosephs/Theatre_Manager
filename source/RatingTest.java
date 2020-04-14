import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RatingTest {


	@Test
	void testRating() {
		Rating rating = new Rating(3.5, "John", "test");
		assertEquals(new Rating(3.5, "John", "test"), rating);
	}

	@Test
	void testSetComment() {
		Rating rating = new Rating(3.5, "John", "test");
		rating.setComment("pass");
		assertEquals("pass", rating.getComment());
	}

	@Test
	void testEqualsObject() {
		Rating rating = new Rating(3.5, "John", "test");
		assertEquals(true, rating.equals(new Rating(3.5, "John", "test")));
	}

	@Test
	void testGetUserName() {
		Rating rating = new Rating(3.5, "John", "test");
		assertEquals("John", rating.getUserName());
	}

	@Test
	void testGetComment() {
		Rating rating = new Rating(3.5, "John", "test");
		assertEquals("test", rating.getComment());
	}

	@Test
	void testGetRating() {
		Rating rating = new Rating(3.5, "John", "test");
		assertEquals(3.5, rating.getRating());
	}

	@Test
	void testToString() {
		String string = "John" + "gave this show a rating of:" + 3.5 + " and said, " + "test";
		Rating rating = new Rating(3.5, "John", "test");
		assertEquals(string, rating.toString());
	}
	
	@Test
	void testGetRatinglarger() {
		Rating rating = new Rating(10, "John", "test");
		assertEquals(5, rating.getRating());
	}
	
	@Test
	void testGetRatingSmall() {
		Rating rating = new Rating(-3.5, "John", "test");
		assertEquals(1, rating.getRating());
	}

}
