import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class LayoutTest {

    @BeforeEach
    void oneTimeSetup() {

    }

    @Test
    void testLayoutStringSeatArrayArray() {
        Seat[][] seats = {{new Seat("handicap")}, {new Seat("available")}};
        Layout layout = new Layout("name", seats);
        assertEquals(seats, layout.seats);
    }

    @Test
    void testLayoutString() {
        Seat[][] seats = {{new Seat("handicap")}, {new Seat("available")}};
        Layout layout = new Layout("name", seats);
        assertEquals("name", layout.name);
    }

    @Test
    void testPrintLayout() {
        Seat[][] seats = {{new Seat("available")}, {new Seat("available")}};
        Layout layout = new Layout("name", seats);
        layout.printLayout();
        assertFalse(System.out.checkError());
    }

    @Test
    void testGetSeats() {
        Seat[][] seats = {{new Seat("available")}, {new Seat("available")}};
        Layout layout = new Layout("name", seats);

        assertEquals(seats, layout.getSeats());
    }

    @Test
    void testSetSeats() {
        Seat[][] seats = {{new Seat("available")}, {new Seat("available")}};
        Layout layout = new Layout("name");

        layout.setSeats(seats);
        assertEquals(seats, layout.getSeats());
    }

    @Test
    void testGetCurrentSeatType() {
        String seats = "handicap";
		Layout layout = new Layout("name");

		layout.setCurrentSeatType(seats);

		assertEquals(seats, layout.getCurrentSeatType());
    }

    @Test
    void testSetCurrentSeatType() {
		String seats = "handicap";
		Layout layout = new Layout("name");

		layout.setCurrentSeatType(seats);

		assertEquals(seats, layout.getCurrentSeatType());
    }

    @Test
    void testGetHEIGHT() {
		Layout layout = new Layout("name");
		layout.setHEIGHT(10);

		assertEquals(10, layout.getHEIGHT());
    }

    @Test
    void testSetHEIGHT() {
		Layout layout = new Layout("name");
		layout.setHEIGHT(10);

		assertEquals(10, layout.getHEIGHT());
    }

    @Test
    void testGetWIDTH() {
		Layout layout = new Layout("name");
		layout.setWIDTH(10);

		assertEquals(10, layout.getWIDTH());
    }

    @Test
    void testSetWIDTH() {
		Layout layout = new Layout("name");
		layout.setWIDTH(10);

		assertEquals(10, layout.getWIDTH());
    }

    @Test
    void testGetName() {
		Layout layout = new Layout("name");

		assertEquals("name", layout.getName());
	}

    @Test
    void testSetName() {
		Layout layout = new Layout("name");

		layout.setName("notName");
		assertEquals("notName", layout.name);
	}
}
