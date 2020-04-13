import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

class ShoppingCartTest {

	public static void setup() {
		ArrayList<Ticket> testList = new ArrayList<Ticket>();
		ShoppingCart testCart = new ShoppingCart(testList);
	}
	
	@Test
	void testShoppingCart() {
		ArrayList<Ticket> testList = new ArrayList<Ticket>();
		ShoppingCart testCart = new ShoppingCart(testList);
		assertEquals(new ShoppingCart(testList), testList);
	}

	@Test
	void testAddTicket() {
		ArrayList<Ticket> testList = new ArrayList<Ticket>();
		ShoppingCart testCart = new ShoppingCart(testList);
		Show show = new Show("Show", "String description", "String genre", "String ageRating", new Date(10,Calendar.JANUARY, 1), "String location",1);
		Ticket ticket = new Ticket("Show", show.getLocation(), show.getPrice());
		testCart.addTicket(ticket);
		ArrayList<Ticket> testList2 = new ArrayList<Ticket>();
		testList2.add(ticket);
		ShoppingCart testCart2 = new ShoppingCart(testList2);
		assertEquals(testCart, testCart2);
	}

	@Test
	void testRemoveTicket() {
		ArrayList<Ticket> testList = new ArrayList<Ticket>();
		ShoppingCart testCart = new ShoppingCart(testList);
		Show show = new Show("Show", "String description", "String genre", "String ageRating", new Date(10,Calendar.JANUARY, 1), "String location",1);
		Ticket ticket = new Ticket("Show", show.getLocation(), show.getPrice());
		testCart.addTicket(ticket);
		testCart.removeTicket(ticket);
		assertEquals(testCart, new ShoppingCart(testList));
	}

	@Test
	void testPrintTickets() {
		fail("Not yet implemented");
	}

	@Test
	void testVerifyAge() {
		fail("Not yet implemented");
	}

	@Test
	void testGetCart() {
		fail("Not yet implemented");
	}

}
