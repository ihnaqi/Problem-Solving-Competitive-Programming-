#include <bits/stdc++.h>
using namespace std;

int main()
{

   int t;
   scanf("%d", &t);

   while (t--)
   {
      int n;
      scanf("%d", &n);
      vector<vector<int>> a(3, vector<int>(n + 1, 0));
      int i, j;
      for (i = 1; i <= 2; i++)
      {
         char s[n];
         scanf("%s", s);

         for (j = 1; j <= n; j++)
         {
            a[i][j] = s[j - 1] == 'W' ? 0 : 1;
         }
      }

      vector<vector<int>> cache(3, vector<int>(n + 5, 0));

      cache[1][n] = a[1][n] == 1 ? 1 : 0;
      cache[2][n] = a[2][n] == 1 ? 1 : 0;

      for (j = n; j > 0; j--)
      {
         for (i = 1; i <= 2; i++)
         {
            if (a[i][j] == 1)
            {
               int ot = i == 1 ? 2 : 1;

               cache[i][j] = a[ot][j] == 1 ? cache[ot][j + 1] : cache[i][j + 1];
            }
         }
      }
      if (cache[1][1] || cache[2][1])
      {
         printf("YES\n");
      }
      else
      {
         printf("NO\n");
      }
   }
}