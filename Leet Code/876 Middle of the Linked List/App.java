import java.io.*;

public class App {

   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      PrintWriter pw = new PrintWriter(new BufferedOutputStream(System.out));

      br.close();
      pw.flush();
      pw.close();
   }
}
