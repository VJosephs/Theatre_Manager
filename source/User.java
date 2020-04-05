import java.util.Date;
import java.util.ArrayList; 
public class User {
	
	private String firstName;
	private String lastName;
	private String username;
	private Date birthday; 
	private String paymentInfo;
	private String password;
	private int RewardPoints;
	private ArrayList<Ticket> pastTransactions = new ArrayList<>();
	private ArrayList<Ticket> currentTransactions = new ArrayList<>();
	private ShoppingCart cart = new ShoppingCart(currentTransactions);

	public User(String firstName, String lastName, String username, Date birthday, String password) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthday = birthday;
		this.password = password;
	}
	
	public void purchaseTicket(Show show, String paymentInfo) {
		Ticket ticket = new Ticket(show);
		cart.addTicket(ticket);
		//TODO implement reward points and child/senior ticket, maybe separate method for each type of ticket?
	}
	
	public void giveRating(double rating, String comment) {
		// TODO fill out later
	}
	
	public ShoppingCart getCurrentCart() {
		return cart;
	}
	
	public void setPaymentInfo() {
		// TODO fill out later
	}
	
	public void completePurchase() {
		// TODO fill out later
	}
}