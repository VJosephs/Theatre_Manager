public class Wallet {
private double balance;

public void addBalance(double amount) {
	this.balance += amount;
}

public void subtractBalance(double amount) {
	this.balance -= amount;
}

public double getBalance() {
	return this.balance;
}

}