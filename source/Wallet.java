public class Wallet {
    private double balance;

        /**
     *
     * @param amount     the amount of money that is in the Users account
     */
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
