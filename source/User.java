import java.util.Date;
package source;
import java.util.ArrayList; 
public class User {
	
	private String firstName;
	private String lastName;
	private String username;
	private Date birthday; 
	private String paymentInfo;
	private String password;
	private int RewardPoints;
	private ArrayList<Ticket> pastTransactions = new ArrayList<Ticket>();
	
	public User(String firstName, String lastName, Date birthday, String password) { 
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthday = birthday;
		this.password = password;
	}
	
	public purchaseTicket(String name, String address, Date showTime, String paymentInfo) {
		// fill out later
	
	}
	
	public giveRating(double rating, String comment) {
		// fill out later
	}
	
	public ShoppingCart getCurrentCart() {
		// fill out later
	}
	
	public setPaymentInfo() {
		// fill out later
	}
	
	public completePurchase(ShoppingCart cart) {
		// fill out later
	}
}