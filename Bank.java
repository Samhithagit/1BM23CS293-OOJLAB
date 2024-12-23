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
SavAcct(String customerName, String accountNumber, double initialBalance) {
        super(customerName, accountNumber, "Savings", initialBalance);
    }

    public void computeAndDepositInterest() {
        double interest = balance * interestRate*0.01;
        balance += interest;
        System.out.println("Interest added: " + interest + ". Updated balance: " + balance);
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Amount withdrawn: " + amount + ". Updated balance: " + balance);
        } else {
            System.out.println("Insufficient balance");
        }
    }
}

class CurAcct extends Account {
CurAcct(String customerName, String accountNumber, double initialBalance) {
        super(customerName, accountNumber, "Current", initialBalance);
    }

    void checkminbalance() {
        if (balance < minimumBalance) {
            balance -= serviceCharge;
            System.out.println("Balance below minimum. Service charge of " + serviceCharge + " imposed. Updated balance: " + balance);
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Amount withdrawn: " + amount + ". Updated balance: " + balance);
            checkminblance();
        } else {
            System.out.println("Insufficient balance");
        }
    }
    void isChequeBook(){
        if(chequebook==false){
            chequebook=true;
            System.out.println("Cheque Book issued");
        }
        else{
            System.out.println("Cheque book has already been issued");
        }
    }
}

class Bank {
Scanner sc = new Scanner(System.in);
public static void main(String args[]) {
Scanner sc = new Scanner(System.in);
System.out.println("Enter customer name:");
String custname = sc.nextLine();
System.out.println("Enter account number:");
String accno = sc.nextLine();
System.out.println("Enter acct type (Savings/Current):");
String acctype = sc.nextLine();
Account account;
if (acctype.equals("saving")) {
System.out.println("Enter initial balance:");
double balance = sc.nextDouble();
System.out.println("Enter interest rate:");
double interestRate = sc.nextDouble();
account = new SavAcct(custname, accno, balance, interestRate);
} else if (acctype.equals("current")) {
System.out.println("Enter initial balance:");
double balance = sc.nextDouble();
System.out.println("Enter minimum balance:");
double mbalance = sc.nextDouble();
System.out.println("Enter service charge:");
double scharge = sc.nextDouble();
account = new CurAcct(custname, accno, balance, mbalance, scharge);
}
if (acctype.equals("Savings")) {
System.out.println("1. Deposit \n 2. Withdraw \n 3. Display \n 4. Exit");
System.out.println("Enter choice:");
int ch = sc.nextInt();
switch (ch) {
case 1:
System.out.println("Enter amt:");
double amt = sc.nextDouble();
((SavAcct) account).deposit(amt);
((SavAcct) account).computeAndDepositInterest();
break;
case 2:
System.out.println("Enter amt to withdraw:");
double w = sc.nextDouble();
account.withdraw(w);
account.displayBalance();
break;
case 3:
account.displayBalance();
break;
case 4:
exit();
break;
}
} else {
while (true) {
System.out.println("1. Deposit \n 2. Withdraw \n 3. ChequeBook \n 4. Exit");
System.out.println("Enter choice:");
int ch = sc.nextInt();
switch (ch) {
case 1:
System.out.println("Enter amt:");
double amt = sc.nextDouble();
account.deposit(amt);
break;
case 2:
System.out.println("Enter amt:");
double w = sc.nextDouble();
account.withdraw(w);
break;
case 3: account.isChequeBook();
break;
case 4: exit(1);
break;
}
}
}
}
}
