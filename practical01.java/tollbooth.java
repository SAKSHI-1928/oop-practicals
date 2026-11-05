
import java.util.Scanner;

record Vehicle(String number, String type) {}

public class TollBooth {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int total = 0;
        int bike = 0;
        int car = 0;
        int truck = 0;

        while (true) {
            System.out.print("Enter vehicle number (or done): ");
            String number = sc.next();

            if (number.equalsIgnoreCase("done")) {
                break;
            }

            System.out.print("Enter vehicle type (bike/car/truck): ");
            String type = sc.next().toLowerCase();

            Vehicle v = new Vehicle(number, type);

            int toll = switch (v.type()) {
                case "bike" -> 20;
                case "car" -> 50;
                case "truck" -> 150;
                default -> {
                    System.out.println("Invalid vehicle type!");
                    yield 0;
                }
            };

            if (toll == 0) {
                continue;
            }

            total += toll;

            switch (v.type()) {
                case "bike" -> bike++;
                case "car" -> car++;
                case "truck" -> truck++;
            }

            System.out.println("Toll: " + toll);
        }

        System.out.println("Total toll: " + total);

        String frequent = "bike";
        int highest = bike;

        if (car > highest) {
            highest = car;
            frequent = "car";
        }

        if (truck > highest) {
            frequent = "truck";
        }

        if (bike + car + truck == 0) {
            frequent = "none";
        }

        System.out.println("Most frequent: " + frequent);

        sc.close();
    }
}
