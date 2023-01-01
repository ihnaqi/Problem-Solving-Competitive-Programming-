#include <bits/stdc++.h>
using namespace std;

int main()
{

   ios_base::sync_with_stdio(false);

   int t;
   scanf("%d", &t);
   while (t--)
   {
      int x;
      scanf("%d", &x);
      x = x % 2 == 0 ? x / 2 : (x / 2) + 1;

      printf("%d\n", x);
   }
   return 0;
}