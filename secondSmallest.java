import java.util.Scanner;

public class secondSmallest {

    public static void checkInt(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.err.println("ERR: This field only accepts numbers. Please try again.");
            scanner.next();
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter first number:");
        System.out.print("> ");
        checkInt(scanner);
        int a = scanner.nextInt();

        System.out.println("Enter second number:");
        System.out.print("> ");
        checkInt(scanner);
        int b = scanner.nextInt();

        System.out.println("Enter third number:");
        System.out.print("> ");
        checkInt(scanner);
        int c = scanner.nextInt();

        if (a == b || b == c || c == a) {
            System.err.println("The numbers can't be equal");
        }

        int min = Math.min(a, Math.min(b, c));
        int max = Math.max(a, Math.max(b, c));

        int secondSmallest = (a + b + c) - min - max;

        System.out.println("The secondsmallest is: " + secondSmallest);

        scanner.close();
    }   
}