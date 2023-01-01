#include <bits/stdc++.h>
using namespace std;

int dSum(int x)
{
   int res = 0;
   while (x > 0)
   {
      res += x % 10;
      x /= 10;
   }
   return res;
}

int main()
{
   ios_base::sync_with_stdio(false);

   int t;
   scanf("%d", &t);
   while (t--)
   {
      int n;
      scanf("%d", &n);
      int sum = dSum(n);

      int res = 0;

      for (int i = n - 1; i >= 0; i--)
      {
         if (dSum(i) == sum - 1)
         {
            res = i;
            break;
         }
      }
      printf("%d\n", res);
   }
}