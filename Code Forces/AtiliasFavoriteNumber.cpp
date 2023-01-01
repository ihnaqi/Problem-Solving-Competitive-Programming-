#include <bits/stdc++.h>
using namespace std;

int main()
{

   ios_base::sync_with_stdio(false);
   int t;
   cin >> t;
   while (t--)
   {
      int a;
      cin >> a;
      string s;
      cin >> s;
      int ans = 0;

      for (int i = 0; i < a; i++)
      {
         ans = max(ans, int(s[i] - 'a'));
      }

      cout << ans + 1 << endl;
   }
}