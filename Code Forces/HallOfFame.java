import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class HallOfFame {
   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      PrintWriter pw = new PrintWriter(new BufferedOutputStream(System.out));

      int t = Integer.parseInt(br.readLine());
      while (t-- > 0) {
         int n = Integer.parseInt(br.readLine());
         String str = br.readLine();

         int cR = 0;
         for (int i = 0; i < n; i++) {
            if (str.charAt(i) == 'R') {
               cR++;
            }
         }

         if (cR == 0 || cR == n) {
            pw.println(-1);
            continue;
         }

         int res = 0;

         for (int i = 0; i < n - 1; i++) {
            if (str.charAt(i) == 'L' && str.charAt(i + 1) == 'R') {
               res = i + 1;
               break;
            }
         }

         pw.println(res);

      }

      br.close();
      pw.flush();
      pw.close();
   }
}
