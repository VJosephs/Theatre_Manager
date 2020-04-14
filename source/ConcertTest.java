import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ConcertTest {

    @Test
    void test() {
        Date date = new Date(10, 10, 2000);
        Concert concert = new Concert("name", "desc", "genre", "21+", date, "location", 10);
        assertEquals("name", concert.getName());
        assertEquals("desc", concert.getDescription());
        assertEquals("genre", concert.getGenre());
        assertEquals(21, concert.getAgeRating());
        assertEquals(date, concert.getShowTime());
        assertEquals("location", concert.getLocation());
        assertEquals(10, concert.getPrice());
    }

    @Test
    void testGetAgeRating() {
        Date date = new Date(10, 10, 2000);
        Concert concert = new Concert("name", "desc", "genre", "21+", date, "location", 10);
        assertEquals(21, concert.getAgeRating());
    }

    @Test
    void testGetAgeRating18() {
        Date date = new Date(10, 10, 2000);
        Concert concert = new Concert("name", "desc", "genre", "18+", date, "location", 10);
        assertEquals(18, concert.getAgeRating());
    }

    @Test
    void testGetAgeRating15() {
        Date date = new Date(10,10,2000);
        Concert concert =new Concert("name", "desc", "genre", "All Ages", date, "location", 10);
        assertEquals(0, concert.getAgeRating());
    }

}
