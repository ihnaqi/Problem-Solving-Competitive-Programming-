import java.util.Arrays;
import java.util.Scanner;

public class BusNumbers {

   public static void main(String[] args) {
      Scanner input = new Scanner(System.in);

      int num = input.nextInt();

      int[] array = new int[num];
      for (int i = 0; i < array.length; i++) {
         array[i] = input.nextInt();
      }

      Arrays.sort(array);
      String outPut = "";

      int count = 1;

      int i = 0;
      while (i < array.length) {
         int j = i + 1;
         while (j < array.length && array[j] - 1 == array[j - 1]) {
            count++;
            j++;
         }

         if (count > 2) {
            outPut += array[i] + "-" + array[j - 1] + " ";
            i = j;
            count = 1;
         } else if (count < 2) {
            outPut += array[i] + " ";
            i++;
         } else {
            outPut += array[i] + " " + array[j - 1] + " ";
            i = j;
            count = 1;
         }
      }

      System.out.println(outPut.trim());

      input.close();

   }
}
