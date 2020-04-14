import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {
    private final String eName = "name";
    private final String eLastName = "lastName";
    private final String eUsername = "userName";
    private final String ePassword = "password";
    private Layout layout;
    private final Date birthday = new Date(97, Calendar.OCTOBER, 10);
    private final Employee employee = new Employee(eName, eLastName, eUsername, birthday, ePassword);
    private Theatre theatre;
    private Show show;
    private Rating r1;
    private Rating r2;

    @BeforeEach
    void oneTimeSetup() {
        Ticket ticket1 = new Ticket("show1", "location1", 10);
        Ticket ticket2 = new Ticket("show2", "location2", 15);
        Seat[][] seats = {{new Seat("handicap")}, {new Seat("available")}};
        layout = new Layout("name", seats);
        r1 = new Rating(3.6, "r1", "comment");
        r2 = new Rating(4.5, "r2", "comment2");
        ArrayList<Rating> ratings = new ArrayList<>();
        ratings.add(r1);
        ratings.add(r2);
        ArrayList<Rating> showRatings = new ArrayList<>(ratings);
        ArrayList<Show> shows = new ArrayList<>();
        show = new Show("name", "description", "genre", "ageRating", birthday, "location", 15);
        show.setRatings(showRatings);
        show.addTicket(ticket1);
        show.addTicket(ticket2);
        shows.add(show);
        theatre = new Theatre("name", "address", layout, ratings,
                shows);
        employee.setTheatre(theatre);
    }

    @Test
    void testEmployee() {
        assertEquals(eName, employee.getFirstName());
        assertEquals(eLastName, employee.getLastName());
        assertEquals(eUsername, employee.getUsername());
        assertEquals(ePassword, employee.getPassword());
        assertEquals("10-10-97", employee.getBirthdayString());
    }


    @Test
    void testAddShow() {
        Show show = new Show("name2", "desc", "genre", "ageRating", birthday, "location", 15);
        employee.addShow(show);

        assertTrue(employee.getLocation().getShows().contains(show));
    }


    @Test
    void testRemoveTheatreRating() {
        employee.removeTheatreRating(r1);
        assertFalse(employee.getLocation().getRatings().contains(r1));
    }

    @Test
    void testRemoveShowRating() {
        employee.removeShowRating(r2, show);
        assertFalse(employee.getLocation().getShows().get(0).getRatings().contains(r2));
    }

    @Test
    void testSetTheatre() {
        Theatre theatre1 = new Theatre("name", "address", layout);
        employee.setTheatre(theatre1);
        assertEquals(theatre1, employee.getLocation());
    }

    @Test
    void testGetLocation() {
        employee.setTheatre(theatre);
        assertEquals(theatre, employee.getLocation());
    }
    
    @Test
    void testNull() {
    	Employee e =new Employee();
    	assertEquals(new Employee(), e);
    }

}
