// Written by Vincent Josephs

public class ChildTicket extends Ticket {

    /**
     * Creates a child ticket for the show
     *
     * @param show The show that the ticket is for
     */
    public ChildTicket(String show, String location, double price) {
        super(show, location, price);
    }

}
