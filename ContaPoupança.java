public class ContaPoupança extends ContaBancaria{
    Week incomeDays;

    public ContaPoupança(String clientName, String number, double amount) {
        super(clientName, number, amount);
    }

    public void update(String value){
        incomeDays = returnWeekDayByString(value);
        super.setAmount(getAmount() * incomeDays.getMultiplier());
    }

    public void withdraw(double value){
        if(super.getAmount() - value < 0){
            System.out.println("Not enough money to complete operation.");
            return;
        }
        super.setAmount(super.getAmount() - value);
    }

    private Week returnWeekDayByString(String value){
        if(value.equals("DOMINGO")){
            return Week.DOMINGO;
        }
        if(value.equals("SEGUNDA")){
            return Week.SEGUNDA;
        }
        if(value.equals("TERÇA")){
            return Week.TERÇA;
        }
        if(value.equals("QUARTA")){
            return Week.QUARTA;
        }
        if(value.equals("QUINTA")){
            return Week.QUINTA;
        }
        if(value.equals("SEXTA")){
            return Week.SEXTA;
        }
        if(value.equals("SABADO")){
            return Week.SABADO;
        }
        return null;
    }

    public void setIncomeDays(Week incomeDays) {
        this.incomeDays = incomeDays;
    }

    @Override
    public String toString() {
        return "Name: " + super.getClientName() + " Amount: " + super.getAmount() + " Account number: " + super.getNumber() + " REALIZADO EM CONTA POUPANÇA";
    }
}
