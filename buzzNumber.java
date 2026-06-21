import java.util.Scanner;

public class buzzNumber {

    public static void checkInt(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.err.println("ERR: This field only accepts numbers. Please try again.");
            scanner.next();
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter the number:");
        System.out.print("> ");
        checkInt(scanner);
        int n = scanner.nextInt();

        if (n % 7 == 0) {
            System.out.println(n + " is divisible by 7");
        }
        else {
            System.out.println(n + " is not divisible by 7");
        }

        int lastDigit = Math.abs(n) % 10;

        if (lastDigit == 7) {
            System.out.println(n + " also ends with 7");
        }
        else {
            System.out.println(n + " Does not end with 7");
        }
        scanner.close();
    }
}