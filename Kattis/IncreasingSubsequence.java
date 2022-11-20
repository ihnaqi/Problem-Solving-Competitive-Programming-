import java.io.*;
import java.util.*;

public class IncreasingSubsequence {

   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      PrintWriter pw = new PrintWriter(new BufferedOutputStream(System.out));

      while (true) {
         StringTokenizer st = new StringTokenizer(br.readLine());
         int n;
         if ((n = Integer.parseInt(st.nextToken())) == 0) {
            break;
         }

         int[] array = new int[n];
         int[] p = new int[n];
         Arrays.fill(p, -1);
         int index = 0;
         while (st.hasMoreTokens()) {
            array[index++] = Integer.parseInt(st.nextToken());
         }

         int[] L = new int[n];
         int[] L_id = new int[n];
         int k = 0;
         int lis_end = 0;
         for (int i = 0; i < n; i++) {
            int pos = Arrays.binarySearch(L, L[0], L[0] + k, array[i]) - L[0];
            if (pos < 0) {
               pos = 0;
            }
            L[pos] = array[i];
            L_id[pos] = i;
            p[i] = pos != 0 ? L_id[pos - 1] : -1;

            if (pos == k) {
               k = pos + 1;
               lis_end = i;
            } else if (pos == k - 1) {
               lis_end = i;
            }
         }

         StringBuilder sb = new StringBuilder();
         while (lis_end != -1) {
            sb.append(array[lis_end]);
            lis_end = p[lis_end];
         }
         pw.printf("%d ", k);
         for (int i = sb.length() - 1; i >= 0; i--) {
            pw.printf("%c ", sb.charAt(i));
         }
         pw.printf("\n");
      }

      pw.flush();
      br.close();
      pw.close();
   }

}
