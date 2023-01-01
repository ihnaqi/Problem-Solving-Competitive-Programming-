#include <bits/stdc++.h>
using namespace std;

int main()
{
   int a;
   int b;
   scanf("%d %d", &a, &b);

   while (b--)
   {
      if (a % 10 == 0)
      {
         a /= 10;
      }
      else
      {
         a--;
      }
   }
   printf("%d\n", a);
   return 0;
}