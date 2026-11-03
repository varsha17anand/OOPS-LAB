import java.util.Scanner;

class MyPoint {
    int x;    // x coordinate
    int y;    // y coordinate

    // DEFAULT constructor (no parameters): point at (0, 0)
    MyPoint() {
        x = 0;
        y = 0;
    }

    // OVERLOADED constructor: same name, different parameters
    MyPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // SETTER: sets both x and y
    void setXY(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // GETTER: returns BOTH values by packing them in an array
    int[] getXY() {
        int[] arr = new int[2];
        arr[0] = x;
        arr[1] = y;
        return arr;
    }

    // toString(): Java calls it automatically when we print the object
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    // METHOD OVERLOADING: three versions of distance()

    // 1) distance from this point to a point given as two numbers
    //    formula: sqrt( (a - x)^2 + (b - y)^2 )
    double distance(int a, int b) {
        int dx = a - x;
        int dy = b - y;
        return Math.sqrt(dx * dx + dy * dy);
    }

    // 2) distance from this point to another MyPoint object
    double distance(MyPoint another) {
        return distance(another.x, another.y);   // reuse version 1
    }

    // 3) distance from this point to the origin (0, 0)
    double distance() {
        return distance(0, 0);                   // reuse version 1
    }
}

public class TestMyPoint {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Default constructor
        MyPoint p1 = new MyPoint();
        System.out.println("p1 (default constructor) = " + p1);

        // Overloaded constructor with user values
        System.out.print("Enter x and y for p2: ");
        MyPoint p2 = new MyPoint(sc.nextInt(), sc.nextInt());
        System.out.println("p2 = " + p2);

        // setXY
        System.out.print("Enter new x and y to set in p1: ");
        p1.setXY(sc.nextInt(), sc.nextInt());
        System.out.println("p1 after setXY = " + p1);

        // getXY
        int[] arr = p1.getXY();
        System.out.println("getXY of p1: x = " + arr[0] + ", y = " + arr[1]);

        // distance(int, int)
        System.out.print("Enter x and y to find distance from p1: ");
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println("distance(" + a + "," + b + ") = " + p1.distance(a, b));

        // distance(MyPoint)
        System.out.println("distance(p2) = " + p1.distance(p2));

        // distance()
        System.out.println("distance to origin = " + p1.distance());

        sc.close();
    }
}