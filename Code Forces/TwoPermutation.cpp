#include <bits/stdc++.h>
using namespace std;

int main()
{

   ios_base::sync_with_stdio(false);

   int t;
   scanf("%d", &t);
   while (t--)
   {
      int n, a, b;
      scanf("%d %d %d", &n, &a, &b);

      if ((n == a && a == b) || n > (a + b + 1))
      {
         printf("Yes\n");
      }
      else
      {
         printf("No\n");
      }
   }
}
