#include <bits/stdc++.h>
using namespace std;

int main()
{
   int t;
   cin >> t;

   while (t--)
   {
      string str;
      cin >> str;

      if (str.length() < 11)
      {
         cout << str << "\n";
      }
      else
      {
         printf("%c%d%c\n", str.at(0), str.size() - 2, str.at(str.size() - 1));
      }
   }
}