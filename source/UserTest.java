import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    public static void setup() {
        User user = new User("John", "Smith", "Jsmith", new Date(97, Calendar.OCTOBER, 10), "password");
    }
    
    @Test
    void testNullUser() {
    	User user = new User();
    	assertEquals(new User(), user);
    }
    
    @Test
    void getnoreward() {
    	   User user = new User("John", "Smith", "Jsmith", new Date(97, Calendar.OCTOBER, 10), "password");
    	   assertEquals(0, user.getRewardPoints());
    }

    @Test
    void testUser() {
        User user = new User("John", "Smith", "Jsmith", new Date(97, Calendar.OCTOBER, 10), "password");
        assertEquals(new User("John", "Smith", "Jsmith", new Date(97, Calendar.OCTOBER, 10), "password"), user);
    }


    @Test
    void testGetRating() {
        User user = new User("John", "Smith", "Jsmith", new Date(97, Calendar.OCTOBER, 10), "password");

        assertEquals(new Rating(3.5, "Jsmith", "comment"), user.getRating(3.5, "comment"));
    }

    @Test
    void testGetCurrentCart() {
		User user = new User("John", "Smith", "Jsmith", new Date(97, Calendar.OCTOBER, 10), "password");
		Show show = new Show("Show", "String description", "String genre", "String ageRating", new Date(10,Calendar.JANUARY, 1), "String location",1);
		user.addToPastTransactions(new Ticket("Show", show.getLocation(), show.getPrice()));
		user.purchaseTicket("Show", show.getLocation(), show.getPrice());

		assertEquals(user.getPastTransactions().get(0).getShow(), user.getCurrentCart().getCart().get(0).getShow());
    }

    @Test
    void testToString() {
        String user = new User("John", "Smith", "Jsmith", new Date(97, Calendar.OCTOBER, 10), "password").toString();
        assertEquals("User [firstName=John, lastName=Smith, username=Jsmith, birthday=10-10-97, password=password, RewardPoints=0, pastTransactions=[]]", user);

    }

    @Test
    void testEqualsObject() {
        User user = new User("John", "Smith", "Jsmith", new Date(97, Calendar.OCTOBER, 10), "password");
        assertTrue(user.equals(new User("John", "Smith", "Jsmith", new Date(97, Calendar.OCTOBER, 10), "password")));
    }

    @Test
    void testGetUsername() {
        User user = new User("John", "Smith", "Jsmith", new Date(97, Calendar.OCTOBER, 10), "password");
        assertEquals("Jsmith", user.getUsername());
    }

    @Test
    void testGetPassword() {
        User user = new User("John", "Smith", "Jsmith", new Date(97, Calendar.OCTOBER, 10), "password");
        assertEquals("password", user.getPassword());
    }

    @Test
    void testGetRewardsPoints() {
        User user = new User("John", "Smith", "Jsmith", new Date(97, Calendar.OCTOBER, 10), "password");
        user.addRewardPoints(20);
        assertEquals(20, user.getRewardPoints());
    }

    @Test
    void testAddRewardPoints() {
        User user = new User("John", "Smith", "Jsmith", new Date(97, Calendar.OCTOBER, 10), "password");
        user.addRewardPoints(15);
        assertEquals(15, user.getRewardPoints());
    }

    @Test
    void testRefundTicket() {
    	User user = new User("John", "Smith", "Jsmith", new Date(97, Calendar.OCTOBER, 10), "password");
    	Show show = new Show("Show", "String description", "String genre", "String ageRating", new Date(10,Calendar.JANUARY, 1), "String location",1);
    	ArrayList<Ticket> testList = new ArrayList<Ticket>();
		ShoppingCart testCart = new ShoppingCart(testList);
    	user.purchaseTicket("Show", show.getLocation(), show.getPrice());
    	user.addToPastTransactions(new Ticket("Show", show.getLocation(), show.getPrice()));
		user.refundTicket();
		assertEquals(user.getCart().getCart().get(0).getShow(), "Show");
    }
    
    @Test
    void testRefundTicketPoints() {
    	User user = new User("John", "Smith", "Jsmith", new Date(97, Calendar.OCTOBER, 10), "password");
    	Show show = new Show("Show", "String description", "String genre", "String ageRating", new Date(10,Calendar.JANUARY, 1), "String location",1);
    	user.purchaseTicket("Show", show.getLocation(), show.getPrice());
    	user.addToPastTransactions(new Ticket("Show", show.getLocation(), show.getPrice()));
		user.refundTicket();
		assertEquals(user.getRewardPoints(), 1);
    }

    @Test
    void testGetFirstName() {
        User user = new User("John", "Smith", "Jsmith", new Date(97, Calendar.OCTOBER, 10), "password");
        assertEquals("John", user.getFirstName());
    }

    @Test
    void testGetLastName() {
        User user = new User("John", "Smith", "Jsmith", new Date(97, Calendar.OCTOBER, 10), "password");
        assertEquals("Smith", user.getLastName());
    }

    @Test
    void testGetRewardPoints() {
        User user = new User("John", "Smith", "Jsmith", new Date(97, Calendar.OCTOBER, 10), "password");
        user.addRewardPoints(97);
        assertEquals(97, user.getRewardPoints());
    }

    @Test
    void testGetPastTransactions() {
    	User user = new User("John", "Smith", "Jsmith", new Date(97, Calendar.OCTOBER, 10), "password");
    	Show show = new Show("Show", "String description", "String genre", "String ageRating", new Date(10,Calendar.JANUARY, 1), "String location",1);
    	Ticket ticket = new Ticket("Show", show.getLocation(), show.getPrice());
    	user.addToPastTransactions(ticket);
    	ArrayList<Ticket> transactionTest = new ArrayList<Ticket>();
    	transactionTest.add(ticket);
    	assertEquals(user.getPastTransactions(), transactionTest);
    }


    @Test
    void testGetCurrentTransactions() {
    	User user = new User("John", "Smith", "Jsmith", new Date(97, Calendar.OCTOBER, 10), "password");
    	ArrayList<Ticket> transactionTest = new ArrayList<Ticket>();
    	assertEquals(user.getCurrentTransactions(), transactionTest); //Nothing adds to Current transactions so testing against an empty arraylist
    }


    @Test
    void testGetBirthdayString() {
        User user = new User("John", "Smith", "Jsmith", new Date(97, Calendar.OCTOBER, 10), "password");
        assertEquals("10-10-97", user.getBirthdayString());
    }

    @Test
    void testAddToPastTransactions() {
    	User user = new User("John", "Smith", "Jsmith", new Date(97, Calendar.OCTOBER, 10), "password");
    	Show show = new Show("Show", "String description", "String genre", "String ageRating", new Date(10,Calendar.JANUARY, 1), "String location",1);
    	Ticket ticket = new Ticket("Show", show.getLocation(), show.getPrice());
    	user.addToPastTransactions(ticket);
    	ArrayList<Ticket> transactionTest = user.getPastTransactions();
    	ArrayList<Ticket> transactionTest2 = new ArrayList<Ticket>();
    	transactionTest2.add(ticket);
    	assertEquals(transactionTest, transactionTest2);
    }

}
