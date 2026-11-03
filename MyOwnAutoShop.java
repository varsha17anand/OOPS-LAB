import java.util.Scanner;

// SUPERCLASS (parent)
class Car {
    int speed;
    double regularPrice;
    String color;

    // Parent constructor
    Car(int speed, double regularPrice, String color) {
        this.speed = speed;
        this.regularPrice = regularPrice;
        this.color = color;
    }

    // In Car, the sale price is just the regular price (no discount)
    double getSalePrice() {
        return regularPrice;
    }
}

// SUBCLASS 1
class Truck extends Car {
    int weight;

    Truck(int speed, double regularPrice, String color, int weight) {
        super(speed, regularPrice, color);   // call the PARENT constructor first
        this.weight = weight;
    }

    // OVERRIDING: same method name and parameters as the parent
    double getSalePrice() {
        if (weight > 2000) {
            return regularPrice - regularPrice * 0.10;   // 10% discount
        } else {
            return regularPrice - regularPrice * 0.20;   // 20% discount
        }
    }
}

// SUBCLASS 2
class Ford extends Car {
    int year;
    int manufacturerDiscount;

    Ford(int speed, double regularPrice, String color,
         int year, int manufacturerDiscount) {
        super(speed, regularPrice, color);
        this.year = year;
        this.manufacturerDiscount = manufacturerDiscount;
    }

    double getSalePrice() {
        // super.getSalePrice() = the price calculated by the Car class
        return super.getSalePrice() - manufacturerDiscount;
    }
}

// SUBCLASS 3
class Sedan extends Car {
    int length;

    Sedan(int speed, double regularPrice, String color, int length) {
        super(speed, regularPrice, color);
        this.length = length;
    }

    double getSalePrice() {
        if (length > 20) {
            return regularPrice - regularPrice * 0.05;   // 5% discount
        } else {
            return regularPrice - regularPrice * 0.10;   // 10% discount
        }
    }
}

public class MyOwnAutoShop {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("--- Sedan details ---");
        System.out.print("Speed, regular price, color, length(feet): ");
        Sedan s = new Sedan(sc.nextInt(), sc.nextDouble(), sc.next(), sc.nextInt());

        System.out.println("--- Ford details ---");
        System.out.print("Speed, regular price, color, year, manufacturer discount: ");
        Ford f = new Ford(sc.nextInt(), sc.nextDouble(), sc.next(),
                          sc.nextInt(), sc.nextInt());

        System.out.println("--- Car details ---");
        System.out.print("Speed, regular price, color: ");
        Car c = new Car(sc.nextInt(), sc.nextDouble(), sc.next());

        System.out.println("--- Truck details ---");
        System.out.print("Speed, regular price, color, weight: ");
        Truck t = new Truck(sc.nextInt(), sc.nextDouble(), sc.next(), sc.nextInt());

        System.out.println("\nSedan sale price = " + s.getSalePrice());
        System.out.println("Ford  sale price = " + f.getSalePrice());
        System.out.println("Car   sale price = " + c.getSalePrice());
        System.out.println("Truck sale price = " + t.getSalePrice());

        sc.close();
    }
}