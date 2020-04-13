import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class SearcherTest {
	private ArrayList<Theatre> theatres;
	private ArrayList<Show> shows;
	private Searcher searcher;

	@BeforeEach
	void OneTimeSetup() {
		Show show1 = new Show("frozen", "show", "horror", "R", new Date(2000, Calendar.JANUARY, 10), "123 theatre", 10);
		Show show2 = new Show("X men", "show", "Action", "PG", new Date(2000, Calendar.JANUARY, 10), "123 theatre", 15);
		String name = "name";
		String address = "address";
		Layout layout = new Layout("layout", new Seat[5][5]);
		ArrayList<Rating> ratings = new ArrayList<>();
		shows = new ArrayList<>();
		shows.add(show1);
		shows.add(show2);
		Theatre t = new Theatre(name, address, layout, ratings, shows);
		Theatre t2 = new Theatre(name+"2",address+"2",layout,ratings,shows);
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
		fail("Not yet implemented");
	}

	@Test
	void testSearchTheatreRatings() {
		fail("Not yet implemented");
	}

	@Test
	void testSearchGenre() {
		fail("Not yet implemented");
	}

	@Test
	void testSearchShowNames() {
		fail("Not yet implemented");
	}

	@Test
	void testSearchTheatreNames() {
		fail("Not yet implemented");
	}

	@Test
	void testSearchCast() {
		fail("Not yet implemented");
	}

	@Test
	void testSearchType() {
		fail("Not yet implemented");
	}

	@Test
	void testReverseList() {
		fail("Not yet implemented");
	}

	@Test
	void testPrintList() {
		fail("Not yet implemented");
	}

	@Test
	void testSetTheatres() {
		fail("Not yet implemented");
	}

	@Test
	void testSetShows() {
		fail("Not yet implemented");
	}

}
