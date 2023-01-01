#include <bits/stdc++.h>
using namespace std;
using ll = long long;
#ifdef asr_debug
#include "dbg.hpp"
#else
#define dbg(...) 007
#endif
const ll inf = 1e18;
void solve()
{
   ll n, c, d;
   cin >> n >> c >> d;
   vector<ll> a(n);
   for (ll i = 0; i < n; i++)
      cin >> a[i];
   sort(a.rbegin(), a.rend());
   auto works = [&](ll k)
   {
      ll sum = accumulate(a.begin(), a.begin() + min(k, ll(n)), 0LL);
      ll poss = (d / k) * sum + accumulate(a.begin(), a.begin() + min(ll(d % k), ll(n)), 0LL);
      return poss >= c;
   };
   ll lo = 0;
   ll hi = inf;
   while (lo < hi)
   {
      ll mid = (lo + hi + 1) / 2;
      if (works(mid))
      {
         lo = mid;
      }
      else
      {
         hi = mid - 1;
      }
   }
   cout << (lo == 0 ? "Impossible" : (lo == inf ? "Infinity" : to_string(lo - 1))) << '\n';
}
int main()
{
   cin.tie(nullptr)->sync_with_stdio(false);
   cout << setprecision(15) << fixed;
   int TT = 1;
   cin >> TT;
   while (TT--)
   {
      solve();
   }
   return 0;
}