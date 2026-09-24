import java.util.ArrayList;

public class QuickMart {

    public static void main(String[] args) {

        ArrayList<Product> products = new ArrayList<>();

        products.add(new Product("Milk", 4, 10));
        products.add(new Product("Bread", 15, 8));
        products.add(new Product("Rice", 6, 10));
        products.add(new Product("Sugar", 20, 10));
        products.add(new Product("Eggs", 5, 12));

        int reorderCount = 0;

        System.out.println("===== QUICKMART STOCK REPORT =====");

        for (Product product : products) {

            System.out.printf("%-10s Stock: %2d  Threshold: %2d",
                    product.getName(),
                    product.getQuantity(),
                    product.getReorderThreshold());

            if (product.getQuantity() < product.getReorderThreshold()) {
                System.out.println("  REORDER");
                reorderCount++;
            } else {
                System.out.println("  OK");
            }
        }

        System.out.println("==================================");
        System.out.println("Products needing reorder: " + reorderCount);
    }
}
