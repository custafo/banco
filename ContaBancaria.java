public class ContaBancaria {
    private String number;
    private double amount;
    private String clientName;

    public ContaBancaria(String clientName ,String number, double amount){
        this.clientName = clientName;
        this.number = number;
        this.amount = amount;
    }

    public String getClientName(){
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
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
