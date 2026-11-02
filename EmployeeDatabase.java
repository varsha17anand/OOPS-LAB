import java.util.Scanner;

class Employee {
    // Instance variables: every Employee object has its own copy
    String name;
    int empId;
    String department;
    int age;
    String designation;
    double salary;

    // Constructor: runs on "new Employee(...)" and fills the fields
    Employee(String name, int empId, String department,
             int age, String designation, double salary) {
        this.name = name;
        this.empId = empId;
        this.department = department;
        this.age = age;
        this.designation = designation;
        this.salary = salary;
    }

    // Prints one employee's details
    void display() {
        System.out.println(empId + "\t" + name + "\t" + department + "\t"
                + age + "\t" + designation + "\t" + salary);
    }
}

public class EmployeeDatabase {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("How many employees (at least 5)? ");
        int n = sc.nextInt();

        // Creates n empty slots (all null)
        Employee[] emp = new Employee[n];

        // Read details and create an object for each slot
        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details of employee " + (i + 1));
            System.out.print("Name: ");
            String name = sc.next();
            System.out.print("Employee ID: ");
            int id = sc.nextInt();
            System.out.print("Department: ");
            String dept = sc.next();
            System.out.print("Age: ");
            int age = sc.nextInt();
            System.out.print("Designation: ");
            String desig = sc.next();
            System.out.print("Salary: ");
            double sal = sc.nextDouble();

            emp[i] = new Employee(name, id, dept, age, desig, sal);
        }

        // Task 1: Display all employees
        System.out.println("\nID\tName\tDept\tAge\tDesig\tSalary");
        for (int i = 0; i < n; i++) {
            emp[i].display();
        }

        // Task 2: Total salary of Sales department (running sum)
        double salesTotal = 0;
        for (int i = 0; i < n; i++) {
            if (emp[i].department.equals("Sales")) {
                salesTotal = salesTotal + emp[i].salary;
            }
        }
        System.out.println("\nTotal salary of Sales department = " + salesTotal);

        // Task 3: Highest paid manager in Purchase department (running maximum)
        Employee best = null;
        for (int i = 0; i < n; i++) {
            if (emp[i].department.equals("Purchase")
                    && emp[i].designation.equals("Manager")) {
                if (best == null || emp[i].salary > best.salary) {
                    best = emp[i];
                }
            }
        }

        if (best == null) {
            System.out.println("No manager found in Purchase department.");
        } else {
            System.out.println("Highest paid Purchase manager:");
            best.display();
        }

        sc.close();
    }
}