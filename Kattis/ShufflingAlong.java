import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public class ShufflingAlong {

   static int[] merge(Integer[] array1, Integer[] array2) {

      int[] resultArray = new int[array1.length + array2.length];
      int i = 0, j = 0, k = 0;

      while (i < array1.length && j < array2.length) {
         resultArray[k++] = array1[i++];
         resultArray[k++] = array2[j++];

      }
      while (i < array1.length)
         resultArray[k++] = array1[i++];

      while (j < array2.length)
         resultArray[k++] = array2[j++];

      return resultArray;

   }

   public static void main(String[] args) {
      Scanner input = new Scanner(System.in);

      int n = input.nextInt();
      String word = input.next();
      int[] array = new int[n];

      for (int i = 0; i < array.length; i++) {
         array[i] = i;
      }
      int[] temp = array.clone();

      if (word.equals("out")) {
         int count = 0;
         while (true) {
            int mid = (array.length + 1) / 2;

            ArrayList<Integer> array1 = new ArrayList<>();
            ArrayList<Integer> array2 = new ArrayList<>();

            for (int i = 0; i < array.length; i++) {
               if (i < mid) {
                  array1.add(array[i]);
               } else {
                  array2.add(array[i]);
               }
            }
            Integer[] arr1 = array1.toArray(new Integer[0]);
            Integer[] arr2 = array2.toArray(new Integer[0]);
            int[] result = merge(arr1, arr2);
            count++;

            if (Arrays.equals(result, temp)) {
               System.out.println(count);
               break;
            } else {
               for (int i = 0; i < array.length; i++) {
                  array[i] = result[i];
               }
            }

         }
      }
      if (word.equals("in")) {
         int count = 0;
         while (true) {
            int mid = (array.length) / 2;

            ArrayList<Integer> array1 = new ArrayList<>();
            ArrayList<Integer> array2 = new ArrayList<>();

            for (int i = 0; i < array.length; i++) {
               if (i < mid) {
                  array1.add(array[i]);
               } else {
                  array2.add(array[i]);
               }
            }
            Integer[] arr1 = array1.toArray(new Integer[0]);
            Integer[] arr2 = array2.toArray(new Integer[0]);
            int[] result = merge(arr2, arr1);
            count++;

            if (Arrays.equals(result, temp)) {
               System.out.println(count);
               break;
            } else {
               for (int i = 0; i < array.length; i++) {
                  array[i] = result[i];
               }
            }

         }
      }
      input.close();
   }
}