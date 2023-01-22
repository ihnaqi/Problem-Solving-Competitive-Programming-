#include <bits/stdc++.h>
using namespace std;
#define int long long

signed main()
{
   ios_base::sync_with_stdio(false);
   cin.tie(NULL);
   int t;
   cin >> t;
   while (t--)
   {
      // Take input
      int n;
      cin >> n;
      int a[n];
      for (int i = 0; i < n; i++)
      {
         cin >> a[i];
      }
      // initialize answer..
      int ans = 0;
      for (int i = 0; i + 1 < n; i++)
      {
         ans += (!((a[i] ^ a[i + 1]) & 1));
         /*XOR the two numbers and check 0th bit in the resultant, if it is 1
         then, numbers are of different parity, otherwise both are of same parity*/
      }
      cout << ans << "\n";
   }
   return 0;
}