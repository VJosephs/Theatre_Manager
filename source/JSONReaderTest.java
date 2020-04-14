import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class JSONReaderTest {

	@Test
	void testGetTheatres() {
		JSONReader jsonReader = new JSONReader();
		ArrayList<Theatre> theatres = jsonReader.getTheatres();

		assertEquals("PlaysRUs", theatres.get(0).getName());
		assertEquals("Jungle Palace", theatres.get(1).getName());
	}

	@Test
	void testGetUsers() {
		JSONReader jsonReader = new JSONReader();
		ArrayList<User> users = jsonReader.getUsers();

		assertEquals("a", users.get(0).getUsername());
		assertEquals("f", users.get(1).getUsername());

	}

}
