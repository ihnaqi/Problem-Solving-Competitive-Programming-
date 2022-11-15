import java.io.*;

public class DanceRecital {
   public static int cost[][];

   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      PrintWriter pw = new PrintWriter(new BufferedOutputStream(System.out));

      int R = Integer.parseInt(br.readLine());
      String[] dance = new String[R];

      for (int i = 0; i < R; i++) {
         dance[i] = br.readLine();

      }

      cost = new int[R][R];

      for (int i = 0; i < cost.length; i++) {
         for (int j = 0; j < cost[i].length; j++) {
            cost[i][j] = quick(dance[i], dance[j]);
         }
      }

      boolean[] used = new boolean[R];
      int[] prem = new int[R];

      pw.printf("%d\n", solve(prem, used, 0));

      pw.flush();
      br.close();
      pw.close();

   }

   public static int solve(int[] prem, boolean[] used, int k) {
      if (k == used.length) {
         return eval(prem);
      }

      int res = 1000000;

      for (int i = 0; i < used.length; i++) {
         if (!used[i]) {
            prem[k] = i;
            used[i] = true;

            res = Math.min(res, solve(prem, used, k + 1));
            used[i] = false;
         }
      }

      return res;
   }

   public static int quick(String a, String b) {
      int cnt = 0;
      for (int i = 0; i < a.length(); i++) {
         if (b.contains(a.charAt(i) + "")) {
            cnt++;
         }
      }
      return cnt;
   }

   public static int eval(int[] prem) {
      int res = 0;

      for (int i = 0; i < prem.length - 1; i++) {
         res += cost[prem[i]][prem[i + 1]];
      }
      return res;
   }
}
