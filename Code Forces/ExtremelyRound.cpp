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
      scanf("%d", &n);
      if (n < 10)
      {
         printf("%d\n", n);
      }
      else
      {
         int ans = 9;
         int m = 10;

         while (n / m)
         {
            if (n / (m * 10) == 0)
            {
               ans += n / m;
            }
            else
            {
               ans += 9;
            }
            m = m * 10;
         }
         printf("%d\n", ans);
      }
   }
   return 0;
}