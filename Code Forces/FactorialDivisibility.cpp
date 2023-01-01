#include <bits/stdc++.h>
using namespace std;

int main()
{
   int n;
   int x;
   scanf("%d %d", &n, &x);
   long long int fact = 1;
   while (x > 0)
   {
      fact *= x;
      x--;
   }
   long long int sum = 0;
   map<int, int> m;
   while (n-- > 0)
   {
      int a_i;
      scanf("%d", &a_i);
      try
      {
         int res = m.at(a_i);
         sum += res;
      }
      catch (const out_of_range &e)
      {
         int prod = 1;
         int num = a_i;
         while (num > 0)
         {
            prod *= num;
            num--;
         }
         m[a_i] = prod;
         sum += prod;
         continue;
      }
   }
   printf("%s\n", (sum % fact) == 0 ? "Yes" : "No");
   return 0;
}