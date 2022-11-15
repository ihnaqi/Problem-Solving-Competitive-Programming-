import java.util.Scanner;

public class HeightOrdering {

   public static void main(String[] args) {
      Scanner input = new Scanner(System.in);

      int size = input.nextInt();
      int count = 0;

      while (count < size) {
         int[] array = new int[20];
         int serial = input.nextInt();
         int backSteps = 0;
         for (int i = 0; i < array.length; i++) {
            array[i] = input.nextInt();
            for (int j = i; j > 0; j--) {
               if (array[j - 1] > array[j]) {
                  array[j - 1] = array[j - 1] + array[j];
                  array[j] = array[j - 1] - array[j];
                  array[j - 1] = array[j - 1] - array[j];
                  backSteps++;
               } else {
                  break;
               }
            }
         }
         System.out.printf("%d %d\n", serial, backSteps);
         count++;
      }

      input.close();
   }
}