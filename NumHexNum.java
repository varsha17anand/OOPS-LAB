import java.util.Scanner;

// BASE (parent) class
class Num {
    int number;

    Num(int number) {
        this.number = number;
    }

    // Displays the number in decimal
    void shownum() {
        System.out.println("Number = " + number);
    }
}

// DERIVED (child) class
class HexNum extends Num {

    HexNum(int number) {
        super(number);               // pass the number to the parent constructor
    }

    // OVERRIDING: same name and parameters as the parent's shownum()
    // Converts to hexadecimal manually (repeated division by 16)
    void shownum() {
        String digits = "0123456789abcdef";   // position in this String = digit value
        String result = "";                   // hex answer is built here
        int temp = number;                    // copy, so the original number is not changed

        if (temp == 0) {
            result = "0";                     // special case: loop below would skip 0
        }

        while (temp > 0) {
            int rem = temp % 16;                      // last hex digit (0 to 15)
            result = digits.charAt(rem) + result;     // add it at the FRONT
            temp = temp / 16;                         // remove that digit
        }

        System.out.println("Hexadecimal value = " + result);
    }
}

public class NumHexNum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int n = sc.nextInt();

        Num a = new Num(n);          // parent object
        HexNum h = new HexNum(n);    // child object

        a.shownum();                 // parent's version
        h.shownum();                 // child's overridden version

        sc.close();
    }
}