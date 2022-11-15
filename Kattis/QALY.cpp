#include <bits/stdc++.h>
using namespace std;

int main()
{

   ios_base::sync_with_stdio(false);

   int t;
   scanf("%d", &t);
   double sum = 0;
   while (t--)
   {
      double qaly;
      double yrs;

      scanf("%lf %lf", &qaly, &yrs);

      sum += (qaly * yrs);
   }

   printf("%.3lf\n", sum);

   return 0;
}