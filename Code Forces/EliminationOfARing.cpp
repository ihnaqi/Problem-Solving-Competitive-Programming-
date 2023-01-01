#include <bits/stdc++.h>
using namespace std;

int main()
{

   int t;
   cin >> t;
   while (t--)
   {

      int n;
      scanf("%d", &n);
      vector<int> a(n);

      for (int i = 0; i < n; i++)
      {
         scanf("%d", &a[i]);
      }

      set<int> st;

      for (auto x : a)
      {
         st.insert(x);
      }

      if (st.size() > 2)
      {
         printf("%d\n", n);
         continue;
      }
      if (st.size() == 1)
      {
         printf("%d\n", 1);
         continue;
      }

      printf("%d\n", 2 + (n - 2) / 2);
   }

   return 0;
}