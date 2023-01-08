#include <bits/stdc++.h>
using namespace std;

int main()
{

   ios_base::sync_with_stdio(false);

   int t;
   scanf("%d", &t);

   while (t-- > 0)
   {
      int x;
      scanf("%d", &x);

      int a[x];

      scanf("%d %d %d", &a[0], &a[1], &a[2]);

      if (a[x - 1] && a[a[x - 1] - 1])
      {
         printf("YES\n");
      }
      else
      {
         printf("NO\n");
      }
   }
}