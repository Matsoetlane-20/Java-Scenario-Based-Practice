import java.util.Scanner;

public class FitZone {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        String anotherCustomer;

        do {
            System.out.println("===== FITZONE GYM =====");
            System.out.println("1. Standard - M450");
            System.out.println("2. Premium - M700");

            System.out.print("Choose membership type: ");
            int membershipType = input.nextInt();

            double monthlyPrice;

            if (membershipType == 1) {
                monthlyPrice = 450.00;
            } else if (membershipType == 2) {
                monthlyPrice = 700.00;
            } else {
                System.out.println("Invalid membership type.");
                continue;
            }

            System.out.print("Are you a student? (yes/no): ");
            String studentStatus = input.next();

            if (studentStatus.equalsIgnoreCase("yes")) {
                monthlyPrice = monthlyPrice - (monthlyPrice * 0.15);
            }

            System.out.print("Enter contract length in months: ");
            int contractLength = input.nextInt();

            if (contractLength == 12) {
                monthlyPrice = monthlyPrice - 5;
            }

            double totalPrice = monthlyPrice * contractLength;

            System.out.println();
            System.out.println("===== MEMBERSHIP QUOTATION =====");
            System.out.printf("Monthly price: M%.2f%n", monthlyPrice);
            System.out.printf("Contract length: %d months%n", contractLength);
            System.out.printf("Total price: M%.2f%n", totalPrice);
            System.out.println("================================");

            System.out.print("Do you want to enter another customer? (yes/no): ");
            anotherCustomer = input.next();

            System.out.println();

        } while (anotherCustomer.equalsIgnoreCase("yes"));

        System.out.println("Thank you for using FitZone Gym.");

        input.close();
    }
}
