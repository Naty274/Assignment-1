import java.util.Scanner;

public class SmartRestaurantOrder {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        final double DRINK_PRICE = 15.50;
        final double STUDENT_DISCOUNT = 0.10;
        final double SENIOR_DISCOUNT = 0.05;
        final double TIP_RATE = 0.10;

        String customerName;
        int age;
        double mealPrice;
        int numberOfDrinks;
        boolean isStudent;
        int serviceRating;

        double drinksCost;
        double subtotal;
        double discountRate = 0.0;
        double discountAmount;
        double amountAfterDiscount;
        double tipAmount = 0.0;
        double finalBill;
        int wholeAmount;

        System.out.println("=== SMART RESTAURANT ORDER ===");

        System.out.print("Enter customer's name: ");
        customerName = input.nextLine();

        System.out.print("Enter customer's age: ");
        age = input.nextInt();

        System.out.print("Enter meal price: $");
        mealPrice = input.nextDouble();

        System.out.print("Enter number of drinks: ");
        numberOfDrinks = input.nextInt();

        System.out.print("Is the customer a student? (true/false): ");
        isStudent = input.nextBoolean();

        System.out.print("Enter service rating (1 to 5): ");
        serviceRating = input.nextInt();

        if (serviceRating < 1 || serviceRating > 5) {
            System.out.println("Error: service rating must be between 1 and 5.");
        } else {
            drinksCost = numberOfDrinks * DRINK_PRICE;
            subtotal = mealPrice + drinksCost;

            // Apply only one discount. The student discount is the larger one.
            if (isStudent && age >= 60) {
                discountRate = STUDENT_DISCOUNT;
            } else if (isStudent) {
                discountRate = STUDENT_DISCOUNT;
            } else if (age >= 60) {
                discountRate = SENIOR_DISCOUNT;
            } else {
                discountRate = 0.0;
            }

            discountAmount = subtotal * discountRate;
            amountAfterDiscount = subtotal - discountAmount;

            if (serviceRating == 4 || serviceRating == 5) {
                // The tip is calculated after the discount.
                tipAmount = amountAfterDiscount * TIP_RATE;
            } else {
                tipAmount = 0.0;
            }

            finalBill = amountAfterDiscount + tipAmount;
            wholeAmount = (int) finalBill;

            System.out.println();
            System.out.println("========== SMART RESTAURANT ==========");
            System.out.println("Customer: " + customerName);
            System.out.printf("Meal cost:       $%.2f%n", mealPrice);
            System.out.printf("Drinks cost:     $%.2f%n", drinksCost);
            System.out.printf("Discount:        $%.2f%n", discountAmount);
            System.out.printf("Tip:             $%.2f%n", tipAmount);
            System.out.printf("Final bill:      $%.2f%n", finalBill);
            System.out.println("Whole amount:    $" + wholeAmount);
            System.out.println("======================================");
        }

        input.close();
    }
}
