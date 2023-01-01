#include <bits/stdc++.h>
using namespace std;
#define ll long long

int main()
{
   int t;
   cin >> t;
   while (t--)
   {
      int a;
      cin >> a;
      vector<ll> h(a);
      for (int i = 0; i < a; i++)
      {
         cin >> h[i];
      }
      vector<ll> h2 = h;

      sort(h.begin(), h.end());
      ll max = h[a - 1];
      ll secmax = h[a - 2];

      for (int i = 0; i < a; i++)
      {
         if (h2[i] == max)
         {
            cout << max - secmax << " ";
         }
         else
         {
            cout << h2[i] - max << " ";
         }
      }
      cout << endl;
   }
   return 0;
}