public class App {

   private int[][] grid;
   private int total;
   private int m;
   private int n;

   public int uniquePathsIII(int[][] grid) {

      this.grid = grid;
      this.m = grid.length;
      this.n = grid[0].length;
      int steps = 0;

      int startRow = 0;
      int startColumn = 0;

      for (int r = 0; r < m; r++) {
         for (int c = 0; c < n; c++) {
            if (this.grid[r][c] == 1) {
               startColumn = c;
               startRow = r;
            }
            if (grid[r][c] >= 0) {
               steps++;
            }
         }
      }

      backtrack(startRow, startColumn, steps);

      return total;
   }

   private void backtrack(int row, int col, int steps) {
      if (row < 0 || col < 0 || row >= n || col >= m || this.grid[row][col] == -1) {
         return;
      }

      if (grid[row][col] == 2 && steps == 1) {
         this.total++;
         return;
      }

      int dummy = grid[row][col];
      grid[row][col] = -1;
      steps--;

      backtrack(row + 1, col, steps);
      backtrack(row - 1, col, steps);
      backtrack(row, col + 1, steps);
      backtrack(row, col - 1, steps);

      grid[row][col] = dummy;
   }

}
