#include <bits/stdc++.h>
using namespace std;
using ll = long long;
#ifdef asr_debug
#include "dbg.hpp"
#else
#define dbg(...) 007
#endif

void solve()
{
   auto cnt_inversions_in_binary_array = [&](vector<int> &a) -> ll
   {
      int n = (int)a.size();
      ll ans = 0, cnt1 = 0;
      for (int i = 0; i < n; i++)
      {
         if (a[i] == 0)
         {
            ans += cnt1;
         }
         else
         {
            cnt1++;
         }
      }
      return ans;
   };
   int n;
   cin >> n;
   vector<int> a(n);
   int leftmost_0 = -1, rightmost_1 = -1;
   for (int i = 0; i < n; i++)
   {
      cin >> a[i];
      if (a[i] == 0 && leftmost_0 == -1)
      {
         leftmost_0 = i;
      }
      else if (a[i] == 1)
      {
         rightmost_1 = i;
      }
   }
   ll ans = cnt_inversions_in_binary_array(a);
   dbg(ans);
   if (leftmost_0 != -1)
   {
      auto b = a;
      b[leftmost_0] = 1;
      ans = max(ans, cnt_inversions_in_binary_array(b));
   }
   if (rightmost_1 != -1)
   {
      auto b = a;
      b[rightmost_1] = 0;
      ans = max(ans, cnt_inversions_in_binary_array(b));
   }
   cout << ans << '\n';
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