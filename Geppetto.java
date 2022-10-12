import java.io.*;
import java.util.StringTokenizer;

public class Geppetto {

   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      PrintWriter pw = new PrintWriter(new BufferedOutputStream(System.out));
      StringTokenizer st = new StringTokenizer(br.readLine());
      int N = Integer.parseInt(st.nextToken());
      int M = Integer.parseInt(st.nextToken());

      int[] R = new int[M];

      for (int j = 0; j < M; j++) {
         st = new StringTokenizer(br.readLine());
         int x = Integer.parseInt(st.nextToken());
         int y = Integer.parseInt(st.nextToken());

         R[j] = (1 << (x - 1)) | (1 << (y - 1));
      }

      int count = 0;

      int PN = 1 << N;
      for (int i = 0; i < PN; i++) {
         boolean flag = false;
         for (int j = 0; j < M; j++) {
            if ((i & R[j]) == R[j]) {
               flag = true;
               break;
            }
         }
         if (!flag) {
            count++;
         }
      }
      pw.printf("%d\n", count);
      pw.flush();
      br.close();
      pw.close();
   }

}
