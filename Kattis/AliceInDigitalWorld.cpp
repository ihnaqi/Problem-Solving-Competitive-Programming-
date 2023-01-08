#include <bits/stdc++.h>
using namespace std;

int main()
{

   ios_base::sync_with_stdio(false);

   int t;
   scanf("%d", &t);

   while (t-- > 0)
   {
      int n;
      int m;
      scanf("%d %d", &n, &m);

      int A[n];

      for (int i = 0; i < n; i++)
      {
         scanf("%d", &A[i]);
      }

      int res = -(1 << 29);

      int sum = 0;
      for (int i = 0; i < n; i++)
      {
         if (A[i] < m)
         {
            res = max(sum, res);
            sum = 0;
         }
         else
         {
            sum += A[i];
         }
      }

      res = max(sum, res);

      printf("%d\n", res);
   }
}