// Written by Vincent Josephs



/*
 * This class creates the ticket object, which should display the 
 * show the ticket is for and the price of admission. 
 */

public class Ticket {
	private Show show;
	private double price;
	
	// Create ticket object
	public Ticket(Show show, Theatre theatre) {
		this.show = show;
		this.price = show.getPrice();
	}
	
	public Show getShow() {
		return this.show;
	}
	
	public double getPrice() {
		return this.price;
	}
	
	public Theatre getTheatre() {
		//TODO fix this
		return null;
	}
	
	public String toString() {
		// TODO do this later
		return null;
	}

}