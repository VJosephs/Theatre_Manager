import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Date;

import org.junit.jupiter.api.Test;

class ShowTest {

	@Test
	void testShow() {
		Show show = new Show("frozen", "show", "horror", "R", new Date(10,10,2000), "123 theatre", 10);
		assertEquals(new Show("frozen", "show", "horror", "R", new Date(10,10,2000), "123 theatre", 10), show);
	}

	@Test
	void testGetName() {
		Show show = new Show("frozen", "show", "horror", "R", new Date(10,10,2000), "123 theatre", 10);
		assertEquals("frozen", show.getName());
	}

	@Test
	void testGetGenre() {
		Show show = new Show("frozen", "show", "horror", "R", new Date(10,10,2000), "123 theatre", 10);
		assertEquals("horror", show.getGenre());
	}

	@Test
	void testGetDescription() {
		Show show = new Show("frozen", "show", "horror", "R", new Date(10,10,2000), "123 theatre", 10);
		assertEquals("show", show.getDescription());
	}

	@Test
	void testGetShowRating() {
		Show show = new Show("frozen", "show", "horror", "R", new Date(10,10,2000), "123 theatre", 10);
		assertEquals("R", show.getShowRating());
	}

	@Test
	void testGetShowTime() {
		Show show = new Show("frozen", "show", "horror", "R", new Date(10,10,2000), "123 theatre", 10);
		assertEquals( new Date(10,10,2000), show.getShowTime());
	}

	@Test
	void testGetPrice() {
		Show show = new Show("frozen", "show", "horror", "R", new Date(10,10,2000), "123 theatre", 10);
		assertEquals(10, show.getPrice());
	}

	@Test
	void testGetAvgRating() {
		Show show = new Show("frozen", "show", "horror", "R", new Date(10,10,2000), "123 theatre", 10);
		show.recieveRating(new Rating(3.5, "Jsmith", "comment"));
		assertEquals(3.5, show.getAvgRating());
	}

	@Test
	void testGetLocation() {
		Show show = new Show("frozen", "show", "horror", "R", new Date(10,10,2000), "123 theatre", 10);
		assertEquals("123 theatre", show.getLocation());
	}

	@Test
	void testGetRatings() {
		Show show = new Show("frozen", "show", "horror", "R", new Date(10,10,2000), "123 theatre", 10);
		show.recieveRating(new Rating(3.5, "Jsmith", "comment"));
		ArrayList<Rating> tester = new ArrayList<Rating>();
		tester.add(new Rating(3.5, "Jsmith", "comment"));
		assertEquals(tester, show.getRatings());
	}

	@Test
	void testGetPurchasedTickets() {
		fail("Not yet implemented");
	}

	@Test
	void testCompareTo() {
		Show show = new Show("frozen", "show", "horror", "R", new Date(10,10,2000), "123 theatre", 10);
		Show copy = new Show("frozen", "show", "horror", "R", new Date(10,10,2000), "123 theatre", 10);
		assertEquals(copy, show);
	}

	@Test
	void testRemoveShowRating() {
		fail("Not yet implemented");
	}

	@Test
	void testGetTicketSale() {
		fail("Not yet implemented");
	}

	@Test
	void testRecieveRating() {
		Show show = new Show("frozen", "show", "horror", "R", new Date(10,10,2000), "123 theatre", 10);
		show.recieveRating(new Rating(3.5, "Jsmith", "comment"));
		assertEquals(3.5, show.getAvgRating());
	}

}
