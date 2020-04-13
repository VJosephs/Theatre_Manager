import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SeniorTicketTest {

	@Test
	void testSeniorTicket() {
		SeniorTicket ticket = new SeniorTicket("Frozen", "123 theatre", 10.5);
		assertEquals("Frozen", ticket.getShow());
		assertEquals("123 theatre", ticket.getLocation());
		assertEquals(10.5, ticket.getPrice());
	}

}
