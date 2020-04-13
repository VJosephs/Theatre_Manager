import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Date;

import org.junit.jupiter.api.Test;

class TheatreTest {

	@Test
	void testTheatreStringStringLayoutArrayListOfRatingArrayListOfShow() {
		Theatre theatre = new Theatre("name", "123",new Layout("layout", new Seat[5][5]), new ArrayList<Rating>(),
               new ArrayList<Show>());
		assertEquals( new Theatre("name", "123",new Layout("layout", new Seat[5][5]), new ArrayList<Rating>(),
               new ArrayList<Show>()), theatre);
	}

	@Test
	void testTheatreStringStringLayout() {
		Theatre theatre = new Theatre("name", "123", new Layout("layout", new Seat[5][5]));
		assertEquals( new Theatre("name", "123", new Layout("layout", new Seat[5][5])), theatre);
	}

	@Test
	void testToString() {
		Theatre theatre = new Theatre("name", "123",new Layout("layout", new Seat[5][5]), new ArrayList<Rating>(),
	               new ArrayList<Show>());
		assertEquals("Theatre [name=" + "name" + ", address=" + "123" + "  " + null + "/5]", theatre.toString());
	}

	@Test
	void testAddShow() {
		Theatre theatre = new Theatre("name", "123",new Layout("layout", new Seat[5][5]), new ArrayList<Rating>(),
	               new ArrayList<Show>());
		Show show = new Show("frozen", "show", "horror", "R", new Date(10,10,2000), "123 theatre", 10);
		theatre.addShow(show);
		assertEquals(1, theatre.getShows().size());
	}

	@Test
	void testRemoveShow() {
		Theatre theatre = new Theatre("name", "123",new Layout("layout", new Seat[5][5]), new ArrayList<Rating>(),
	               new ArrayList<Show>());
		Show show = new Show("frozen", "show", "horror", "R", new Date(10,10,2000), "123 theatre", 10);
		theatre.addShow(show);
		theatre.removeShow(show);
		assertEquals(0, theatre.getShows().size());
	}

	@Test
	void testAddRating() {
		Theatre theatre = new Theatre("name", "123",new Layout("layout", new Seat[5][5]), new ArrayList<Rating>(),
	               new ArrayList<Show>());
		Rating rating = new Rating(3.5, "Jsmith", "comment");
		theatre.addRating(rating);
		assertEquals(theatre.getRatings().size(), 1);
	}

	@Test
	void testRemoveRating() {
		Theatre theatre = new Theatre("name", "123",new Layout("layout", new Seat[5][5]), new ArrayList<Rating>(),
	               new ArrayList<Show>());
		Rating rating = new Rating(3.5, "Jsmith", "comment");
		theatre.addRating(rating);
		theatre.removeRating(rating);
		assertEquals(theatre.getRatings().size(), 0);
	}

	@Test
	void testGetName() {
		Theatre theatre = new Theatre("name", "123",new Layout("layout", new Seat[5][5]), new ArrayList<Rating>(),
	               new ArrayList<Show>());
		assertEquals("name", theatre.getName());
	}

	@Test
	void testSetName() {
		Theatre theatre = new Theatre("name", "123",new Layout("layout", new Seat[5][5]), new ArrayList<Rating>(),
	               new ArrayList<Show>());
		theatre.setName("newName");
		assertEquals("newName", theatre.getName());
	}

	@Test
	void testGetAddress() {
		Theatre theatre = new Theatre("name", "123",new Layout("layout", new Seat[5][5]), new ArrayList<Rating>(),
	               new ArrayList<Show>());
		assertEquals("123", theatre.getAddress());
	}

	@Test
	void testSetAddress() {
		Theatre theatre = new Theatre("name", "123",new Layout("layout", new Seat[5][5]), new ArrayList<Rating>(),
	               new ArrayList<Show>());
		theatre.setAddress("address");
		assertEquals("address", theatre.getAddress());
	}

	@Test
	void testGetLayout() {
		Theatre theatre = new Theatre("name", "123",new Layout("layout", new Seat[5][5]), new ArrayList<Rating>(),
	               new ArrayList<Show>());
		assertEquals(new Layout("layout", new Seat[5][5]), theatre.getLayout());
	}

