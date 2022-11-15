import java.io.*;
import java.util.StringTokenizer;

public class JumbledCommunication {

   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      PrintWriter pw = new PrintWriter(new BufferedOutputStream(System.out));

      int n = Integer.parseInt(br.readLine());

      StringTokenizer st = new StringTokenizer(br.readLine());

      while (n-- > 0) {
         int x = Integer.parseInt(st.nextToken());
         for (int j = 0; j < 256; j++) {
            if ((j ^ (j << 1)) % 256 == x) {
               pw.printf("%d ", j);
               break;
            }
         }
      }
      pw.printf("\n");

      pw.flush();
      br.close();
      pw.close();

   }

}
