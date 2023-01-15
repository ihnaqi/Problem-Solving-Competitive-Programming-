#include <bits/stdc++.h>
using namespace std;

int main()
{

   ios_base::sync_with_stdio(0);

   int t;
   scanf("%d", &t);

   while (t--)
   {
      int n;
      scanf("%d", &n);
      int A[n];

      for (int i = 0; i < n; i++)
      {
         scanf("%d", &A[i]);
      }

      if (A[0] == A[n - 1])
      {
         printf("NO\n");
      }
      else
      {
         printf("YES\n");
         printf("%d ", A[n - 1]);

         for (int i = 0; i < n - 1; i++)
         {
            printf("%d ", A[i]);
         }

         putchar('\n');
      }
   }
}