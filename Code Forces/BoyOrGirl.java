import java.io.*;
import java.util.*;

public class BoyOrGirl {
   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      PrintWriter pw = new PrintWriter(new BufferedOutputStream(System.out));

      Map<Character, Integer> D = new HashMap<>();

      String str = br.readLine();

      for (int i = 0; i < str.length(); i++) {
         char c = str.charAt(i);
         D.put(c, D.getOrDefault(c, 0) + 1);
      }

      pw.printf("%s\n", D.size() % 2 == 1 ? "IGNORE HIM!" : "CHAT WITH HER!");
      br.close();
      pw.flush();
      pw.close();
   }
}