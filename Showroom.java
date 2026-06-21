import java.util.Scanner;

public class Showroom {
    public static void checkDouble(Scanner scanner) {
        while (!scanner.hasNextDouble()) {
            System.err.println("ERR: This field only accpets numbers. Please try again.");
            scanner.next();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double discount;
        
        System.out.println("Enter the total amount:");
        System.out.print("> ");
        checkDouble(scanner);
        double amount = scanner.nextDouble();

        if (amount <= 0) {
            System.err.println("ERR: Amount can't neither be equal to 0 nor be negative.");
            return;
        }

        if (amount <= 2000) {
            discount = amount * 5 / 100;
            amount -= discount;

            System.out.println("The total amount after discount is " + amount);
            System.out.println("You also get a free Calculator!");
        }
        else if (amount >= 2001 && amount <= 5000) {
            discount = amount * 10 / 100;
            amount -= discount;

            System.out.println("The total amount after discount is " + amount);
            System.out.println("You also get a free School Bag!");
        }
        else if (amount >= 5001 && amount <= 10000) {
            discount = amount * 15 / 100;
            amount -= discount;

            System.out.println("The total amount after discount is " + amount);
            System.out.println("You also get a free Wall Clock!");
        }
        else {
            discount = amount * 20 / 100;
            amount -= discount;

            System.out.println("The total amount after discount is " + amount);
            System.out.println("You also get a free Wrist Watch!");
        }
        scanner.close();
    }
}