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
		this.username =username;
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

	@Override
	public String toString() {
		return "User [firstName=" + firstName + ", lastName=" + lastName + ", username=" + username + ", birthday="
				+ birthday + ", paymentInfo=" + paymentInfo + ", password=" + password + ", RewardPoints="
				+ RewardPoints + ", pastTransactions=" + pastTransactions + "]";
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((birthday == null) ? 0 : birthday.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (birthday == null) {
			if (other.birthday != null)
				return false;
		} else if (!birthday.equals(other.birthday))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}
}