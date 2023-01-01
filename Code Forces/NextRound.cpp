#include <bits/stdc++.h>
using namespace std;

int main()
{
   int n;
   int k;
   scanf("%d %d", &n, &k);
   int A[n];
   int Ak = 0;

   for (int i = 1; i <= n; i++)
   {
      scanf("%d", &A[i - 1]);
   }
   Ak = A[k - 1];

   int count = 0;
   for (int i = 0; i < n; i++)
   {
      if (A[i] >= Ak && A[i] > 0)
      {
         count++;
      }
   }

   printf("%d\n", count);
}