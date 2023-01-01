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
      int y;
      scanf("%d %d", &n, &y);
      while (n--)
      {
         int x;
         scanf("%d", &x);
         y += x;
      }
      double ans = (sqrt((8 * y) + 1) / 2) - 0.5;
      if (fmod(ans, 1.0))
      {
         printf("NO\n");
      }
      else
      {
         printf("YES\n");
      }
   }
}