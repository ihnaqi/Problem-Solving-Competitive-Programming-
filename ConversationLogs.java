import java.io.*;
import java.util.*;

public class ConversationLogs {

   public static void main(String[] args) throws IOException {

      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      PrintWriter pw = new PrintWriter(new BufferedOutputStream(System.out));

      HashMap<String, Integer> map = new HashMap<String, Integer>();
      HashMap<String, HashSet<String>> wordToUser = new HashMap<>();
      HashSet<String> users = new HashSet<>();

      int num = Integer.parseInt(br.readLine());

      PriorityQueue<Pair> pq = new PriorityQueue<>(num);

      while (num-- > 0) {

         StringTokenizer st = new StringTokenizer(br.readLine());
         String name = st.nextToken();
         users.add(name);

         while (st.hasMoreTokens()) {
            String word = st.nextToken();
            map.put(word, map.getOrDefault(word, 0) + 1);
            if (wordToUser.get(word) != null) {
               if (name != null) {
                  wordToUser.get(word).add(name);
               }
            } else {
               wordToUser.put(word, new HashSet<>());
               wordToUser.get(word).add(name);
            }
         }
      }
      boolean flag = false;

      for (String str : map.keySet()) {
         if (wordToUser.get(str).size() >= users.size()) {
            pq.add(new Pair(str, map.get(str)));
            flag = true;
         }
      }

      if (!flag) {
         pw.println("ALL CLEAR");
      }

      else {
         while (!pq.isEmpty()) {
            pw.println(pq.poll().getKey());
         }
      }
      pw.flush();
      br.close();
      pw.close();
   }

}

class Pair implements Comparable<Pair> {
   private String key;
   private int val;

   Pair(String key, int val) {
      this.key = key;
      this.val = val;
   }

   public String getKey() {
      return this.key;
   }

   public int getVal() {
      return this.val;
   }

   @Override
   public int compareTo(Pair that) {
      return this.val > that.val ? -1 : 1;
   }

}