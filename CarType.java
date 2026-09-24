import java.util.Scanner;

public class DriveEasy {

    public static double getDailyRate(CarType carType) {

        switch (carType) {
            case ECONOMY:
                return 400.00;

            case SUV:
                return 650.00;

            case LUXURY:
                return 950.00;

            default:
                throw new IllegalArgumentException("Car type is not available.");
        }
    }

    public static double calculateCost(CarType carType, int days)
            throws InvalidRentalException {

        if (days <= 0) {
            throw new InvalidRentalException(
                    "Rental period must be greater than zero."
            );
        }

        double dailyRate = getDailyRate(carType);
        double total = dailyRate * days;

        if (days >= 7) {
            total = total - (total * 0.10);
        }

        return total;
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        try {

            System.out.println("===== DRIVE EASY CAR RENTAL =====");
            System.out.println("1. Economy - M400/day");
            System.out.println("2. SUV - M650/day");
            System.out.println("3. Luxury - M950/day");

            System.out.print("Choose car type: ");
            int choice = input.nextInt();

            CarType carType;

            switch (choice) {
                case 1:
                    carType = CarType.ECONOMY;
                    break;

                case 2:
                    carType = CarType.SUV;
                    break;

                case 3:
                    carType = CarType.LUXURY;
                    break;

                default:
                    throw new IllegalArgumentException(
                            "Invalid car type. Please choose 1, 2, or 3."
                    );
            }

            System.out.print("Enter number of rental days: ");
            int days = input.nextInt();

            double total = calculateCost(carType, days);

            System.out.println();
            System.out.println("===== RENTAL SUMMARY =====");
            System.out.println("Car type: " + carType);
            System.out.println("Rental days: " + days);
            System.out.printf("Total cost: M%.2f%n", total);
            System.out.println("==========================");

        } catch (InvalidRentalException e) {

            System.out.println("Rental error: " + e.getMessage());

        } catch (IllegalArgumentException e) {

            System.out.println("Input error: " + e.getMessage());

        } finally {

            input.close();
        }
    }
}
