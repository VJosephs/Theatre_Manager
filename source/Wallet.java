

public class Wallet {
private double balence;

public void addBalence(double amount) {
	this.balence += amount;
}

public void subtractBalence(double amount) {
	this.balence -= amount;
}

public double getBalence() {
	return this.balence;
}

}