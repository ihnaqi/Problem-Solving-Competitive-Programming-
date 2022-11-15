import java.util.Scanner;

public class BubbleTea {

   public static void main(String[] args) {

      Scanner input = new Scanner(System.in);
      System.out.print("Enter amount of tea: ");
      int teaAmount = input.nextInt();
      int[] teaPriceArray = new int[teaAmount];

      for (int i = 0; i < teaPriceArray.length; i++) {
         System.out.printf("Enter price %d of tea: ", (i + 1));
         teaPriceArray[i] = input.nextInt();
      }

      System.out.print("Enter topping amount available: ");
      int toppingAmont = input.nextInt();
      int[] toppingArray = new int[toppingAmont];

      for (int i = 0; i < toppingAmont; i++) {
         System.out.printf("Enter price of %d topping:", (i + 1));
         toppingArray[i] = input.nextInt();
      }

      int[][] pirceArray = new int[teaPriceArray.length][toppingArray.length];

      for (int i = 0; i < teaPriceArray.length; i++) { // 2 [4 5]
         System.out.print("Enter number of allowed toppings: "); // 3 [1 2 3]
         int allowed = input.nextInt(); // 5 [1 2 3 4 5]

         while (allowed > 0) {
            System.out.print("Enter topping index: ");
            int index = input.nextInt();
            index = index - 1;
            pirceArray[i][index] = toppingArray[index];

            allowed--;
         }
      }

      System.out.print("Enter total amount: ");
      int totalAmout = input.nextInt();

      int max = Integer.MIN_VALUE;

      for (int i = 0; i < pirceArray.length; i++) {
         for (int j = 0; j < pirceArray[i].length; j++) {
            if (pirceArray[i][j] > 0) {
               if ((totalAmout / (toppingArray[pirceArray[i][j] - 1] * teaPriceArray[i])) > max) {
                  max = totalAmout / (toppingArray[pirceArray[i][j] - 1] * teaPriceArray[i]);
               }
            }
         }
      }

      System.out.printf("%d", max);
      input.close();
   }
}