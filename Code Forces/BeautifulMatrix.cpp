#include <bits/stdc++.h>
using namespace std;

int main()
{

   int A[5][5];

   int row;
   int col;

   for (int i = 0; i < 5; i++)
   {
      for (int j = 0; j < 5; j++)
      {
         scanf("%d", &A[i][j]);
         if (A[i][j] == 1)
         {
            row = i;
            col = j;
         }
      }
   }

   int res = abs(row - 2) + abs(col - 2);
   printf("%d\n", res);
}