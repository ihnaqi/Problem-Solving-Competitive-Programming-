import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class TrainSort {

   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      PrintWriter pw = new PrintWriter(new BufferedOutputStream(System.out));

      int n = Integer.parseInt(br.readLine());

      int[] dp = new int[n];
      int[] lis = new int[n];
      int[] lds = new int[n];

      Arrays.fill(lis, 1);
      Arrays.fill(lds, 1);

      for (int i = 0; i < n; i++) {
         dp[i] = Integer.parseInt(br.readLine());
      }

      for (int i = lis.length - 1; i >= 0; i--) {
         for (int j = i + 1; j < lis.length; j++) {
            if (dp[i] < dp[j]) {
               lis[i] = lis[i] > lis[j] + 1 ? lis[i] : lis[j] + 1;
            } else {
               lds[i] = lds[i] > lds[j] + 1 ? lds[i] : lds[j] + 1;
            }
         }
      }

      int res = 0;

      for (int i = 0; i < lis.length; i++) {
         res = res > (lis[i] + lds[i] - 1) ? res : (lis[i] + lds[i] - 1);
      }

      pw.printf("%d\n", res);

      pw.flush();
      br.close();
      pw.close();

   }
}