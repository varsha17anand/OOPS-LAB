import java.util.Scanner;

public class StringCompare {

    // VERSION 1: compare the WHOLE strings (2 parameters)
    // Returns 0 if equal, positive if s1 is greater, negative if s1 is smaller
    static int usrstrcmp(String s1, String s2) {
        int i = 0;

        // go on while BOTH strings still have characters
        while (i < s1.length() && i < s2.length()) {
            if (s1.charAt(i) != s2.charAt(i)) {
                return s1.charAt(i) - s2.charAt(i);   // first difference found
            }
            i++;
        }

        // all common characters matched: the longer string is greater
        // (gives 0 when both have the same length)
        return s1.length() - s2.length();
    }

    // VERSION 2: compare only the first n characters (3 parameters)
    static int usrstrcmp(String s1, String s2, int n) {
        int i = 0;

        // same loop, but it also stops after n characters
        while (i < n && i < s1.length() && i < s2.length()) {
            if (s1.charAt(i) != s2.charAt(i)) {
                return s1.charAt(i) - s2.charAt(i);
            }
            i++;
        }

        // loop stopped because i reached n -> first n characters matched
        if (i == n) {
            return 0;
        }

        // otherwise one string ended before n characters
        return s1.length() - s2.length();
    }

    // Prints a readable message from the returned number
    static void show(int r) {
        if (r == 0) {
            System.out.println("Result: Strings are EQUAL");
        } else if (r > 0) {
            System.out.println("Result: First string is GREATER (" + r + ")");
        } else {
            System.out.println("Result: First string is SMALLER (" + r + ")");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first string: ");
        String a = sc.next();
        System.out.print("Enter second string: ");
        String b = sc.next();
        System.out.print("How many characters to compare in version 2? ");
        int n = sc.nextInt();

        System.out.println("\nVersion 1 (full comparison):");
        show(usrstrcmp(a, b));            // 2 arguments -> version 1

        System.out.println("\nVersion 2 (first " + n + " characters):");
        show(usrstrcmp(a, b, n));         // 3 arguments -> version 2

        sc.close();
    }
}