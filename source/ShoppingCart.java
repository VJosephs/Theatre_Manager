import java.util.ArrayList;

public class ShoppingCart {
    public ArrayList<Ticket> cart;

    /**
     * @param cart used as a matri that hold all the tickets a user is considering buying
     * @return n/a     its a constructor
     * @exception  n/a
     */

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
        //TODO later

    }

    public boolean verifyAge() {
        return true;
    }

    public ArrayList<Ticket> getCart() {
        return cart;
    }
}
