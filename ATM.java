import java.util.*;

class Bankacc {
    private double bal;

    public Bankacc(double init) {
        this.bal = init;
    }

    public double getbal() {
        return bal;
    }

    public void deposit(double amt) {
        if (amt > 0) {
            bal += amt;
            System.out.println("Successfully deposited " + amt);
        } else {
            System.out.println("Invalid deposit amt.");
        }
    }

    public void withdraw(double amt) {
        if (amt > 0 && amt <= bal) {
            bal -= amt;
            System.out.println("Successfully withdrew " + amt);
        } else if (amt > bal) {
            System.out.println("Insufficient bal.");
        } else {
            System.out.println("Invalid withdrawal amt.");
        }
    }
}

class dispATM {
    private Bankacc acc;
    private Scanner scanner;

    public dispATM(Bankacc acc) {
        this.acc = acc;
        this.scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        while (true) {
            System.out.println("\nATM Menu:");
            System.out.println("1. Check balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    checkbal();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    withdraw();
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void checkbal() {
        System.out.println("Current bal: " + acc.getbal());
    }

    private void deposit() {
        System.out.print("Enter deposit amt: ");
        double amt = scanner.nextDouble();
        acc.deposit(amt);
    }

    private void withdraw() {
        System.out.print("Enter withdrawal amt: ");
        double amt = scanner.nextDouble();
        acc.withdraw(amt);
    }
}

public class ATM {
    public static void main(String[] args) {
        System.out.println("Enter the inital Balance: ");
        Bankacc acc = new Bankacc(1000.00); // Initial bal
        dispATM atm = new dispATM(acc);
        atm.displayMenu();
    }
}
