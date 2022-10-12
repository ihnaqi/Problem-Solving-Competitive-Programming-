import java.io.*;
import java.util.*;

public class Srednji {

   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      PrintWriter pw = new PrintWriter(new BufferedOutputStream(System.out));

      StringTokenizer st = new StringTokenizer(br.readLine());
      int n = Integer.parseInt(st.nextToken());
      int med = Integer.parseInt(st.nextToken());

      int[] v = new int[n];
      int pos = Integer.MIN_VALUE;
      st = new StringTokenizer(br.readLine());
      for (int i = 0; i < n; i++) {
         v[i] = Integer.parseInt(st.nextToken());
         if (v[i] == med) {
            pos = i;
         }
      }

      Map<Integer, Integer> map = new HashMap<>();
      map.put(0, 1);
      int sum = 0;

      for (int i = pos + 1; i < n; i++) {
         if (v[i] > med) {
            sum++;
         } else {
            sum--;
         }
         map.put(sum, map.getOrDefault(sum, 0) + 1);
      }
      long ans = map.get(0);

      sum = 0;

      for (int i = pos - 1; i >= 0; i--) {
         if (v[i] > med) {
            sum++;
         } else {
            sum--;
         }
         ans += map.get(-sum) == null ? 0 : map.get(-sum);
      }

      pw.printf("%d\n", ans);

      pw.flush();
      br.close();
      pw.close();
   }
}
