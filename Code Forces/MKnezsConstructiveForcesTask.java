import java.io.*;
import java.util.ArrayList;

public class MKnezsConstructiveForcesTask {

   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      PrintWriter pw = new PrintWriter(new BufferedOutputStream(System.out));

      int t = Integer.parseInt(br.readLine());

      while (t-- > 0) {
         int n = Integer.parseInt(br.readLine());
         ArrayList<String> lst = new ArrayList<>();
         if (n % 3 == 0) {
            pw.println("NO");
            continue;
         } else if (n % 2 == 0) {
            pw.print("YES\n");

            for (int i = 0; i < n / 2; i++) {
               lst.add("1");
               lst.add("-1");
            }
            for (int i = 0; i < lst.size(); i++) {
               pw.printf("%s ", lst.get(i));
            }
            pw.print('\n');
            continue;
         } else {
            pw.print("YES");

            int y = n / 2;
            for (int i = 0; i < n / 2; i++) {
               lst.add(String.valueOf(1 - y));
               lst.add(String.valueOf(y));
            }
            lst.add(String.valueOf(1 - y));
            for (int i = 0; i < lst.size(); i++) {
               pw.printf("%s ", lst.get(i));
            }
            pw.print('\n');
            continue;
         }
      }

      br.close();
      pw.flush();
      pw.close();
   }

}
