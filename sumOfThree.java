import java.util.Scanner;

public class sumOfThree {

    public static void checkInt(Scanner scanner) {
        System.err.println("ERR: This field only accpets numbers. Please try again");
        scanner.next();
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

        int lastDigitA = Math.abs(a) % 10;
        int lastDigitB = Math.abs(b) % 10;
        int lastDigitC = Math.abs(c) % 10;

        int sumOfThree = (lastDigitA + lastDigitB + lastDigitC);

        System.out.println("The sum of " + a + b + c + " is " + sumOfThree);

        scanner.close();
    }   
}