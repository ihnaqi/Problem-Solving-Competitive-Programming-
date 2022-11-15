import java.util.Scanner;

public class Tile2048 {

   public static void main(String[] args) {
      Scanner input = new Scanner(System.in);

      int[][] grid = new int[4][4];

      for (int i = 0; i < grid.length; i++) {
         for (int j = 0; j < grid[i].length; j++) {
            grid[i][j] = input.nextInt();
         }
      }

      int move = input.nextInt();

      switch (move) {
         case 0:
            grid = moveLeft(grid);
            break;
         case 1:
            grid = moveUp(grid);
            break;
         case 2:
            grid = moveRight(grid);
            break;
         case 3:
            grid = moveDown(grid);
            break;
      }

      for (int[] arr : grid) {
         for (int i : arr) {
            System.out.print(i + " ");
         }
         System.out.println();
      }
      input.close();
   }

   // Case 0
   private static int[][] moveLeft(int[][] grid) {
      for (int row = 0; row < grid.length; row++) {
         for (int col = grid.length - 1; col > 0; col--) {
            if (grid[row][col - 1] == 0) {
               grid[row][col - 1] = grid[row][col];
               grid[row][col] = 0;

               // Shifiting back
               for (int col1 = col; col1 < grid[row].length - 1; col1++) {
                  grid[row][col1] = grid[row][col1 + 1];
                  grid[row][col1 + 1] = 0;
               }
            } else if (grid[row][col] == grid[row][col - 1]) {
               grid[row][col - 1] += grid[row][col];
               grid[row][col] = 0;

               // Shifiting back
               for (int col1 = col; col1 < grid[row].length - 1; col1++) {
                  grid[row][col1] = grid[row][col1 + 1];
                  grid[row][col1 + 1] = 0;
               }
            }
         }
      }

      return grid;
   }

   // Case 1
   private static int[][] moveUp(int[][] grid) {

      for (int col = 0; col < grid.length; col++) {
         for (int row = grid.length - 1; row > 0; row--) {
            if (grid[row - 1][col] == 0) {
               grid[row - 1][col] = grid[row][col];
               grid[row][col] = 0;

               for (int i = row; i < grid.length - 1; i++) {
                  grid[i][col] = grid[i + 1][col];
                  grid[i + 1][col] = 0;
               }
            } else if (grid[row][col] == grid[row - 1][col]) {
               grid[row - 1][col] += grid[row][col];
               grid[row][col] = 0;

               for (int i = row; i < grid.length - 1; i++) {
                  grid[i][col] = grid[i + 1][col];
                  grid[i + 1][col] = 0;
               }
            }
         }
      }
      return grid;
   }

   // Case 2
   private static int[][] moveRight(int[][] grid) {
      for (int row = 0; row < grid.length; row++) {
         for (int col = 0; col < grid.length - 1; col++) {
            if (grid[row][col] == grid[row][col + 1]) {
               grid[row][col + 1] += grid[row][col];
               grid[row][col] = 0;

               for (int i = col; i > 0; i--) {
                  grid[row][i] = grid[row][i - 1];
                  grid[row][i - 1] = 0;
               }
            } else if (grid[row][col + 1] == 0) {
               grid[row][col + 1] = grid[row][col];
               grid[row][col] = 0;

               for (int i = col; i > 0; i--) {
                  grid[row][i] = grid[row][i - 1];
                  grid[row][i - 1] = 0;
               }
            }
         }
      }
      return grid;
   }

   // Case 3
   private static int[][] moveDown(int[][] grid) {
      for (int col = 0; col < grid.length; col++) {
         for (int row = 0; row < grid[col].length - 1; row++) {
            if (grid[row + 1][col] == 0) {
               grid[row + 1][col] = grid[row][col];
               grid[row][col] = 0;

               for (int i = row; i > 0; i--) {
                  grid[i][col] = grid[i - 1][col];
                  grid[i - 1][col] = 0;
               }
               break;
            } else if (grid[row][col] == grid[row + 1][col]) {
               grid[row + 1][col] += grid[row][col];
               grid[row][col] = 0;

               for (int i = row; i > 0; i--) {
                  grid[i][col] = grid[i - 1][col];
                  grid[i - 1][col] = 0;
               }
               break;
            }
         }
      }
      return grid;
   }
}
