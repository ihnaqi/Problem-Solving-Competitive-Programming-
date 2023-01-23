import java.io.*;

class Solution {

   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      PrintWriter pw = new PrintWriter(new BufferedOutputStream(System.out));

      String s = br.readLine();
      String r = br.readLine();

      if (s.length() != r.length()) {
         pw.println("N0");
      } else {
         boolean res = true;
         for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != r.charAt(r.length() - i - 1)) {
               res = false;
               break;
            }
         }

         pw.printf("%s\n", res ? "YES" : "NO");
      }
      br.close();
      pw.flush();
      pw.close();
   }
}