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
      char str[n];
      scanf("%s", str);
      int ans = 0;
      set<pair<char, char>> st;

      for (int i = 0; i < n - 1; i++)
      {
         pair<char, char> p = {str[i], str[i + 1]};
         if (st.find(p) != st.end())
         {
            ans = 1;
            break;
         }
         if (i > 0)
         {
            st.insert({str[i - 1], str[i]});
         }
      }

      printf("%s\n", ans ? "YES" : "NO");
   }
}