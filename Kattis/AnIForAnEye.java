import java.io.*;
import java.util.*;

public class AnIForAnEye {

   private static void fill(Map<Integer, Map<String, String>> map) {
      map.put(2, new HashMap<>() {
         {
            put("at", "@");
            put("to", "2");
            put("be", "b");
            put("oh", "o");

            put("At", "@");
            put("To", "2");
            put("Be", "B");
            put("Oh", "O");
         }
      });

      map.put(3, new HashMap<>() {
         {
            put("and", "&");
            put("one", "1");
            put("won", "1");
            put("too", "2");
            put("two", "2");
            put("for", "4");
            put("bea", "b");
            put("bee", "b");
            put("sea", "c");
            put("see", "c");
            put("eye", "i");
            put("owe", "o");
            put("are", "r");
            put("you", "u");
            put("why", "y");

            put("And", "&");
            put("One", "1");
            put("Won", "1");
            put("Too", "2");
            put("Two", "2");
            put("For", "4");
            put("Bea", "B");
            put("Bee", "B");
            put("See", "C");
            put("Sea", "C");
            put("Eye", "I");
            put("Owe", "O");
            put("Are", "R");
            put("You", "U");
            put("Why", "Y");

         }
      });

      map.put(4, new HashMap<>() {
         {
            put("four", "4");

            put("Four", "4");
         }
      });
   }

   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      PrintWriter pw = new PrintWriter(new BufferedOutputStream(System.out));

      int t = Integer.parseInt(br.readLine());
      Map<Integer, Map<String, String>> map = new HashMap<>();

      fill(map);

      while (t-- > 0) {

         StringTokenizer st = new StringTokenizer(br.readLine());

         while (st.hasMoreTokens()) {
            String s = st.nextToken();
            int l = s.length();
            int curr = 0;

            while (curr < l - 1) {

               if (curr < l - 3 && map.get(4).get(s.substring(curr, curr + 4)) != null) {
                  s = s.replace(s.substring(curr, curr + 4), map.get(4).get(s.substring(curr, curr + 4)));
                  l = s.length();
               } else if (curr < l - 2 && map.get(3).get(s.substring(curr, curr + 3)) != null) {
                  s = s.replace(s.substring(curr, curr + 3), map.get(3).get(s.substring(curr, curr + 3)));
                  l = s.length();
               } else if (map.get(2).get(s.substring(curr, curr + 2)) != null) {
                  s = s.replace(s.substring(curr, curr + 2), map.get(2).get(s.substring(curr, curr + 2)));
                  l = s.length();
               }
               curr++;

            }

            pw.printf("%s ", s);

         }

         pw.printf("\n");

      }

      br.close();
      pw.flush();
      pw.close();

   }
}