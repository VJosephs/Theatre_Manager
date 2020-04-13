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
		assertEquals(testList , testCart.getCart());
	}

	@Test
	void testAddTicket() {
		ArrayList<Ticket> testList = new ArrayList<Ticket>();
		ShoppingCart testCart = new ShoppingCart(testList);
		Show show = new Show("Show", "String description", "String genre", "String ageRating", new Date(10,Calendar.JANUARY, 1), "String location",1);
		Ticket ticket = new Ticket("Show", show.getLocation(), show.getPrice());
		testCart.addTicket(ticket);
		boolean test = testCart.getCart().contains(ticket);
		assertEquals(true, test);
	}

	@Test
	void testRemoveTicket() {
		ArrayList<Ticket> testList = new ArrayList<Ticket>();
		ShoppingCart testCart = new ShoppingCart(testList);
		Show show = new Show("Show", "String description", "String genre", "String ageRating", new Date(10,Calendar.JANUARY, 1), "String location",1);
		Ticket ticket = new Ticket("Show", show.getLocation(), show.getPrice());
		testCart.addTicket(ticket);
		testCart.removeTicket(ticket);
		boolean test = testCart.getCart().contains(ticket);
		assertSame(false, test);
	}

	@Test
	void testVerifyAge() {
		ArrayList<Ticket> testList = new ArrayList<Ticket>();
		ShoppingCart testCart = new ShoppingCart(testList);
		assertEquals(testCart.verifyAge(), true);
	}

	@Test
	void testGetCart() {
		ArrayList<Ticket> testList = new ArrayList<Ticket>();
		ShoppingCart testCart = new ShoppingCart(testList);
		assertEquals(testCart.getCart(), testList);
	}

}
