import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CoinChangeII518 {
   private int n;
   private int memo[][];
   private int[] w;
   private int[] v;

   public int change(int amt, int[] coins) {

      this.n = amt;
      this.memo = new int[coins.length][amt];

      this.w = coins;
      this.v = new int[amt];
      for (int i = 0; i < amt; i++) {
         v[i] = i + 1;
      }

      return dp(0, amt - 1);
   }

   private int dp(int id, int remW) {
      if ((id == n) || (remW == 0)) {
         return 0;
      }

      int ans = memo[id][remW];

      if (ans != -1) {
         return ans = -1;
      }

      if (w[id] >= remW) {
         return dp(id + 1, remW);
      }

      return Integer.max(dp(id + 1, remW), v[id] + dp(id + 1, remW - v[id]));
   }

   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      PrintWriter pw = new PrintWriter(new BufferedOutputStream(System.out));

      int amt = Integer.parseInt(br.readLine());
      StringTokenizer st = new StringTokenizer(br.readLine());

      int[] denominations = new int[st.countTokens()];

      for (int i : denominations) {
         i = Integer.parseInt(st.nextToken());
      }

      pw.printf("Array: %s\n", Arrays.toString(denominations));

      int res = new CoinChangeII518().change(amt, denominations);
      pw.printf("%d\n", res);
      pw.flush();
      br.close();
      pw.close();
   }
}