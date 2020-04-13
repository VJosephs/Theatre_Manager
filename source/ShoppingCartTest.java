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
		ArrayList<Ticket> testList2 = new ArrayList<Ticket>();
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
		assertSame(testCart, new ShoppingCart(testList));
	}

	@Test
	void testPrintTickets() {
		/*
		ArrayList<Ticket> testList = new ArrayList<Ticket>();
		ShoppingCart testCart = new ShoppingCart(testList);
		Show show = new Show("Show", "String description", "String genre", "String ageRating", new Date(10,Calendar.JANUARY, 1), "String location",1);
		Ticket ticket = new Ticket("Show", show.getLocation(), show.getPrice());
		testCart.addTicket(ticket);
		assertEquals(testCart.printTickets(), " :: Thank you for your purchase to see Show" + ":: \n"
                + ":: The show you have paid to see will be at " + show.getLocation() + ". And finally you paid" + show.getPrice() + "for your ticket! :: \n"
                + " :: Thanks again for purchasing at THE_247_PROJECT. Have a nice day and call (***)-***-**** if you have any issues!")
        */
		fail("Not yet implemented");
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
