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

	public User(String firstName, String lastName, String username, Date birthday, String password) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthday = birthday;
		this.password = password;
	}
	
	public void purchaseTicket(String name, String address, Date showTime, String paymentInfo) {
		// TODO fill out later
	
	}
	
	public void giveRating(double rating, String comment) {
		// TODO fill out later
	}
	
	public ShoppingCart getCurrentCart() {
		// TODO fill out later
		return null;
	}
	
	public void setPaymentInfo() {
		// TODO fill out later
	}
	
	public void completePurchase(ShoppingCart cart) {
		// TODO fill out later
	}
}