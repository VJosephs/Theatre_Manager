import java.util.ArrayList;
import java.util.Date;

public class User {

    private String firstName;
    private String lastName;
    private String username;
    private Date birthday;
    private String password;
    private int RewardPoints = 0;
    private ArrayList<Ticket> pastTransactions = new ArrayList<>();
    private ArrayList<Ticket> currentTransactions = new ArrayList<>();
    private ShoppingCart cart = new ShoppingCart(currentTransactions);

    public User() {
    }

    /**
     * @param firstName actual first name of the user for account
     * @param lastName  actual last name of the user for account
     * @param username  made up name for the users account
     * @param birthday  actual birthday of the user to verify age restrictions
     * @param password  String to keep the account protected and private
     * @return n/a      its a constructor
     */
    public User(String firstName, String lastName, String username, Date birthday, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.birthday = birthday;
        this.password = password;
        this.RewardPoints = 0;
    }

    /**
     * @param show     name of the show
     * @param location location of the theater that the show is at
     * @param price    Price of the ticket
     * @return n/a     its void
     */
    public void purchaseTicket(String show, String location, double price, Show s) {
        Ticket ticket = new Ticket(show, location, price);
        cart.addTicket(ticket);
        //TODO implement reward points and child/senior ticket, maybe separate method for each type of ticket?
    }
    /**
     * 
     * @param rating  rating the user left 
     * @param comment comment the user left
     * @return user's rating
     */
    public Rating getRating(double rating, String comment) {
        // TODO fill out later
    	return new Rating(rating, comment, this.username);
    }
    /** 
     * 
     * @return user's shopping cart
     */
    public ShoppingCart getCurrentCart() {
        return cart;
    }
    /**
     * @return the user as a string
     */
    @Override
    public String toString() {
        return "User [firstName=" + firstName + ", lastName=" + lastName + ", username=" + username + ", birthday="
                + birthday + ", password=" + password + ", RewardPoints="
                + RewardPoints + ", pastTransactions=" + pastTransactions + "]";
    }

    /**
     * @return the hash code of a User
     */
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

    /**
     * return boolean on whether the user is equal to another user
     */
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
            return other.username == null;
        } else return username.equals(other.username);
    }
    /**
     * 
     * @return the user's username 
     */
    public String getUsername() {
        return this.username;
    }
    /**
     * 
     * @return the user's password
     */
    public String getPassword() {
        return this.password;
    }

    /**
     * 
     * @return the user's reward point balance
     */
    public int getRewardsPoints() {
        return this.RewardPoints;
    }
    /**
     * 
     * @param funds the amount to be added to reward points
     */
    public void addRewardPoints(int funds) {
        RewardPoints += funds;
    }
    
    public void refundTicket() {
        int ind = pastTransactions.size() - 1;
        Ticket ticket = pastTransactions.get(ind);
        int funds = (int) ticket.getPrice();
        addRewardPoints(funds);
        pastTransactions.remove(ind);
    }
    /**
     * 
     * @return the User's first name 
     */
    public String getFirstName() {
        return firstName;
    }
    /** 
     * 
     * @return the user's last name
     */
    public String getLastName() {
        return lastName;
    }
    /**
     * 
     * @return user's reward points
     */
    public int getRewardPoints() {
        return RewardPoints;
    }
    /**
     * 
     * @return the user's past transactions
     */
    public ArrayList<Ticket> getPastTransactions() {
        return pastTransactions;
    }
    public void getPastTransactionsMenu() {
        for(int i = 0; i < getPastTransactions().size()-1; i++) {
        	System.out.println(i+". " + getPastTransactions().get(i).getShow());
        }
    }
    /**
     * 
     * @return the User's current transaction
     */
    public ArrayList<Ticket> getCurrentTransactions() {
        return currentTransactions;
    }
    /**
     * 
     * @return User's current cart
     */
    public ShoppingCart getCart() {
        return cart;
    }
    /**
     * 
     * @return the user's birthday as a String
     */
    public String getBirthdayString() {
        return "" + birthday.getMonth() + "-" + birthday.getDate() + "-" + birthday.getYear();
    }
    /**
     * 
     * @param ticket to be added to past transactions
     */
     public void addToPastTransactions(Ticket ticket) {
    	 this.pastTransactions.add(ticket);
     }
}
