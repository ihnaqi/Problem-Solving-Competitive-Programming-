#include <bits/stdc++.h>

int main()
{
   std::ios_base::sync_with_stdio(false);
   int n, price;
   scanf("%d %d", &n, &price);
   int currSum = 0;
   int sum = INT_MIN;
   while (n-- > 0)
   {
      int x;
      scanf("%d", &x);
      int T = x - price;
      currSum += T;
      if (currSum > sum)
      {
         sum = currSum;
      }
      if (currSum < 0)
      {
         currSum = 0;
      }
   }

   printf("%d\n", sum);

   return 0;
}