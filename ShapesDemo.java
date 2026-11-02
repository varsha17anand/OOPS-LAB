import java.util.Scanner;

// INTERFACE 1: only method names (a contract), no bodies
interface CircleOps {
    double circleArea();
    double circlePerimeter();
}

// INTERFACE 2
interface RectangleOps {
    double rectArea();
    double rectPerimeter();
}

// INTERFACE 3: inherits BOTH interfaces and adds one more method
interface ShapeOps extends CircleOps, RectangleOps {
    void displaySummary();
}

// BASE CLASS: common shape information
class ShapeBase {
    String name;

    ShapeBase(String name) {
        this.name = name;
    }
}

// extends = inherit from ONE class
// implements = promise to write the bodies of the interface methods
class ShapeCalculator extends ShapeBase implements ShapeOps {
    double radius, length, breadth;

    ShapeCalculator(String name, double radius, double length, double breadth) {
        super(name);                       // send name to ShapeBase
        this.radius = radius;
        this.length = length;
        this.breadth = breadth;
    }

    // Interface methods MUST be public in the implementing class
    public double circleArea() {
        return Math.PI * radius * radius;
    }

    public double circlePerimeter() {
        return 2 * Math.PI * radius;
    }

    public double rectArea() {
        return length * breadth;
    }

    public double rectPerimeter() {
        return 2 * (length + breadth);
    }

    public void displaySummary() {
        System.out.println("Summary for " + name);
        System.out.println("Circle area = " + circleArea()
                + ", perimeter = " + circlePerimeter());
        System.out.println("Rectangle area = " + rectArea()
                + ", perimeter = " + rectPerimeter());
    }
}

public class ShapesDemo {

    // Each method accepts an INTERFACE type as its parameter
    static void useCircle(CircleOps c) {
        System.out.println("[CircleOps] Area = " + c.circleArea()
                + ", Perimeter = " + c.circlePerimeter());
    }

    static void useRectangle(RectangleOps r) {
        System.out.println("[RectangleOps] Area = " + r.rectArea()
                + ", Perimeter = " + r.rectPerimeter());
    }

    static void useShape(ShapeOps s) {
        System.out.println("[ShapeOps]");
        s.displaySummary();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter shape name: ");
        String name = sc.next();
        System.out.print("Enter circle radius: ");
        double r = sc.nextDouble();
        System.out.print("Enter rectangle length and breadth: ");
        double l = sc.nextDouble();
        double b = sc.nextDouble();

        // ONE object
        ShapeCalculator sh = new ShapeCalculator(name, r, l, b);

        // The same object is passed to three methods expecting three different types
        useCircle(sh);
        useRectangle(sh);
        useShape(sh);

        sc.close();
    }
}