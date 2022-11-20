#include <bits/stdc++.h>
using namespace std;

int main()
{
   ios_base::sync_with_stdio(false);
   int n;
   scanf("%d", &n);

   vector<int> dp(n);
   vector<int> lis(n, 1);
   vector<int> lds(n, 1);

   for (int i = 0; i < n; i++)
   {
      scanf("%d", &dp[i]);
   }

   for (int i = lis.size() - 1; i >= 0; i--)
   {
      for (int j = i + 1; j < lis.size(); j++)
      {
         if (dp[i] < dp[j])
         {
            lis[i] = lis[i] > lis[j] + 1 ? lis[i] : lis[j] + 1;
         }
         else
         {
            lds[i] = lds[i] > lds[j] + 1 ? lds[i] : lds[j] + 1;
         }
      }
   }

   int res = 0;

   for (int i = 0; i < lis.size(); i++)
   {
      res = max(res, lis[i] + lds[i] - 1);
   }

   printf("%d\n", res);
}