public class Test {
    private int idNumber;
    // identity number for this account
    private double balance;
    // current balance for this account
    private double interest;

    // precondition: startBal >= 0.0
    // postcondition: An Account with
    // identity number idNum and current balance of startBal
    // has been created
    // exceptions: If startBal < 0.0, an IllegalArgumentException is thrown
    public Account(int idNum, double startBal, double interest) { 
        if (startBal < 0.0) {
            throw new IllegalArgumentException("Current Balance:" + startBal + "Balance should not be less than zero");
        }
        idNumber = idNum;
        balance = startBal;
        this.interest = interest;
    }

    // postcondition: returns the identity number for this account
    public int idNumber() {
        return idNumber; 
    }

    // postcondition: returns the current balance for this account
    public double currentBalance() {
        return balance;
    }
    // precondition: amount >= 0.0
    // postcondition: the current balance of this account has been
    // increased by amount;
    // exceptions: if amount < 0.0, then current balance is unchanged
    // and an IllegalArgumentException is thrown
    public void deposit(double amount) {
        if (amount < 0.0) {
            throw new IllegalArgumentException("Current Balance:" + amount + "Balance should not be less than zero");
        }
        balance = balance + amount;
    }

    // precondition: 0.0 <= amount <= balance
    // postcondition: the current balance of this account has been
    // decreased by amount;
    // exceptions: if amount < 0.0 or if amount > balance, then current
    // balance is unchanged and an IllegalArgumentException is thrown
    public void decreaseBalance(double amount) {
        if (amount < 0.0 || amount > balance) {
            throw new IllegalArgumentException("Current Balance:" + amount + "Balance should not be less than zero");
        }
        balance = balance - amount;
    }

    // postcondition: returns the monthly interest due for this account
    public double monthlyInterest() {
        return balance * (interest / 12);
    }


}