#include <bits/stdc++.h>
using namespace std;

int main()
{

   ios_base::sync_with_stdio(false);

   int t;
   scanf("%d", &t);

   while (t--)
   {
      int n;
      int lSum;

      scanf("%d %d", &n, &lSum);
      vector<int> A(n, 0);

      int totalSum = lSum;

      for (int i = 0; i < n; i++)
      {
         scanf("%d", &A[i]);
         totalSum += A[i];
      }

      int sum = 0;

      for (int i = 0; i < n; i++)
      {
         sum += i + 1;
      }

      printf("%s\n", sum == totalSum ? "YES" : "NO");
   }
}