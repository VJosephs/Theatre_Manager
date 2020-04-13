import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.Test;

class UserTest {
	
	public static void setup() {
		User user = new User("John", "Smith", "Jsmith", new Date(10,10,97), "password");
	}

	@Test
	void testHashCode() {
		fail("Not yet implemented");
	}

	@Test
	void testUser() {
		User user = new User("John", "Smith", "Jsmith", new Date(10,10,97), "password");
		assertEquals(new User("John", "Smith", "Jsmith", new Date(10,10,97), "password"), user);
	}


	@Test
	void testPurchaseTicket() {
		fail("Not yet implemented");
	}

	@Test
	void testGetRating() {
		User user = new User("John", "Smith", "Jsmith", new Date(10,10,97), "password");
		
		assertEquals(new Rating(3.5, "Jsmith", "comment"),user.getRating(3.5, "comment"));
	}

	@Test
	void testGetCurrentCart() {
		fail("Not yet implemented");
	}
	/*"User [firstName=" + firstName + ", lastName=" + lastName + ", username=" + username + ", birthday="
    + birthday + ", password=" + password + ", RewardPoints="
    + RewardPoints + ", pastTransactions=" + pastTransactions + "]";
    */
	@Test
	void testToString() {
		String user = new User("John", "Smith", "Jsmith", new Date(10,10,97), "password").toString();
		assertEquals("User [firstName=John, lastName=Smith, username=Jsmith, birthday=10-10-97, password=password, Rewardspoints=0, pastTransactions=null]", user.toString());
		
	}

	@Test
	void testEqualsObject() {
		User user = new User("John", "Smith", "Jsmith", new Date(10,10,97), "password");
		assertEquals(true, user.equals(new User("John", "Smith", "Jsmith", new Date(10,10,97), "password")));
	}

	@Test
	void testGetUsername() {
		User user = new User("John", "Smith", "Jsmith", new Date(10,10,97), "password");
		assertEquals("Jsmith", user.getUsername());
	}

	@Test
	void testGetPassword() {
		User user = new User("John", "Smith", "Jsmith", new Date(10,10,97), "password");
		assertEquals("password", user.getPassword());
	}

	@Test
	void testGetRewardsPoints() {
		User user = new User("John", "Smith", "Jsmith", new Date(10,10,97), "password");
		user.addRewardPoints(20);
		assertEquals(20, user.getRewardPoints());
	}

	@Test
	void testAddRewardPoints() {
		User user = new User("John", "Smith", "Jsmith", new Date(10,10,97), "password");
		user.addRewardPoints(15);
		assertEquals(15, user.getRewardPoints());
	}

	@Test
	void testRefundTicket() {
		fail("Not yet implemented");
	}

	@Test
	void testGetFirstName() {
		User user = new User("John", "Smith", "Jsmith", new Date(10,10,97), "password");
		assertEquals("John", user.getFirstName());
	}

	@Test
	void testGetLastName() {
		User user = new User("John", "Smith", "Jsmith", new Date(10,10,97), "password");
		assertEquals("Smith", user.getLastName());
	}

	@Test
	void testGetRewardPoints() {
		User user = new User("John", "Smith", "Jsmith", new Date(10,10,97), "password");
		user.addRewardPoints(10);
		assertEquals(10, user.getRewardPoints());
	}

	@Test
	void testGetPastTransactions() {
		fail("Not yet implemented");
	}


	@Test
	void testGetCurrentTransactions() {
		fail("Not yet implemented");
	}

	@Test
	void testGetCart() {
		fail("Not yet implemented");
	}

	@Test
	void testGetBirthdayString() {
		User user = new User("John", "Smith", "Jsmith", new Date(10,10,97), "password");
		assertEquals("10-10-97", user.getBirthdayString());
	}

	@Test
	void testAddToPastTransactions() {
		fail("Not yet implemented");
	}

}
