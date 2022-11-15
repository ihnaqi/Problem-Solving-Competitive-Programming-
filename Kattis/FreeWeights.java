import java.io.*;
import java.util.*;

public class FreeWeights {

   public static void main(String[] args) throws IOException {

      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      PrintWriter pw = new PrintWriter(new BufferedOutputStream(System.out));

      int n = Integer.parseInt(br.readLine());

      SortedSet<Integer> set = new TreeSet<>();
      ArrayList<Long> weights = new ArrayList<>(n);
      int[] a = new int[n];
      int[] b = new int[n];

      StringTokenizer st = new StringTokenizer(br.readLine());
      StringTokenizer st2 = new StringTokenizer(br.readLine());

      int index = 0;
      while (st.hasMoreTokens() && st2.hasMoreTokens()) {
         set.add(a[index] = Integer.parseInt(st.nextToken()));
         set.add(b[index] = Integer.parseInt(st2.nextToken()));
         index++;
      }

      weights.add(0L);

      Iterator<Integer> itr = set.iterator();
      while (itr.hasNext()) {
         weights.add((long) itr.next());
      }

      int high = weights.size() - 1;
      int low = 0;
      int res = 0;

      while (high >= low) {

         int mid = (high + low) / 2;
         int last = -1;
         int last2 = -1;
         boolean wrong = false;

         for (int i = 0; i < n; i++) {
            if (a[i] > weights.get(mid)) {
               if (last == -1) {
                  last = a[i];
               } else if (last == a[i]) {
                  last = -1;
               } else {
                  wrong = true;
               }
            }

            if (b[i] > weights.get(mid)) {
               if (last2 == -1) {
                  last2 = b[i];
               } else if (last2 == b[i]) {
                  last2 = -1;
               } else {
                  wrong = true;
               }
            }
         }
         if (last != -1 || last2 != -1) {
            wrong = true;
         }
         if (wrong) {
            low = mid + 1;
         } else {
            res = mid;
            high = mid - 1;
         }
      }

      pw.printf("%d\n", weights.get(res));

      pw.flush();
      pw.close();
      br.close();
   }

}
