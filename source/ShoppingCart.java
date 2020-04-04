import java.util.ArrayList;

public class ShoppingCart {
	public ArrayList<Ticket> cart;
	
	ShoppingCart(ArrayList<Ticket> cart){
		this.cart = cart;
	}
	
	public void addTicket(Ticket ticket) {
		cart.add(ticket);
	}
	
	public void removeTicket(Ticket ticket) {
		cart.remove(ticket);
	}
	
	public void printTickets() {
		
	}
	
	public void addRewardPoints() {
		
	}
	
	public boolean verifyAge() {
		return true;
	}
	

}