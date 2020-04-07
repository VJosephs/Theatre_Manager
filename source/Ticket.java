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
     * @return n/a     its a constructor
     * @exception  n/a
     */
    public Ticket(String show, String location, double price) {
        this.show = show;
        this.price = price;
        this.location = location;
    }

    /**
     * Returns the show that the ticket is for
     * @param   none
     * @return the show that the ticket is for
     * @exception   none
     */
    public String getShow() {
        return this.show;
    }

    /**
     * Returns the price of the ticket
     * @param  none
     * @return the price of the ticket
     * @exception none
     */
    public double getPrice() {
        return this.price;
    }

    /**
     * Returns the theatre that the show is located in
     * @param    none
     * @return the location of the show that the ticket is for
     * @excpetion  N/a
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

    public void print(Show show, String str) {
        String outString = "*************************************************************************\n" +
                "**                Thank you for your purchase!!!                       **\n" +
                "**                  We hope you enjoy the show                         **\n" +
                "**                                                                     **\n" +
                "**                                                                     **\n" +
                "*************************************************************************\n" +
                "*************************************************************************\n" +
                "          Ticket for one playing of: "+ show.getName() +"\n" +
                " On the date of: "+show.getShowTime().toString() + "\n" +
                "Purchased for the amount $"+show.getPrice() + "\n" +
                "Seat number: " + str;

        try {
            FileWriter file = new FileWriter("Tickets/Ticket for "+show.getName() + " ("+str+").txt" );
            file.write(outString);
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
