import java.io.*;
import java.util.*;

public class CompoundWords {

   public static void main(String[] args) throws IOException {

      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      BufferedWriter pw = new BufferedWriter(new OutputStreamWriter(System.out));

      TreeSet<String> tree = new TreeSet<>();
      ArrayList<String> list = new ArrayList<>();
      String str;

      while ((str = br.readLine()) != null && str != "" && !str.isEmpty()) {

         StringTokenizer st = new StringTokenizer(str);

         while (st.hasMoreTokens()) {
            list.add(st.nextToken());
         }
      }

      for (int i = 0; i < list.size(); i++) {
         for (int j = 0; j < list.size(); j++) {
            if (j != i) {
               tree.add(list.get(i).concat(list.get(j)));
               tree.add(list.get(j).concat(list.get(i)));
            }
         }
      }

      for (String s : tree) {
         pw.write(s);
         pw.write('\n');
      }

      pw.flush();
      br.close();
      pw.close();
   }

}
