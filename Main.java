import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Tell me your account's number: ");
        String accountNumber = in.nextLine();
        System.out.println("Tell me the day of the week: ");
        String weekday = in.nextLine().toUpperCase();
        System.out.println("Tell me your full name: ");
        String clientsName = in.nextLine().toUpperCase();

        Week weekdayValue = returnWeekDayByString(weekday);
        ArrayList<Object> accountArray = new ArrayList<Object>();

        ContaPoupança account = new ContaPoupança(clientsName, accountNumber, 0);

        String decision = "0";
        while (decision != "0") {
            System.out.println("Welcome acount of number: " + accountNumber);
            System.out.println("What action would you like to operate?: ");
            System.out.println("Type 1 to add a new account");
            System.out.println("Type 2 to withdraw");
            System.out.println("Type 3 to deposit");
            System.out.println("Type 4 to update the value of your accounts");
            System.out.println("Type 5 to show your balance");
            System.out.println("Type 0 to leave the program");
            String choice = in.nextLine();

            switch (choice) {
                case "1":
                    System.out.println("What type of account you want to create?");
                    System.out.println("1 - Saving; 2 - Special;");
                    System.out.print("> ");
                    String accountType = in.nextLine();

                    System.out.println("Type your accounts number: ");
                    System.out.print("> ");
                    accountNumber = in.nextLine();

                    System.out.println("Type your name: ");
                    System.out.print("> ");
                    String clientName = in.nextLine();

                    if (accountType.equals("1")) {
                        accountArray.add(new ContaPoupança(clientName, accountNumber, 0));
                    }
                    if (accountType.equals("2")) {
                        accountArray.add(new ContaEspecial(clientName, accountNumber, 0, 2000));
                    }
                    break;

                case "2":
                    System.out.println("Type your account's number");
                    accountNumber = in.nextLine();

                    System.out.println("Type the amount that you want to withdraw: ");
                    double value = in.nextDouble();
                    in.nextLine();
                    boolean check = false;
                    Object currentAccount;

                    for (int i = 0; i < accountArray.size(); i++) {
                        String currentNumber = "";
                        currentAccount = accountArray.get(i);
                        if (currentAccount instanceof ContaEspecial) {
                            ContaEspecial currentContaEspecial = (ContaEspecial) currentAccount;
                            currentNumber = currentContaEspecial.getNumber();
                            if (currentNumber.equals(accountNumber)) {
                                currentContaEspecial.withdraw(value);
                                check = true;
                                break;
                            }
                        }
                        if (currentAccount instanceof ContaPoupança) {
                            ContaPoupança currentContaPoupança = (ContaPoupança) currentAccount;
                            currentNumber = currentContaPoupança.getNumber();
                            if (currentNumber.equals(accountNumber)) {
                                currentContaPoupança.withdraw(value);
                                check = true;
                                break;
                            }
                        }
                        if (check) {
                            System.out.println("Your withdrawed your money successfully");
                        } else {
                            System.out.println("There was an error withdrawing your money, please try again.");
                        }
                    }

                    break;

                case "3":
                    System.out.println("Type your account's number");
                    accountNumber = in.nextLine();

                    System.out.println("Type the amount that you want to withdraw: ");
                    value = in.nextDouble();
                    in.nextLine();
                    check = false;
                    Object currentsAccount;

                    for (int i = 0; i < accountArray.size(); i++) {
                        String currentNumber = "";
                        currentsAccount = accountArray.get(i);
                        if (currentsAccount instanceof ContaEspecial) {
                            ContaEspecial currentContaEspecial = (ContaEspecial) currentsAccount;
                            currentNumber = currentContaEspecial.getNumber();
                            if (currentNumber.equals(accountNumber)) {
                                currentContaEspecial.setAmount(currentContaEspecial.getAmount() + value);
                                check = true;
                                break;
                            }
                        }
                        if (currentsAccount instanceof ContaPoupança) {
                            ContaPoupança currentContaPoupança = (ContaPoupança) currentsAccount;
                            currentNumber = currentContaPoupança.getNumber();
                            if (currentNumber.equals(accountNumber)) {
                                currentContaPoupança.setAmount(currentContaPoupança.getAmount() + value);
                                check = true;
                                break;
                            }
                        }
                        if (check) {
                            System.out.println("Your deposited your money successfully");
                        } else {
                            System.out.println("There was an error depositing your money, please try again.");
                        }
                    }

                    break;

                case "4":
                    check = false;

                    System.out.println("Tell me the day of the week: ");
                    weekday = in.nextLine();

                    for (int i = 0; i < accountArray.size(); i++) {
                        currentAccount = accountArray.get(i);

                        if (currentAccount instanceof ContaPoupança) {
                            ContaPoupança currentContaPoupança = (ContaPoupança) currentAccount;
                            currentContaPoupança.update(weekday);
                        }
                    }
                    break;

                case "5":
                    System.out.println("Existing accounts: ");
                    for (int i = 0; i < accountArray.size(); i++) {
                        currentAccount = accountArray.get(i);

                        if (currentAccount instanceof ContaPoupança) {
                            ContaPoupança currentContaPoupança = (ContaPoupança) currentAccount;
                            System.out.println(currentContaPoupança);
                        }

                        if (currentAccount instanceof ContaEspecial) {
                            ContaEspecial currentContaEspecial = (ContaEspecial) currentAccount;
                            System.out.println(currentContaEspecial);
                        }
                    }
                    break;

                default:
                    System.out.println("IDK WHAT U DID, JUST DO IT AGAIN AND IN THE RIGHT WAY!");
                    break;
            }
            in.close();
        }
    }

    public static Week returnWeekDayByString(String value) {
        if (value.equals("DOMINGO")) {
            return Week.DOMINGO;
        }
        if (value.equals("SEGUNDA")) {
            return Week.SEGUNDA;
        }
        if (value.equals("TERÇA")) {
            return Week.TERÇA;
        }
        if (value.equals("QUARTA")) {
            return Week.QUARTA;
        }
        if (value.equals("QUINTA")) {
            return Week.QUINTA;
        }
        if (value.equals("SEXTA")) {
            return Week.SEXTA;
        }
        if (value.equals("SABADO")) {
            return Week.SABADO;
        }
        return null;
    }
}