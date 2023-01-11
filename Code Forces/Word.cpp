#include <bits/stdc++.h>
using namespace std;

int main()
{
   ios_base::sync_with_stdio(0);
   cin.tie(NULL);

   string s;
   cin >> s;

   int upper = 0;
   for (const &c : s)
   {
      if (isupper(c))
      {
         upper++;
      }
   }

   if (upper > s.size() / 2)
   {
      for (char &c : s)
      {
         putchar(toupper(c));
      }
   }
   else
   {
      for (char &c : s)
      {
         putchar(tolower(c));
      }
   }

   printf("\n");
}