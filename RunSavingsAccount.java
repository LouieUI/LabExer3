import java.util.Scanner;

public class RunSavingsAccount {
    public static void main(String[] args) {
       
        Scanner sc = new Scanner(System.in);
       
        SavingsAccount savings = new SavingsAccount();
       
        System.out.print("Enter the interest rate: ");
        double interestRate = sc.nextDouble();
        SavingsAccount.setInterestRate(interestRate);
        
        System.out.print("Enter the amount to deposit: ");
        double depositAmount = sc.nextDouble();
        savings.deposit(depositAmount); 
       
        SavingsAccount.showBalance(savings);
        
        System.out.print("Press D to Deposit more, or W to Withdraw: ");
        char choice = sc.next().charAt(0);
        if (choice == 'D' || choice == 'd') {
            System.out.print("Enter the amount to deposit: ");
            double additionalDeposit = sc.nextDouble();
            savings.deposit(additionalDeposit);
        } else if (choice == 'W' || choice == 'w') {
            System.out.print("Enter the amount to withdraw: ");
            double withdrawalAmount = sc.nextDouble();
            double withdrawn = savings.withdraw(withdrawalAmount); 
            if (withdrawn == 0) {
                System.out.println("Insufficient balance.");
            } else {
                System.out.println("You withdrew: " + withdrawn);
            }
        }
      
        SavingsAccount.showBalance(savings);
       
        if (savings.getBalance() > 1000) {
            savings.addInterest();
            System.out.println("Interest applied. New balance: " + savings.getBalance());
        }
    }
}
