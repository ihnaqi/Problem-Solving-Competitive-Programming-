
#include <bits/stdc++.h>
using namespace std;

int main()
{
   ios_base::sync_with_stdio(false);
   int t;
   scanf("%d", &t);

   while (t--)
   {
      long long int n;
      scanf("%lld", &n);

      vector<long long int> v(n, 0);
      map<long long int, long long int> m;

      for (int i = 0; i < n; i++)
      {
         scanf("%d", &v[i]);
         m[v[i]]++;
      }

      sort(v.begin(), v.end());

      if (m.size() == 1)
      {
         long long int res = n * (n - 1);
         printf("%lld\n", res);
      }
      else
      {
         long long int res = m[v[0]] * m[v[n - 1]] * 2;
         printf("%lld\n", res);
      }
   }

   return 0;
}