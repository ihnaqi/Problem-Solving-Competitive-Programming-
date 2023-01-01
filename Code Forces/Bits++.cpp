#include <bits/stdc++.h>
using namespace std;

int main()
{
   ios_base::sync_with_stdio(false);
   int t;
   scanf("%d", &t);
   int res = 0;
   while (t--)
   {
      char c[4];
      scanf("%s", c);
      c[3] = '\0';
      if (strcmp(c, "++X") == 0 || strcmp(c, "X++") == 0)
      {
         res++;
      }
      else
      {
         res--;
      }
   }
   printf("%d\n", res);
   return 0;
}