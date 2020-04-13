import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SeatTest {

	@Test
	void testSeat() {
		Seat seat = new Seat("taken");
		assertEquals(new Seat("taken"), seat);
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
		Seat seat = new Seat("taken");
		assertEquals(true, seat.isValid());
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
		assertEquals(false, seat.isValid());
	}

}
