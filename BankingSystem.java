import java.util.ArrayList;
import java.util.Scanner;

class Account
{
    private int accountNumber;
    private String accountHolder;
    private double balance;
//hello world
    //fhfj
    public Account(int accountNumber, String accountHolder, double initialBalance) 
    {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = initialBalance;
    }

    public int getAccountNumber() 
    {
        return accountNumber;
    }

    public String getAccountHolder()
    {
        return accountHolder;
    }

    public double getBalance() 
    {
        return balance;
    }

    public void deposit(double amount) 
    {
        balance += amount;
    }

    public void withdraw(double amount)
    {
        if (amount <= balance) 
        {
            balance -= amount;
        } else 
        {
            System.out.println("Insufficient funds.");
        }
    }
}

class Bank 
{
    private ArrayList<Account> accounts;

    public Bank() 
    {
        accounts = new ArrayList<>();
    }

    public void addAccount(Account account)
    {
        accounts.add(account);
    }

    public Account findAccount(int accountNumber)
    {
        for (Account account : accounts) 
        {
            if (account.getAccountNumber() == accountNumber) 
            {
                return account;
            }
        }
        return null;
    }
}

public class BankingSystem 
{
    public static void main(String[] args)
    {
        Bank bank = new Bank();
        Scanner scanner = new Scanner(System.in);

        while (true) 
        {
            System.out.println("Banking System Menu:");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Check Balance");
            System.out.println("5. Exit");
    
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) 
            {
                case 1:
                    System.out.print("Enter Account Number: ");
                    int accountNumber = scanner.nextInt();
                    scanner.nextLine(); 
                    
                    System.out.print("Enter Account Holder Name: ");
                    String accountHolder = scanner.nextLine();
                    System.out.print("Enter Initial Balance: ");
                    double initialBalance = scanner.nextDouble();
                    scanner.nextLine(); 
                    
                    Account account = new Account(accountNumber, accountHolder, initialBalance);
                    bank.addAccount(account);
                    break;
                case 2:
                    System.out.print("Enter Account Number: ");
                    int depositAccountNumber = scanner.nextInt();
                    scanner.nextLine(); 
                    
                    Account depositAccount = bank.findAccount(depositAccountNumber);
                    if (depositAccount != null) 
                    {
                        System.out.print("Enter Deposit Amount: ");
                        double depositAmount = scanner.nextDouble();
                        
                        depositAccount.deposit(depositAmount);
                    } else
                    {
                        System.out.println("Account not found.");
                    }
                    break;
                case 3:
                    System.out.print("Enter Account Number: ");
                    int withdrawAccountNumber = scanner.nextInt();
                    scanner.nextLine(); 
                    
                    Account withdrawAccount = bank.findAccount(withdrawAccountNumber);
                    if (withdrawAccount != null) 
                    {
                        System.out.print("Enter Withdraw Amount: ");
                        double withdrawAmount = scanner.nextDouble();
                        
                        withdrawAccount.withdraw(withdrawAmount);
                    } else 
                    {
                        System.out.println("Account not found.");
                    }
                    break;
                    case 4:
                    System.out.print("Enter Account Number: ");
                    int balanceAccountNumber = scanner.nextInt();
                    scanner.nextLine();
                    Account balanceAccount = bank.findAccount(balanceAccountNumber);
                    if (balanceAccount != null) {
                        System.out.println("Balance: " + balanceAccount.getBalance());
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;
                    case 5:
                    System.out.println("Exiting Banking System.");
                    scanner.close();
                    System.exit(0);

                
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
