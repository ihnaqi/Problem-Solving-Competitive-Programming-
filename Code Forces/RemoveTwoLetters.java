import java.io.*;

public class RemoveTwoLetters {

   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      PrintWriter pw = new PrintWriter(new BufferedOutputStream(System.out));

      int t = Integer.parseInt(br.readLine().trim());

      while (t-- > 0) {

         int n = Integer.parseInt(br.readLine().trim());
         String s = br.readLine();

         int res = n - 1;

         for (int i = 1; i < n - 1; i++) {
            if (s.charAt(i - 1) == s.charAt(i + 1)) {
               res--;
            }
         }

         pw.printf("%d\n", res);
      }

      pw.flush();
      pw.close();
      br.close();
   }
}
