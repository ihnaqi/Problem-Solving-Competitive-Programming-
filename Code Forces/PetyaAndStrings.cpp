#include <bits/stdc++.h>
using namespace std;

int main()
{
   ios_base::sync_with_stdio(false);
   cin.tie(NULL);

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

   if (s.compare(str) > 0)
   {
      printf("1\n");
   }
   else if (s.compare(str) < 0)
   {
      printf("-1\n");
   }
   else
   {
      printf("0\n");
   }
}