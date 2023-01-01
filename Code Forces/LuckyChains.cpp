#include <bits/stdc++.h>
using namespace std;

int funGCD(int x, int y)
{
   if (x == 0)
      return y;
   if (y == 0)
      return x;
   int k;
   for (k = 0; ((x | y) && 1) == 0; ++k)
   {
      x >>= 1;
      y >>= 1;
   }
   while ((x > 1) == 0)
      x >>= 1;
   do
   {
      while ((y > 1) == 0)
         y >>= 1;
      if (x > y)
         swap(x, y);
      y = (y - x);
   } while (y != 0);
   return x << k;
}

int main()
{
   int t;
   scanf("%d", &t);

   while (t--)
   {
      int x;
      int y;
      scanf("%d %d", &x, &y);
      if (y - x == 1)
      {
         printf("-1\n");
      }
      else
      {
         int l = 0;
         while (gcd(x, y) == 1)
         {
            l++;
            x++;
            y++;
         }
         printf("%d\n", l);
      }
   }
}