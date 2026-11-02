import java.util.Scanner;

// Stack follows LIFO = Last In, First Out
class Stack {
    static final int MAX = 10;     // maximum size is 10, as given in the question
    int[] data = new int[MAX];     // array to store the elements
    int top = -1;                  // -1 means the stack is empty

    boolean isEmpty() {
        return top == -1;
    }

    boolean isFull() {
        return top == MAX - 1;
    }

    // PUSH: add a value on top
    void push(int value) {
        if (isFull()) {
            System.out.println("Stack Overflow! Cannot push " + value);
        } else {
            top++;                 // move top up
            data[top] = value;     // store the value
            System.out.println(value + " pushed.");
        }
    }

    // POP: remove the top value
    void pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow! Nothing to pop.");
        } else {
            System.out.println(data[top] + " popped.");
            top--;                 // move top down
        }
    }

    // DISPLAY: print from top to bottom
    void display() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
        } else {
            System.out.println("Stack (top to bottom):");
            for (int i = top; i >= 0; i--) {
                System.out.println(data[i]);
            }
        }
    }
}

public class StackDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack s = new Stack();     // object of the Stack class
        int choice;

        do {
            System.out.println("\n1.Push  2.Pop  3.Display  4.Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter value: ");
                    s.push(sc.nextInt());
                    break;
                case 2:
                    s.pop();
                    break;
                case 3:
                    s.display();
                    break;
                case 4:
                    System.out.println("Bye!");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 4);

        sc.close();
    }
}