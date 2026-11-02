import java.util.Scanner;

class Student {
    // STATIC counter: ONE copy shared by ALL students
    static int count = 0;

    // Instance variables: each student has their own copy
    String name;
    int m1, m2, m3;

    // Constructor: runs when a student is created (= student enrolls)
    Student(String name, int m1, int m2, int m3) {
        this.name = name;
        this.m1 = m1;
        this.m2 = m2;
        this.m3 = m3;
        count++;                       // every new student increases the shared counter
    }

    // STATIC METHOD: called with the class name, no object needed
    static void showTotal() {
        System.out.println("Total enrolled students = " + count);
    }

    // NON-STATIC method: needs an object because it uses that student's marks
    // Average of best two = (sum of all three - smallest) / 2
    void displayAverage() {
        int smallest = m1;
        if (m2 < smallest) {
            smallest = m2;
        }
        if (m3 < smallest) {
            smallest = m3;
        }

        double avg = (m1 + m2 + m3 - smallest) / 2.0;   // 2.0 gives a decimal result
        System.out.println(name + " -> average of best two marks = " + avg);
    }
}

public class UniversityEnrollment {

    // STATIC BLOCK: runs once, automatically, when this class is loaded.
    // This happens BEFORE main() starts, so the welcome message prints first.
    static {
        System.out.println("*** Welcome to the University Enrollment System ***");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("How many students to enroll? ");
        int n = sc.nextInt();

        Student[] st = new Student[n];      // n empty slots

        // Read details and create a Student object for each slot
        for (int i = 0; i < n; i++) {
            System.out.print("Name of student " + (i + 1) + ": ");
            String name = sc.next();
            System.out.print("Enter 3 test marks: ");
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            st[i] = new Student(name, a, b, c);
        }

        System.out.println();
        for (int i = 0; i < n; i++) {
            st[i].displayAverage();         // non-static: called on an object
        }

        Student.showTotal();                // static: called on the class
        sc.close();
    }
}