import java.util.ArrayList;

public class ShoppingCart {
    public ArrayList<Ticket> cart;

    /**
     * @param cart used as a matrix that hold all the tickets a user is considering buying
     * @return n/a     its a constructor
     */

    ShoppingCart(ArrayList<Ticket> cart) {
        this.cart = cart;
    }
    /**
     * 
     * @param ticket to be added to cart
     */
    public void addTicket(Ticket ticket) {
        cart.add(ticket);
    }
    /**
     * 
     * @param ticket to be removed from cart
     */
    public void removeTicket(Ticket ticket) {
        cart.remove(ticket);
    }
    /**
     * 	prints tickets
     */
    public void printTickets() {
        // For each ticket in the cart, print out the ticket
        for (Ticket ticket : cart) {
            System.out.println(ticket.toString());
        }
    }
    /**
     * 
     * @return if user is old enough to buy a ticket
     */
    public boolean verifyAge() {
        return true;
    }
    /**
     * 
     * @return the cart 
     */
    public ArrayList<Ticket> getCart() {
        return cart;
    }
}
