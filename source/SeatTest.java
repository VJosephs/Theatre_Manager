import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SeatTest {

	@Test
	void testSeat() {
		Seat seat = new Seat("taken");
		assertEquals('X', seat.getSeatChar());
		assertEquals("taken", seat.getType());
		assertFalse(seat.isValid());
	}
	
	@Test
	void testGetType() {
		Seat seat = new Seat("taken");
		assertEquals("taken", seat.getType());
	}
	
	@Test
	void testGetSeatChar() {
		Seat seat = new Seat("taken");
		assertEquals('X', seat.getSeatChar());
	}
	
	@Test
	void testIsValid() {
		Seat seat = new Seat("available");
		assertTrue(seat.isValid());
	}
	
	@Test
	void testSetType(){
		Seat seat = new Seat("taken");
		seat.setType("available");
		assertEquals('O', seat.getSeatChar());
	}
	
	@Test
	void testSetInvalid() {
		Seat seat = new Seat("taken");
		seat.setInValid();
		assertFalse(seat.isValid());
	}

}
