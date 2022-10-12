import java.io.*;
import java.util.*;

public class GolombRuler {

   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      PrintWriter pw = new PrintWriter(new BufferedOutputStream(System.out));

      String str;

      A: while ((str = br.readLine()) != null && str.compareTo("") != 0 && !str.isEmpty()) {
         StringTokenizer st = new StringTokenizer(str);
         int[] array = new int[st.countTokens()];
         PriorityQueue<Integer> pq = new PriorityQueue<>((array.length * (array.length) >> 1));
         int[] arr = new int[2000];

         for (int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(st.nextToken());
         }
         int sum = 0;
         int max = Integer.MIN_VALUE;
         for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
               int key = Math.abs(array[j] - array[i]);
               if (key > max) {
                  max = key;
               }
               arr[key] += 1;
               if (arr[key] > 1) {
                  pw.printf("not a ruler\n");
                  continue A;
               }
               pq.add(key);
               sum = sum + key;
            }
         }
         int nSum = (max * (max + 1)) >> 1;
         if (sum == nSum) {
            pw.printf("perfect\n");
         } else {
            pw.printf("missing ");
            int prev = 0;

            while (!pq.isEmpty()) {
               int n = pq.poll();
               if (n - prev > 1) {
                  for (int k = prev + 1; k < n; k++) {
                     pw.printf("%d ", k);
                  }
               }

               prev = n;
            }

            pw.printf("\n");
         }
      }

      pw.flush();
      br.close();
      pw.close();
   }
}
