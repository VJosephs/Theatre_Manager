// Written by Vincent Josephs

public class ChildTicket extends Ticket {

    /**
     * Creates a new show
     *
     * @param price    Price of the child ticket that was bought
     * @param location location of the show that the ticket is for
     * @param show     The name of the event or show that the ticket was purchased for
     * @return n/a   its a constructor
     */
    public ChildTicket(String show, String location, double price) {
        super(show, location, price);
    }

}
