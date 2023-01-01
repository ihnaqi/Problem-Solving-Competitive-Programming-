#include <bits/stdc++.h>
using namespace std;

int main()
{
   ios_base::sync_with_stdio(false);

   double a;
   double b;
   scanf("%lf %lf", &a, &b);
   int i = 0;
   while (a / b <= 1)
   {
      a *= 3;
      b *= 2;
      i++;
   }

   printf("%d\n", i);
}