import java.util.Scanner;

public class Square {

    public static void checkInt(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.err.println("ERR This field only accepts numbers. Please try again.");
            scanner.next();
        }
    }

    public static void main(String[] args) {
        int a, c;
        double b;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number:");
        System.out.print("> ");
        checkInt(scanner);
        a = scanner.nextInt();

        b = Math.sqrt(a);

        c = (int) b;

        if (c * c != a) {
            System.out.println("The number is not a perfect square.");
        }
        else {
            System.out.println("The number is a perfect square");
        }

        scanner.close();
    }
}