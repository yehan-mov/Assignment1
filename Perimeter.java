import java.util.Scanner;

public class Perimeter {

    public static void checkInt(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.err.println("ERR This field only accepts numbers. Please try again.");
            scanner.next();
        }
    }

    public static void calculateRectanglePerimeter(int l, int w) {
        int perimeterRectangle = 2 * (l + w);

        System.out.println("The perimeter of the rectangle is " + perimeterRectangle);
    }

    public static void calculateTrianglePerimeter(int a, int b, int c) {
        int perimeterTriangle = a + b + c;

        System.out.println("The perimeter of the triangle is " + perimeterTriangle);
    }

    public static void calculateSquarePerimeter(int a) {
        int perimeterSquare = 4 * a;

        System.out.println("The perimeter of the square is " + perimeterSquare);
    }

    public static int getPositiveInt(Scanner scanner) {
        checkInt(scanner);
        int value = scanner.nextInt();

        while (value <= 0) {
            System.out.println("ERR: Value must be postiive");
            System.out.print("> ");
            checkInt(scanner);
            value = scanner.nextInt();
        }

        return value;
    }

    public static void main(String[] args) {
        boolean running = true;

        Scanner scanner = new Scanner(System.in);

        while (running) {
            System.out.println("\nOf which shape do you want to find perimeter of?");
            System.out.println("[1] Rectangle");
            System.out.println("[2] Triangle");
            System.out.println("[3] Square");
            System.out.println("[0] Exit");

            System.out.println("\nPlease Select an option");
            System.out.print("> ");
            checkInt(scanner);
            int choice = scanner.nextInt();

            switch (choice) {
                case 0:
                    System.out.println("Goodbye!");
                    running = false;
                    break;

                case 1:
                    System.out.println("Enter the length of the rectangle:");
                    System.out.print("> ");
                    int length = getPositiveInt(scanner);

                    System.out.println("Enter the Width of the rectangle:");
                    System.out.print("> ");
                    int width = getPositiveInt(scanner);

                    calculateRectanglePerimeter(length, width);
                    continue;

                case 2:
                    System.out.println("Enter side a of the triangle:");
                    System.out.print("> ");
                    int sideA = getPositiveInt(scanner);

                    System.out.println("Enter side b of the triangle:");
                    System.out.print("> ");
                    int sideB = getPositiveInt(scanner);

                    System.out.println("Enter side c of the triangle:");
                    System.out.print("> ");
                    int sideC = getPositiveInt(scanner);

                    if (sideA + sideB <= sideC || sideA + sideC <= sideB || sideB + sideC <= sideA) {
                        System.out.println("ERR: Invalid Triangle");
                        return;
                    }

                    calculateTrianglePerimeter(sideA, sideB, sideC);
                    continue;

                case 3:
                    System.out.println("Enter the side of the square:");
                    System.out.print("> ");
                    int side = getPositiveInt(scanner);

                    calculateSquarePerimeter(side);
                    continue;

                default:
                    System.err.println("ERR: Invalid option selected. Please try again.");
                    continue;
            }
        }
        scanner.close();
    }
}