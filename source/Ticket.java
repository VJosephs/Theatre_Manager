// Written by Vincent Josephs



/*
 * This class creates the ticket object, which should display the
 * show the ticket is for and the price of admission.
 */

public class Ticket {
    private String show;
    private String location;
    private double price;

    /**
     * Creates a ticket object
     *
     * @param show the show that the ticket is for
     */
    public Ticket(String show, String location, double price) {
        this.show = show;
        this.price = price;
        this.location = location;
    }

    /**
     * Returns the show that the ticket is for
     *
     * @return the show that the ticket is for
     */
    public String getShow() {
        return this.show;
    }

    /**
     * Returns the price of the ticket
     *
     * @return the price of the ticket
     */
    public double getPrice() {
        return this.price;
    }

    /**
     * Returns the theatre that the show is located in
     *
     * @return the location of the show that the ticket is for
     */
    public String getLocation() {
        return location;
    }

    /**
     * Prints the name and time of the show the ticket is for
     */
    public String toString() {
        return "Admission to " + getShow() + " at a cost of " + getPrice();
    }

}