import java.io.*;

public class WordCapitalization {

   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      PrintWriter pw = new PrintWriter(new BufferedOutputStream(System.out));

      String s = br.readLine();

      pw.printf("%s\n", s.substring(0, 1).toUpperCase().concat(s.substring(1)));

      pw.flush();
      br.close();
      pw.close();
   }
}