public class Account {
    private String number;
    private double amount;

    public Account(String number, double amount){
        this.number = number;
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

    public String getNumber() {
        return number;
    }

    public void setAmount(double d) {
        this.amount = d;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
