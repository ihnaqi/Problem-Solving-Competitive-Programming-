import java.io.*;
import java.util.*;

public class GrandpaBernie {

   public static void main(String[] args) throws IOException {

      BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
      BufferedWriter pw = new BufferedWriter(new OutputStreamWriter(System.out));

      int n = Integer.parseInt(input.readLine());
      Map<String, ArrayList<Integer>> map = new HashMap<>();
      HashSet<String> sorted = new HashSet<>();

      while (n > 0) {

         String st = input.readLine();

         String country = st.substring(0, st.lastIndexOf(' '));

         int year = Integer.parseInt(st.substring(st.lastIndexOf(' ') + 1, st.length()));

         if (map.get(country) != null) {
            map.get(country).add(year);
         } else {
            map.put(country, new ArrayList<Integer>());
            map.get(country).add(year);
         }

         n--;
      }

      n = Integer.parseInt(input.readLine());

      while (n > 0) {
         String st = input.readLine();

         String country = st.substring(0, st.lastIndexOf(' '));
         if (!sorted.contains(country)) {
            Collections.sort(map.get(country));
            sorted.add(country);
         }
         int index = Integer.parseInt(st.substring(st.lastIndexOf(' ') + 1));

         pw.write(map.get(country).get(index - 1).toString());
         pw.write('\n');

         n--;
      }

      input.close();
      pw.close();
   }
}
