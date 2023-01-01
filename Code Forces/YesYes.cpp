#include <bits/stdc++.h>
using namespace std;

int main()
{

   int n;
   cin >> n;
   while (n--)
   {
      string str;
      cin >> str;

      string s = "";

      for (int i = 0; i < 20; i++)
      {
         s.append("Yes");
      }

      if (s.find(str, 0) != string::npos)
      {
         printf("YES\n");
      }
      else
      {
         printf("NO\n");
      }
   }

   return 0;
}