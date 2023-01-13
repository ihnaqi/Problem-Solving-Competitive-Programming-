#include <bits/stdc++.h>
using namespace std;

int main()
{

   ios_base::sync_with_stdio(false);

   int t;
   scanf("%d", &t);

   while (t--)
   {
      ios_base::sync_with_stdio(0);

      int n;
      int nSum;
      scanf("%d %d", &n, &nSum);

      int A[n];
      int mx = -(1 >> 29);
      for (int i = 0; i < n; i++)
      {
         scanf("%d", &A[i]);
         nSum += A[i];
         mx = max(mx, A[i]);
      }

      int sum = 0;
      int count = 0;
      for (int i = 1; i < nSum + 1; i++)
      {
         if (sum >= nSum)
         {
            break;
         }
         sum += i;
         count = i;
      }

      if (sum != nSum || count <= n || mx > count)
      {
         printf("NO\n");
      }
      else
      {
         printf("YES\n");
      }
   }
}