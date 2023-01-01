import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class Solution {

   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      PrintWriter pw = new PrintWriter(new BufferedOutputStream(System.out));
      int grid[][] = { { 1, 1, 1, -1, -1 }, { 1, 1, 1, -1, -1 }, { -1, -1, -1, 1, 1 }, { 1, 1, 1, 1, -1 },
            { -1, -1, -1, -1, -1 } };
      pw.println(Arrays.toString(findBall(grid)));
      pw.flush();
      pw.close();
      br.close();
   }

   public static int[] findBall(int[][] grid) {

      int[] answer = new int[grid[0].length];

      int index = 0;
      while (index < grid[0].length) {

         int row = -1;
         int col = index;

         while (row++ < grid.length) {

            if (grid[row][col] == 1) {
               if (row + 1 >= grid.length) {
                  answer[index] = 1;
                  break;
               } else if (col + 1 >= grid[0].length && row + 1 < grid.length) {
                  answer[index] = -1;
                  break;
               } else if (col < grid[0].length && row < grid.length) {

                  if (grid[row][col] + grid[row + 1][col + 1] == 0) {
                     answer[index] = -1;
                     break;
                  } else {
                     col += 1;
                     row += 1;
                  }
               }
            } else {
               if (row + 1 >= grid.length) {
                  answer[index] = 1;
                  break;
               } else if (col - 1 < 0 && row + 1 < grid.length) {
                  answer[index] = -1;
                  break;
               } else if (col < grid[0].length && row < grid.length) {

                  if (grid[row][col] + grid[row + 1][col - 1] == 0) {
                     answer[index] = -1;
                     break;
                  } else {
                     col -= 1;
                     row += 1;
                  }
               }
            }

         }
      }

      return answer;
   }
}