	@Test
	void testGetRatings() {
		Theatre theatre = new Theatre("name", "123",new Layout("layout", new Seat[5][5]), new ArrayList<Rating>(),
	               new ArrayList<Show>());
		theatre.addRating(new Rating(3.5, "Jsmith", "comment"));
		ArrayList<Rating> test = new ArrayList<Rating>();
		test.add(new Rating(3.5, "Jsmith", "comment"));
	}

	@Test
	void testGetShows() {
		Theatre theatre = new Theatre("name", "123",new Layout("layout", new Seat[5][5]), new ArrayList<Rating>(),
	               new ArrayList<Show>());
		Show show = new Show("frozen", "show", "horror", "R", new Date(10,10,2000), "123 theatre", 10);
		theatre.addShow(show);
		ArrayList<Show> test = new ArrayList<Show>();
		test.add(show);
		assertEquals(test, theatre.getShows());
	}

	@Test
	void testSetLayout() {
		Theatre theatre = new Theatre("name", "123",new Layout("layout", new Seat[5][5]), new ArrayList<Rating>(),
	               new ArrayList<Show>());
		theatre.setLayout(new Layout("test", new Seat[2][2]));
		assertEquals(new Layout("test", new Seat[2][2]),theatre.getLayout());
	}

	@Test
	void testGetAvgRating() {
		Theatre theatre = new Theatre("name", "123",new Layout("layout", new Seat[5][5]), new ArrayList<Rating>(),
	               new ArrayList<Show>());
		theatre.addRating(new Rating(3.5, "Jsmith", "comment"));
		assertEquals(3.5, theatre.getAvgRating());
	}

	@Test
	void testSetRatings() {
		Theatre theatre = new Theatre("name", "123",new Layout("layout", new Seat[5][5]), new ArrayList<Rating>(),
	               new ArrayList<Show>());
		ArrayList<Rating> ratings = new ArrayList<Rating>();
		ratings.add(new Rating(3.5, "Jsmith", "comment"));
		theatre.setRatings(ratings);
		assertEquals(ratings, theatre.getRatings());
	}

	@Test
	void testSetShows() {
		Theatre theatre = new Theatre("name", "123",new Layout("layout", new Seat[5][5]), new ArrayList<Rating>(),
	               new ArrayList<Show>());
		Show show = new Show("frozen", "show", "horror", "R", new Date(10,10,2000), "123 theatre", 10);
		ArrayList<Show> test = new ArrayList<Show>();
		test.add(show);
		theatre.setShows(test);
		assertEquals(test, theatre.getShows());
	}

	@Test
	void testCompareTo() {
		Theatre theatre = new Theatre("name", "123",new Layout("layout", new Seat[5][5]), new ArrayList<Rating>(),
	               new ArrayList<Show>());
		Theatre test = new Theatre("name", "123",new Layout("layout", new Seat[5][5]), new ArrayList<Rating>(),
	               new ArrayList<Show>());
		Rating rating = new Rating(3.5, "Jsmith", "comment");
		theatre.addRating(rating);
		test.addRating(rating);
		assertEquals(true, theatre.compareTo(test));
		Rating ratings = new Rating(5, "Jsmith", "comment");
		test.addRating(ratings);
		assertNotEquals(true, theatre.compareTo(test));
	}

	@Test
	void testRemoveTheatreRating() {
		Theatre theatre = new Theatre("name", "123",new Layout("layout", new Seat[5][5]), new ArrayList<Rating>(),
	               new ArrayList<Show>());
		Rating rating = new Rating(3.5, "Jsmith", "comment");
		theatre.addRating(rating);
		theatre.removeRating(rating);
		assertEquals(theatre.getRatings().size(), 0);
	}

	@Test
	void testGetTicketSales() {
		Theatre theatre = new Theatre("name", "123",new Layout("layout", new Seat[5][5]), new ArrayList<Rating>(),
	               new ArrayList<Show>());
		Show show = new Show("frozen", "show", "horror", "R", new Date(10,10,2000), "123 theatre", 10);
		Ticket ticket1 = new Ticket("frozen", "123", 10);
		Ticket ticket2 = new Ticket("frozen", "123", 10);
		show.addTicket(ticket1);
		show.addTicket(ticket2);
		theatre.addShow(show);
		assertEquals(20, theatre.getTicketSales());
	}

}
