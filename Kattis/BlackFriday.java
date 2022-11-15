import java.io.*;
import java.util.*;

public class BlackFriday {

   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      PrintWriter pw = new PrintWriter(new BufferedOutputStream(System.out));

      Map<Integer, Integer> map = new HashMap<>();
      Map<Integer, Integer> unique = new HashMap<>();
      int max = Integer.MIN_VALUE;
      int index = 0;

      int N = Integer.parseInt(br.readLine());
      StringTokenizer st = new StringTokenizer(br.readLine());

      while (N-- > 0 && st.hasMoreTokens()) {
         int num = Integer.parseInt(st.nextToken());
         unique.put(num, index++);
         map.put(num, map.getOrDefault(num, 0) + 1);
      }

      for (Integer key : map.keySet()) {
         if (map.get(key) > 1) {
            unique.remove(key);
         }
      }

      for (Integer key : unique.keySet()) {
         if (key > max) {
            index = unique.get(key);
         }
      }

      if (unique.size() == 0) {
         pw.println("none");
      } else {
         pw.println(index + 1);
      }

      pw.flush();
      br.close();
      pw.close();

   }
}