#include <bits/stdc++.h>
using namespace std;

int main()
{

   string str;
   string s;

   cin >> str;
   cin >> s;

   vector<vector<int>> v(str.size() + 1, vector<int>(s.size() + 1, 0));

   for (int i = 1; i <= str.size(); i++)
   {
      for (int j = 1; j <= s.size(); j++)
      {
         if (str[i - 1] == s[j - 1])
         {
            v[i][j] = v[i - 1][j - 1] + 1;
         }
         else
         {
            v[i][j] = max(v[i - 1][j], v[i][j - 1]);
         }
      }
   }

   cout << v[str.size()][s.size()] << endl;
}