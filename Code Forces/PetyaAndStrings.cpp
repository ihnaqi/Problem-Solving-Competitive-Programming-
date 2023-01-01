#include <bits/stdc++.h>
using namespace std;

int main()
{
   ios_base::sync_with_stdio(false);

   string s;
   string str;
   cin >> s;
   cin >> str;
   for (char &c : s)
   {
      c = tolower(c);
   }

   for (char &c : str)
   {
      c = tolower(c);
   }

   int a = 0;
   int b = 0;

   int count = 1;
   for (int i = 0; i < s.size(); i++)
   {
      if (s[i] - 'a' > s[i - 1] - 'a')
      {
         count += s[i] - 'a';
      }
      else if (s[i] - 'a' < s[i - 1] - 'a')
      {
         break;
      }
   }

   int count2 = 1;
   for (int i = 0; i < str.size(); i++)
   {
      if (str[i] - 'a' > str[i - 1] - 'a')
      {
         count2 += str[i] - 'a';
      }
      else if (str[i] - 'a' < str[i - 1] - 'a')
      {
         break;
      }
   }

   if (count == count2)
   {
      cout << 0 << endl;
   }
   else if (count > count2)
   {
      cout << 1 << endl;
   }
   else
   {
      cout << -1 << endl;
   }
}