#include <bits/stdc++.h>
using namespace std;

int main()
{
   ios_base::sync_with_stdio(false);

   int n;
   scanf("%d", &n);

   n += 1;

   while (1)
   {

      int m = n;
      map<int, int> mp;
      bool rep = false;

      while (m > 0)
      {
         mp[m % 10]++;
         if (mp[m % 10] > 1)
         {
            rep = true;
            break;
         }
         m /= 10;
      }
      if (!rep)
      {
         break;
      }
      n += 1;
   }

   printf("%d\n", n);
}