import java.util.Scanner;

class Account {
    String customerName;
    String accountNumber;
    String accountType;
    double balance;
    Account(String customerName, String accountNumber, String accountType, double initialBalance) {
        this.customerName = customerName;
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Amount deposited successfully. Updated balance: " + balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }
    public void displayBalance() {
        System.out.println("Account Balance: " + balance);
    }
}

class SavAcct extends Account {
    private final double interestRate = 0.04; 

    SavAcct(String customerName, String accountNumber, double initialBalance) {
        super(customerName, accountNumber, "Savings", initialBalance);
    }

    public void computeAndDepositInterest() {
        double interest = balance * interestRate;
        balance += interest;
        System.out.println("Interest added: " + interest + ". Updated balance: " + balance);
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Amount withdrawn: " + amount + ". Updated balance: " + balance);
        } else {
            System.out.println("Insufficient balance or invalid withdrawal amount.");
        }
    }
}

class CurAcct extends Account {
    // These fields are now accessible within the package or by subclasses
    double minimumBalance = 500.0; // Default minimum balance
    double serviceCharge = 50.0;   // Service charge

    CurAcct(String customerName, String accountNumber, double initialBalance) {
        super(customerName, accountNumber, "Current", initialBalance);
    }

    void checkMinimumBalance() {
        if (balance < minimumBalance) {
            balance -= serviceCharge;
            System.out.println("Balance below minimum. Service charge of " + serviceCharge + " imposed. Updated balance: " + balance);
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Amount withdrawn: " + amount + ". Updated balance: " + balance);
            checkMinimumBalance();
        } else {
            System.out.println("Insufficient balance or invalid withdrawal amount.");
        }
    }
}

public class Bank {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        
        System.out.print("Enter customer name for Savings Account: ");
        String savName = sc.nextLine();
        System.out.print("Enter account number for Savings Account: ");
        String savAccNum = sc.nextLine();
        System.out.print("Enter initial deposit for Savings Account: ");
        double savInitBalance = sc.nextDouble();
        SavAcct savAccount = new SavAcct(savName, savAccNum, savInitBalance);

       
        sc.nextLine(); // clear buffer
        System.out.print("\nEnter customer name for Current Account: ");
        String curName = sc.nextLine();
        System.out.print("Enter account number for Current Account: ");
        String curAccNum = sc.nextLine();
        System.out.print("Enter initial deposit for Current Account: ");
        double curInitBalance = sc.nextDouble();
        CurAcct curAccount = new CurAcct(curName, curAccNum, curInitBalance);

        
        int choice;
        do {
            System.out.println("\n1. Deposit in Savings Account");
            System.out.println("2. Withdraw from Savings Account");
            System.out.println("3. Display Savings Account Balance");
            System.out.println("4. Compute Interest in Savings Account");
            System.out.println("5. Deposit in Current Account");
            System.out.println("6. Withdraw from Current Account");
            System.out.println("7. Display Current Account Balance");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter amount to deposit in Savings Account: ");
                    double savDeposit = sc.nextDouble();
                    savAccount.deposit(savDeposit);
                    break;

                case 2:
                    System.out.print("Enter amount to withdraw from Savings Account: ");
                    double savWithdraw = sc.nextDouble();
                    savAccount.withdraw(savWithdraw);
                    break;

                case 3:
                    savAccount.displayBalance();
                    break;

                case 4:
                    savAccount.computeAndDepositInterest();
                    break;

                case 5:
                    System.out.print("Enter amount to deposit in Current Account: ");
                    double curDeposit = sc.nextDouble();
                    curAccount.deposit(curDeposit);
                    break;

                case 6:
                    System.out.print("Enter amount to withdraw from Current Account: ");
                    double curWithdraw = sc.nextDouble();
                    curAccount.withdraw(curWithdraw);
                    break;

                case 7:
                    curAccount.displayBalance();
                    break;

                case 8:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 8);

        sc.close();
    }
}
