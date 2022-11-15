import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class CD {

   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int n;
      int m;
      while (true) {

         int count = 0;
         String str = br.readLine();
         n = Integer.parseInt(str.substring(0, str.indexOf(" ")));
         m = Integer.parseInt(str.substring(str.indexOf(" ") + 1));

         if (n == 0 && m == 0) {
            break;
         }

         HashSet<Integer> set1 = new HashSet<>();
         for (int i = 0; i < n; i++) {
            int a = Integer.parseInt(br.readLine());
            ;
            set1.add(a);
         }

         for (int i = 0; i < m; i++) {
            int a = Integer.parseInt(br.readLine());
            ;
            if (set1.contains(a)) {
               count++;
            }
         }
         System.out.println(count);

      }
   }

}
