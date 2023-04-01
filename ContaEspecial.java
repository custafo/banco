public class ContaEspecial extends ContaBancaria{
    private double limit;

    public ContaEspecial(String clientName, String number, double amount, double limit) {
        super(clientName, number, amount);
        this.limit = 2000;
    }

    public void withdraw(double value){
        if(super.getAmount() - value < limit){
            System.out.println("You surpassed the limit of money available to complete operation.");
            return;
        }
        super.setAmount(super.getAmount() - value);
    }
    
    public void setLimit(double limit) {
        this.limit = limit;
    }
    public double getLimit() {
        return limit;
    }

    @Override
    public String toString() {
        return "Name: " + super.getClientName() + " Amount: " + super.getAmount() + " Account number: " + super.getNumber()+ " REALIZADO EM CONTA ESPECIA";
    }
}
