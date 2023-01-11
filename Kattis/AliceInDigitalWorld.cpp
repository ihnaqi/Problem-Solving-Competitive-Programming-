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
         // Find a subsequence containing `m` exactly once,
         // such that  `m` is the smallest number in that sequence and the sum of the subsequence is the largest of all such subsequences.
      }

      printf("%d\n", res);
   }
}