import java.util.Scanner;

// BASE (parent) class
class Payment {
    double amount;

    Payment(double amount) {
        this.amount = amount;
    }

    // Base version: no extra charge
    double process() {
        return amount;
    }
}

// Child 1: Credit card adds a 2% service charge
class CreditCardPayment extends Payment {
    CreditCardPayment(double amount) {
        super(amount);                      // send amount to the parent constructor
    }

    // OVERRIDING
    double process() {
        return amount + amount * 0.02;
    }
}

// Child 2: UPI adds a flat Rs.5
class UPIPayment extends Payment {
    UPIPayment(double amount) {
        super(amount);
    }

    double process() {
        return amount + 5;
    }
}

// Child 3: Net banking adds a 1.5% fee
class NetBankingPayment extends Payment {
    NetBankingPayment(double amount) {
        super(amount);
    }

    double process() {
        return amount + amount * 0.015;
    }
}

public class OnlinePayment {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter payment amount: ");
        double amt = sc.nextDouble();

        System.out.println("Choose method: 1.Credit Card  2.UPI  3.Net Banking");
        int ch = sc.nextInt();

        Payment p;                          // BASE CLASS reference

        // The same reference points to a DIFFERENT child object at runtime
        if (ch == 1) {
            p = new CreditCardPayment(amt);
        } else if (ch == 2) {
            p = new UPIPayment(amt);
        } else if (ch == 3) {
            p = new NetBankingPayment(amt);
        } else {
            System.out.println("Invalid choice.");
            sc.close();
            return;                         // stop the program
        }

        // Same call, but the actual object decides which version runs
        System.out.println("Final payable amount = Rs." + p.process());

        sc.close();
    }
}