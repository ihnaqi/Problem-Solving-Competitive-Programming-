import java.io.*;
import java.util.StringTokenizer;

public class SquareDeal {

   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      PrintWriter pw = new PrintWriter(new BufferedOutputStream(System.out));

      int[][] dimensions = new int[3][2];
      for (int i = 0; i < dimensions.length; i++) {
         StringTokenizer st = new StringTokenizer(br.readLine());
         for (int j = 0; j < dimensions[i].length; j++) {
            dimensions[i][j] = Integer.parseInt(st.nextToken());
         }
      }

      boolean res = check(dimensions);

      if (res) {
         pw.printf("YES\n");
      } else {
         pw.printf("No\n");
      }

      pw.flush();
      br.close();
      pw.close();
   }

   public static boolean check(int[][] array) {
      if (array[0][0] == array[1][0]) {
         return array[1][0] == array[2][0] && array[0][1] + array[1][1] + array[2][1] == array[0][0];
      }

      int diff = array[0][0] - array[0][1];

      for (int i = 1; i < 3; i++) {
         if (diff != array[i][0] && diff != array[i][1]) {
            return false;
         }
      }

      int sum = 0;
      for (int i = 1; i < 3; i++) {
         sum += array[i][0] + array[i][1] - diff;
      }

      return sum == array[0][0];
   }
}
