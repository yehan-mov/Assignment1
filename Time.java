import java.util.Scanner;

public class Time {

    public static void checkInt(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.println("ERR: This field only accpets numbers. Please try again.");
            scanner.next();
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the time (in seconds):");
        System.out.print("> ");
        checkInt(scanner);
        int totalSeconds = scanner.nextInt();

        int hours = totalSeconds / 3600;
        int minutes = (totalSeconds % 3600) / 60;
        int seconds = totalSeconds % 60;

        String timeString = String.format("%02d hours : %02d minutes : %02d seconds", hours, minutes, seconds);
        System.out.println(timeString);
        scanner.close();
    }
}