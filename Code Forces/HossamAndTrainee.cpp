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
      scanf("%d", &n);
      map<int, int> primes;
      vector<int> composite;

      int res = 0;

      for (int i = 0; i < n; i++)
      {
         int d;
         scanf("%d", &d);
         bool added = false;
         for (int j = 2; j <= sqrt(d); j++)
         {
            if (d % j == 0)
            {
               composite.push_back(d);
               added = 1;
               break;
            }
         }
         if (!added)
         {

            primes[d]++;
            if (primes[d] > 1)
            {
               res = 1;
            }
         }
      }

      if (res == 1)
      {
         printf("YES\n");
      }
      else
      {
         for (int i = 0; res < 2 && i < composite.size(); i++)
         {
            for (int j = i + 1; j < composite.size(); j++)
            {
               int dividend = max(composite[i], composite[j]);
               int divisor = min(composite[i], composite[j]);
               int rem;
               while ((rem = dividend % divisor) != 0)
               {
                  int temp = dividend;
                  dividend = max(divisor, rem);
                  divisor = min(divisor, rem);
               }
               res = divisor;
               if (divisor > 1)
               {
                  break;
               }
            }
         }

         printf("%s\n", res > 1 ? "YES" : "NO");
      }
   }
}