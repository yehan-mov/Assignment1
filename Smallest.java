import java.util.Scanner;

public class Smallest {

    public static void checkInt(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.err.println("ERR This field only accepts numbers. Please try again.");
            scanner.next();
        }
    }

    public static void findMin(int a, int b, int c) {
        int smallestNumber = Math.min(a, Math.min(b, c));

        System.out.println("The smallest of the three is " + smallestNumber);
    }

    public static void main(String[] args) {
        int a, b, c;
        
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter first number:");
        System.out.print("> ");
        checkInt(scanner);
        a = scanner.nextInt();

        System.out.println("Enter second number:");
        System.out.print("> ");
        checkInt(scanner);
        b = scanner.nextInt();

        System.out.println("Enter third number:");
        System.out.print("> ");
        checkInt(scanner);
        c = scanner.nextInt();

        findMin(a, b, c);

        scanner.close();
    }
}