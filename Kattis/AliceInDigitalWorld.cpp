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
      int aSum[n];

      for (int i = 0; i < n; i++)
      {
         scanf("%d", &A[i]);
      }

      int diff = 0;
      int res = 0;

      for (int i = 0; i < n; i++)
      {
         if (A[i] == m)
         {
         }

         res = max(res, aSum[i]);
      }

      printf("%d\n", res);
   }
}