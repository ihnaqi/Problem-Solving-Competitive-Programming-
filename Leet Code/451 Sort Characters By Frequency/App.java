import java.io.*;
import java.util.*;

public class App {

   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      PrintWriter pw = new PrintWriter(new BufferedOutputStream(System.out));
      Map<Character, Integer> M = new TreeMap<>();

      String s = br.readLine();
      for (int i = 0; i < s.length(); i++) {
         M.put(s.charAt(i), M.getOrDefault(s.charAt(i), 0) + 1);
      }

      Map sortedMap = sortByValues(M);

      Set set = sortedMap.entrySet();

      Iterator i = set.iterator();

      StringBuilder sb = new StringBuilder();
      while (i.hasNext()) {
         Map.Entry me = (Map.Entry) i.next();
         int n = (int) me.getValue();
         while (n-- > 0) {
            sb.append(me.getKey());
         }

      }
      pw.printf("%s\n", sb.reverse().toString());
      br.close();
      pw.flush();
      pw.close();
   }

   public static <K, V extends Comparable<V>> Map<K, V> sortByValues(final Map<K, V> map) {
      Comparator<K> valueComparator = new Comparator<K>() {
         public int compare(K k1, K k2) {
            int compare = map.get(k1).compareTo(map.get(k2));
            if (compare == 0)
               return 1;
            else
               return compare;
         }
      };

      Map<K, V> sortedByValues = new TreeMap<K, V>(valueComparator);
      sortedByValues.putAll(map);
      return sortedByValues;
   }
}