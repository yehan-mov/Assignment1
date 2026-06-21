import java.util.Scanner;;

public class Temperature {
    
    public static void checkInt(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.err.println("ERR This field only accepts numbers. Please try again.");
            scanner.next();
        }
    }

    public static void checkDouble(Scanner scanner) {
        while (!scanner.hasNextDouble()) {
            System.err.println("ERR: This field only accpets numbers. Please try again.");
            scanner.next();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        double c, f;

        while (running) {
            System.out.println("\n--- Main Menu ---");
            System.out.println("[1] Convert from Fahrenheit to Celcius");
            System.out.println("[2] Convert from Celcius to Fahrenheit");
            System.out.println("[0] Exit");

            System.out.println("\nPlease select an option");
            System.out.print("> ");
            checkInt(scanner);
            int choice = scanner.nextInt();

            switch (choice) {
                case 0:
                    System.out.println("See you soon!");
                    running = false;
                    break;
                case 1:
                    System.out.println("Enter the Fahrenheit value:");
                    System.out.print("> ");
                    checkDouble(scanner);
                    f = scanner.nextDouble();

                    c = (f - 32) * 5/9;

                    System.out.println(f + " Fahrenheit is " + c + " Celsius");
                    continue;

                case 2:
                    System.out.println("Enter the Celsius value:");
                    System.out.print("> ");
                    checkDouble(scanner);
                    c = scanner.nextDouble();

                    f = (c * 9/5) + 32;

                    System.out.println(c + " Celsius is " + f + " Fahrenheit");
                    continue;
                    
                default:
                    System.err.println("ERR: Invalid option selected. Please try again.");
                    continue;
            }
        }
        scanner.close();
    }
}