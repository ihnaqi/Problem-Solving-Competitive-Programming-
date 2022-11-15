#include <bits/stdc++.h>
using namespace std;

int main()
{

   ios_base::sync_with_stdio(false);
   int l;
   int r;
   scanf("%d %d", &l, &r);

   if (l == 0 && r == 0)
   {
      printf("Not a moose\n");
   }
   else if (l == r)
   {
      printf("Even %d\n", l + r);
   }
   else
   {
      printf("Odd %d\n", 2 * (l > r ? l : r));
   }

   return 0;
}