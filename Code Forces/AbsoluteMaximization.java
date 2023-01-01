import java.io.*;
import java.util.*;

public class AbsoluteMaximization {

   public static void main(String[] args) {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      PrintWriter pw = new PrintWriter(new BufferedOutputStream(System.out));

      try {
         int T = Integer.parseInt(br.readLine());

         while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            int[] A = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());

            int max = 1 << 29;
            int min = -(1 << 29);

            while (st.hasMoreTokens()) {
               max = Math.max((A[N - st.countTokens()] = Integer.parseInt(st.nextToken())), max);
               min = Math.min(A[N - st.countTokens()], min);
            }

            BitSet bSetMax = new BitSet(11);

            pw.printf("%s\n", bSetMax.toString());

            for (int i = 0; i < N; i++) {
               if (A[i] == max) {
                  continue;
               }

            }
         }

         br.close();
         pw.flush();
         pw.close();
      } catch (IOException e) {
         System.exit(0);
      }

   }
}