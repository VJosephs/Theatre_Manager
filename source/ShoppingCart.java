import java.util.ArrayList;

public class ShoppingCart {
    public ArrayList<Ticket> cart;

    ShoppingCart(ArrayList<Ticket> cart) {
        this.cart = cart;
    }

    public void addTicket(Ticket ticket) {
        cart.add(ticket);
    }

    public void removeTicket(Ticket ticket) {
        cart.remove(ticket);
    }

    public void printTickets() {
        // For each ticket in the cart, print out the ticket
        for (Ticket ticket : cart) {
            System.out.println(ticket.toString());
        }
    }

    public void addRewardPoints() {

    }

    public boolean verifyAge() {
        return true;
    }

    public ArrayList<Ticket> getCart() {
        return cart;
    }
}