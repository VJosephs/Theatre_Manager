// Written by Vincent Josephs



/*
 * This class creates the ticket object, which should display the
 * show the ticket is for and the price of admission.
 */

import java.io.FileWriter;
import java.io.IOException;

public class Ticket {
    private String show;
    private String location;
    private double price;


    /**
     * @param show     name of show the ticket is for
     * @param location the location of the theater the ticket is for
     * @param price    price of the ticket
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
        return " :: Thank you for your purchase to see " + getShow() + ":: \n"
                + ":: The show you have paid to see will be at " + getLocation() + ". And finally you paid" + getPrice() + "for your ticket! :: \n"
                + " :: Thanks again for purchasing at THE_247_PROJECT. Have a nice day and call (***)-***-**** if you have any issues!";
    }

    /**
     * @param show the show name
     * @param str  name of the file tickets are saved to
     */
    public void print(Show show, String str) {
        String outString = "*************************************************************************\n" +
                "**                Thank you for your purchase!!!                       **\n" +
                "**                  We hope you enjoy the show                         **\n" +
                "**                                                                     **\n" +
                "**                                                                     **\n" +
                "*************************************************************************\n" +
                "*************************************************************************\n" +
                "          Ticket for one playing of: " + show.getName() + "\n\n" +
                "On the date of: " + show.getShowTime().toString() + "\n" +
                "Purchased for the amount $" + show.getPrice() + "\n" +
                "Seat number: " + str;

        try {
            FileWriter file = new FileWriter("Tickets/Ticket_for_" + show.getName() + "_(" + str + ").txt");
            file.write(outString);
            file.flush();
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
