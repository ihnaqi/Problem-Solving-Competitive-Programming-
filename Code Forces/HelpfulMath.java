import java.io.*;
import java.util.*;

public class HelpfulMath {
   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      PrintWriter pw = new PrintWriter(new BufferedOutputStream(System.out));

      StringTokenizer st = new StringTokenizer(br.readLine(), "+");
      int[] A = new int[st.countTokens()];
      for (int i = 0; i < A.length; i++) {
         A[i] = Integer.parseInt(st.nextToken());
      }

      Arrays.sort(A);

      for (int i = 0; i < A.length - 1; i++) {
         pw.printf("%d+", A[i]);
      }
      pw.printf("%d\n", A[A.length - 1]);

      br.close();
      pw.flush();
      pw.close();
   }
}