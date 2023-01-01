#include <bits/stdc++.h>
using namespace std;

int main()
{

   int t;
   scanf("%d", &t);
   while (t--)
   {
      long long int n;
      long long int p;
      scanf("%lld %lld", &n, &p);

      vector<pair<int, int>> nf;
      for (int i = 0; i < p; i++)
      {
         long long int a, b;
         scanf("%lld %lld", &a, &b);
         nf.push_back(make_pair(min(a, b), max(a, b)));
      }

      nf.push_back(make_pair(n + 1, n + 1));

      sort(nf.begin(), nf.end());

      multiset<long long int> ms;

      for (auto it : nf)
      {
         ms.insert(it.second);
      }

      long long int ans = 0;
      int j = 0;

      for (int i = 1; i <= n; i++)
      {
         ans += *ms.begin() - i;

         while (j < p && nf[j].first == i)
         {
            ms.erase(ms.find(nf[j].second));
            j++;
         }
      }

      printf("%lld\n", ans);
   }

   return 0;
}