import java.util.Scanner;

public class ConnectTheDots {

   public static void main(String[] args) {

      Scanner input = new Scanner(System.in);

      int size = input.nextInt();

      while (size > 0) {
         int rows = 0;
         int cols = 0;
         char[][] grid = new char[100][100];

         String str = input.next();
         cols = str.length();
         while ((str.compareTo("\n") != 0) && (str.compareTo("") == 0)) {
            grid[rows] = str.toCharArray();
            str = input.next();
            rows++;
         } // Patterns have been read from console and sotored in grid[][]

         for (int i = 0; i <= rows; i++) {
            for (int j = 0; j < cols; j++) {
               if (grid[i][j] != '.' && grid[i][j] != '-' && grid[i][j] != '|' && grid[i][j] != '+') {
                  boolean right = checkRight(grid, i, j);
                  boolean left = false;
                  if (!right) {
                     checkLeft(grid, i, j);
                  }
                  // else if(right)
                  if (!left) {

                  }
               }
            }
         }

      }
      input.close();

   }

   private static boolean checkRight(char[][] grid, int row, int col) {
      int c = col;
      char target = findNextChar(grid[row][col]);
      while (col < grid[row].length) {
         if (grid[row][col] == target) {
            while (col < c) {
               if (grid[row][col] == '.') {
                  if (col == grid[row].length - 1) {
                     grid[row][col] = '|';
                  } else {
                     grid[row][col] = '-';
                  }
               } else if (grid[row][col] == '-') {
                  grid[row][col] = '+';
               }
               col--;
            }
            return true;
         }
         col++;
      }
      return false;
   }

   private static boolean checkLeft(char[][] grid, int row, int col) {
      int c = col;
      char target = findNextChar(grid[row][col]);
      while (col < grid[row].length) {
         if (grid[row][col] == target) {
            while (col > c) {
               if (grid[row][col] == '.') {
                  if (col == grid[row].length - 1) {
                     grid[row][col] = '|';
                  } else {
                     grid[row][col] = '-';
                  }
               } else if (grid[row][col] == '-') {
                  grid[row][col] = '+';
               }
               col++;
            }
            return true;
         }
         col--;
      }
      return false;
   }

   private static char findNextChar(char c) {
      char res = ' ';
      switch (c) {
         case '9':
            res = 'a';
            break;
         case 'z':
            res = 'A';
            break;
         default:
            res = (char) (c + 1);
            break;
      }

      return res;
   }

}