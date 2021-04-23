import java.util.IllegalFormatCodePointException;
import java.util.Scanner;

public class ATMAccount {
    private String name;
    private double balance;
    private String[] history = new String[3];

    public ATMAccount(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }

    public ATMAccount() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void openMenu(){
        System.out.println("Menu: ");
        System.out.println();
        System.out.println("\t 1. Press A to check your account.");
        System.out.println("\t 2. Press D to deposit.");
        System.out.println("\t 3. Press W to withdraw.");
        System.out.println("\t 4. Press H to view History");
        System.out.println("\t 5. Press X to exit.");
    }

    public void checkAccount(){
        System.out.println("Your balance: "+balance+"$");
        System.out.println();
        System.out.println("Enter your choice: ");
        System.out.println("==================================");
        openMenu();
    }

    public void deposit(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Deposit transaction: ");
        double amount;
        do {
            System.out.println("Please enter your money: ");
            while (!sc.hasNextDouble()) {
                System.out.println("Invalid number! Please enter your number: ");
                sc.next();
            }
            amount = sc.nextDouble();
        } while (amount <= 0);

        System.out.println("Successful transaction!. You was deposited " + amount+ "$ successfully");
        setBalance(balance+amount);
        System.out.println("Your balance: "+balance+"$");

        if (history[0] == null && history[1] == null && history[2] == null){
            history[0] = "Deposit "+amount+"$.";
        } else if (history[1] == null && history[2] == null){
            history[1] = "Deposit "+amount+"$.";
        }       else if (history[2] == null){
                    history[2] = "Deposit "+amount+"$.";
        }           else {
                        history[0] = history[1];
                        history[1] = history[2];
                        history[2] = "Deposit: "+ amount+"$.";
        }

        System.out.println();
        System.out.println("Enter your choice: ");
        System.out.println("==================================");
        openMenu();
    }

    public void withdraw(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Withdraw transaction: ");
        double amount;
        do {
            System.out.println("Please enter your money: ");
            while (!sc.hasNextDouble()) {
                System.out.println("Invalid number! Please enter your number: ");
                sc.next();
            }
            amount = sc.nextDouble();
        } while (amount <= 0);

        if (amount > this.getBalance()) {
            System.out.println("Transaction was unsuccessful!");
            System.out.println("Your balance: "+this.getBalance()+"$");
            System.out.println("Your balance is not enough to withdraw!");
            System.out.println();
            System.out.println("Enter your choice: ");
            System.out.println("==================================");
            openMenu();
        }   else {
            System.out.println("Successful transaction!. You was withdrawn " + amount+ "$ successfully");
            setBalance(balance - amount);
            System.out.println("Your balance: "+balance+"$");

            if (history[0] == null && history[1] == null && history[2] == null){
                history[0] = "Withdraw: "+amount+"$.";
            } else if (history[1] == null && history[2] == null){
                history[1] = "Withdraw: "+amount+"$.";
            }       else if (history[2] == null){
                        history[2] = "Withdraw: "+amount+"$.";
            }           else {
                            history[0] = history[1];
                            history[1] = history[2];
                            history[2] = "Withdraw: "+ amount+"$.";
            }

            System.out.println();
            System.out.println("Enter your choice: ");
            System.out.println("==================================");
            openMenu();
        }
    }

    public void openHistory(){
        System.out.println("History transaction: ");
        for (int i = 0; i < 3; i++) {
            if (history[i] != null) {
                System.out.println(i+1+". "+ history[i]);
            } else {
                System.out.println("Empty!");
            }

        }
        System.out.println();
        System.out.println("Enter your choice: ");
        System.out.println("==================================");
        openMenu();
    }

    public void login(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome "+name+" to ABC Bank!");
        openMenu();
        System.out.println("==================================");
        System.out.println("Enter your choice: ");

        String choice = sc.nextLine();
        while (!choice.equals("X")) {
            if (choice.equals("A")) {
                checkAccount();
                choice =sc.nextLine();
            } else if (choice.equals("W")) {
                withdraw();
                choice = sc.nextLine();
            }   else if (choice.equals("D")){
                deposit();
                choice = sc.nextLine();
            }       else if (choice.equals("H")){
                openHistory();
                choice = sc.nextLine();
            }           else {
                System.out.println("Invalid choice!");
                System.out.println("Enter your choice: ");
                System.out.println("==================================");
                openMenu();
                choice = sc.nextLine();
            }
        }
        if (choice.equals("X")){
            System.out.println("Thanks for using our ATM");
        }
    }



}
