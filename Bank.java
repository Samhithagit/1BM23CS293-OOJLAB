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
    double interestRate;

    SavAcct(String customerName, String accountNumber, double initialBalance, double interestRate) {
        super(customerName, accountNumber, "Savings", initialBalance);
        this.interestRate = interestRate;
    }

    public void computeAndDepositInterest() {
        double interest = balance * interestRate / 100;
        balance += interest;
        System.out.println("Interest added: " + interest + ". Updated balance: " + balance);
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Amount withdrawn: " + amount + ". Updated balance: " + balance);
        } else {
            System.out.println("Insufficient balance.");
        }
    }
}

class CurAcct extends Account {
    double minimumBalance;
    double serviceCharge;
    boolean chequebookIssued = false;

    CurAcct(String customerName, String accountNumber, double initialBalance, double minimumBalance, double serviceCharge) {
        super(customerName, accountNumber, "Current", initialBalance);
        this.minimumBalance = minimumBalance;
        this.serviceCharge = serviceCharge;
    }

    void checkMinBalance() {
        if (balance < minimumBalance) {
            balance -= serviceCharge;
            System.out.println("Balance below minimum. Service charge of " + serviceCharge + " imposed. Updated balance: " + balance);
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Amount withdrawn: " + amount + ". Updated balance: " + balance);
            checkMinBalance();
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    public void issueChequeBook() {
        if (!chequebookIssued) {
            chequebookIssued = true;
            System.out.println("Cheque book issued.");
        } else {
            System.out.println("Cheque book has already been issued.");
        }
    }
}

class Bank {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter customer name:");
        String custName = sc.nextLine();
        System.out.println("Enter account number:");
        String accNo = sc.nextLine();
        System.out.println("Enter account type (Savings/Current):");
        String accType = sc.nextLine();

        Account account;

        if (accType.equalsIgnoreCase("Savings")) {
            System.out.println("Enter initial balance:");
            double balance = sc.nextDouble();
            System.out.println("Enter interest rate:");
            double interestRate = sc.nextDouble();
            account = new SavAcct(custName, accNo, balance, interestRate);

            while (true) {
                System.out.println("\n1. Deposit\n2. Withdraw\n3. Compute Interest\n4. Display Balance\n5. Exit");
                System.out.print("Enter choice: ");
                int choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        System.out.print("Enter amount to deposit: ");
                        double depositAmount = sc.nextDouble();
                        account.deposit(depositAmount);
                        break;
                    case 2:
                        System.out.print("Enter amount to withdraw: ");
                        double withdrawAmount = sc.nextDouble();
                        ((SavAcct) account).withdraw(withdrawAmount);
                        break;
                    case 3:
                        ((SavAcct) account).computeAndDepositInterest();
                        break;
                    case 4:
                        account.displayBalance();
                        break;
                    case 5:
                        System.out.println("Exiting Savings Account menu...");
                        return;
                    default:
                        System.out.println("Invalid choice. Try again.");
                }
            }
        } else if (accType.equalsIgnoreCase("Current")) {
            System.out.println("Enter initial balance:");
            double balance = sc.nextDouble();
            System.out.println("Enter minimum balance:");
            double minBalance = sc.nextDouble();
            System.out.println("Enter service charge:");
            double serviceCharge = sc.nextDouble();
            account = new CurAcct(custName, accNo, balance, minBalance, serviceCharge);

            while (true) {
                System.out.println("\n1. Deposit\n2. Withdraw\n3. Issue Cheque Book\n4. Display Balance\n5. Exit");
                System.out.print("Enter choice: ");
                int choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        System.out.print("Enter amount to deposit: ");
                        double depositAmount = sc.nextDouble();
                        account.deposit(depositAmount);
                        break;
                    case 2:
                        System.out.print("Enter amount to withdraw: ");
                        double withdrawAmount = sc.nextDouble();
                        ((CurAcct) account).withdraw(withdrawAmount);
                        break;
                    case 3:
                        ((CurAcct) account).issueChequeBook();
                        break;
                    case 4:
                        account.displayBalance();
                        break;
                    case 5:
                        System.out.println("Exiting Current Account menu...");
                        return;
                    default:
                        System.out.println("Invalid choice. Try again.");
                }
            }
        } else {
            System.out.println("Invalid account type. Exiting...");
        }

        sc.close();
    }
}

