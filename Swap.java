import java.util.Scanner;

public class Swap {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter the value of a:");
        System.out.print("> ");
        int a = scanner.nextInt();

        System.out.println("Enter the value of b:");
        System.out.print("> ");
        int b = scanner.nextInt();

        scanner.close();

        a = a ^ b;
        b = a ^ b;
        a = a ^ b;

        System.out.println("The value of a is " + a);
        System.out.println("The value of b is " + b);
    }
}