// Written by Vincent Josephs

package source;

/*
 * This class creates the ticket object, which should display the 
 * show the ticket is for and the price of admission. The ticket 
 * should also 
 */

public class Ticket {
	private Show show;
	private double price;
	
	// Create ticket object
	public Ticket(Show show, Theatre theatre) {
		this.show = show;
		this.theatre = theatre;
	}
	
	public Show getShow() {
		return this.show;
	}
	
	public double getPrice() {
		return this.price;
	}
	
	public Theatre getTheatre() {
		return this.getTheatre();
	}
	
	public String toString() {
		// do this later 
	}

}