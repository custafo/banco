import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        System.out.println("Tell me your account's number: ");
        String accountNumber = in.nextLine();
        System.out.println("Tell me the day of the week: ");
        String weekday = in.nextLine().toUpperCase();

        Week weekdayValue = returnWeekDayByString(weekday);
        

        Account account = new Account(accountNumber, 0);
        String decision = "0";
        while(decision != "0"){
        System.out.println("Welcome acount of number: " + accountNumber);
        System.out.println("What action would you like to operate?: ");
        System.out.println("Type 1 to withdraw");
        System.out.println("Type 2 to deposit");
        System.out.println("Type 3 to check your balance");
        System.out.println("Type 0 to leave the program");
        String choice = in.nextLine();
            switch (choice) {
                case "1":
                System.out.println("How much would you like to withdraw?: ");
                double value = in.nextDouble();
                in.nextLine();

                if(account.getAmount() < value){
                    System.out.println("You cannot withdraw any money, your balance is insuficient.");
                    System.out.println("Your balance is: " + account.getAmount());
                    break;
                }
                account.setAmount(account.getAmount() - value);

                    break;
                case "2":
                System.out.println("Type the amount that you want to deposit: ");
                System.out.println("At Weekends, you may be charged");
                value = in.nextDouble();
                in.nextLine();
                
                account.setAmount(account.getAmount() + (value * weekdayValue.getMultiplier()));
                break;

                case "3":
                System.out.println("Your balance is: " + account.getAmount());
                break;

                default:
                System.out.println("It's not an option, please insert it again.");
                    break;
            }
        } 
    }
    public static Week returnWeekDayByString(String value){
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
}