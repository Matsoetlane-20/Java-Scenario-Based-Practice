import java .util.Scanner;
public classs CornerBakery
  {
       public static void main(String[] args)
    {  Scanner input = ne w Scanner(System.in);
       double cupcakePrice = 2.50;
       double cakePrice = 18.00;
         
       System.out.print("Enter number of cupcakes: ");
       int cupcakeQuantity = input.nextInt();

        System.out.print("Enter number of cakes: ");
        int cakeQuantity = input.nextInt();

        double cupcakeTotal = cupcakePrice * cupcakeQuantity;

        double discount = 0;
        
        if(cupcakeQuantity >= 6)
        { discount = cupcakeTotal * 0.10;}
         
        double discountedCupcakeTotal = cupcakeTotal - discount;
        double cakeTotal = cakePrice * cakeQuantity;
        double grandTotal = discountedCupcakeTotal + cakeTotal;

        
        System.out.println();
        System.out.println("===== CORNER BAKERY RECEIPT =====");

        System.out.printf("Cupcakes: %d x M%.2f = M%.2f%n",
                cupcakeQuantity, cupcakePrice, cupcakeTotal);

        System.out.printf("Discount: M%.2f%n", discount);

        System.out.printf("Cakes: %d x M%.2f = M%.2f%n",
                cakeQuantity, cakePrice, cakeTotal);

        System.out.printf("Grand Total: M%.2f%n", grandTotal);

        System.out.println("=================================");

        input.close();
    }
}
  
