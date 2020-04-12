import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TicketTest {

	@Test
	void testTicket() {
		Ticket ticket = new Ticket("Frozen", "123 theatre", 10.5);
		assertEquals(new Ticket("Frozen", "123 theatre", 10.5),ticket);
	}

	@Test
	void testGetShow() {
		Ticket ticket = new Ticket("Frozen", "123 theatre", 10.5);
		assertEquals("Frozen", ticket.getShow());
	}

	@Test
	void testGetPrice() {
		Ticket ticket = new Ticket("Frozen", "123 theatre", 10.5);
		assertEquals(10.5, ticket.getPrice());
	}

	@Test
	void testGetLocation() {
		Ticket ticket = new Ticket("Frozen", "123 theatre", 10.5);
		assertEquals("123 theatre", ticket.getLocation());
	}

	@Test
	void testToString() {
	String string =	" :: Thank you for your purchase to see " + "Frozen" + ":: \n"
                + ":: The show you have paid to see will be at " +"123 theatre" + ". And finally you paid" + 10.5 + "for your ticket! :: \n"
                + " :: Thanks again for purchasing at THE_247_PROJECT. Have a nice day and call (***)-***-**** if you have any issues!";
	Ticket ticket = new Ticket("Frozen", "123 theatre", 10.5);
	assertEquals(string, ticket.toString());
	}

	@Test
	void testPrint() {
		fail("Not yet implemented");
	}

}
