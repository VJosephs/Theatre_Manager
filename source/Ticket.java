// Written by Vincent Josephs



/*
 * This class creates the ticket object, which should display the 
 * show the ticket is for and the price of admission. 
 */

public class Ticket {
	private Show show;
	private double price;
	
	/**
	 * Creates a ticket object
	 * @param show the show that the ticket is for
	 */
	public Ticket(Show show) {
		this.show = show;
		this.price = show.getPrice();
	}
	
	/**
	 * Returns the show that the ticket is for
	 * @return the show that the ticket is for
	 */
	public Show getShow() {
		return this.show;
	}
	
	/**
	 * Returns the price of the ticket
	 * @return the price of the ticket
	 */
	public double getPrice() {
		return this.price;
	}
	
	/**
	 * Returns the theatre that the show is located in
	 * @return the location of the show that the ticket is for
	 */
	public Theatre getTheatre() {
		return show.getLocation();
	}
	
	/**
	 * Prints the name and time of the show the ticket is for
	 */
	 public String toString() {
        return " :: Thank you for your purchase to see " + getShow() + ":: \n"
        		+ ":: The show you have paid to see will be at " + getLocation() +   ". And finally you paid" + getPrice() + "for your ticket! :: \n"
        		+ " :: Thanks again for purchasing at THE_247_PROJECT. Have a nice day and call (***)-***-**** if you have any issues!";
    }


}
