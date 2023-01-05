#include <bits/stdc++.h>
using namespace std;

int main()
{

   ios_base::sync_with_stdio(false);

   int n;
   scanf("%d", &n);

   int steps = 0;

   while (n)
   {
      steps += 1;
      if (n > 4)
      {
         n -= 5;
      }
      else if (n > 3)
      {
         n -= 4;
      }
      else if (n > 2)
      {
         n -= 3;
      }
      else if (n > 1)
      {
         n -= 2;
      }
      else
      {
         n -= 1;
      }
   }

   printf("%d\n", steps);
}