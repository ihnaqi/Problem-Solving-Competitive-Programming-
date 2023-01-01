#include <bits/stdc++.h>
using namespace std;

int main()
{
   ios_base::sync_with_stdio(false);
   cin.tie(NULL);
   cout.tie(NULL);

   int t;
   cin >> t;
   while (t--)
   {
      string str;
      cin >> str;
      cout << str;
      reverse(str.begin(), str.end());
      cout << str << endl;
   }

   return 0;
}