#include <bits/stdc++.h>
using namespace std;
#define ll long long int

int main()
{

   ios_base::sync_with_stdio(false);

   ll t;
   scanf("%lld", &t);

   while (t--)
   {

      ll n;
      scanf("%lld", &n);

      vector<ll> v(n);
      ll sum = 0;

      for (auto i = 0; i < n; i++)
      {
         scanf("%lld", &v[i]);
         sum = sum + v[i];
      }

      if (!(sum & 1))
      {
         printf("0\n");
      }
      else
      {
         ll res = 1 << 29;

         for (auto i = 0; i < n; i++)
         {
            ll now = 0;
            ll curr = v[i];
            while (!((curr + v[i]) & 1))
            {
               now++;
               curr = curr / 2;
            }

            res = min(now, res);
         }

         printf("%lld\n", res);
      }
   }
}