#include <bits/stdc++.h>
using namespace std;

int main()
{

   ios_base::sync_with_stdio(false);
   int n;
   int t;
   scanf("%d %d", &n, &t);

   char s[n];
   scanf("%s", s);

   while (t--)
   {
      for (int i = 0; i < n; i++)
      {

         if (s[i] == 'G' && s[i - 1] == 'B')
         {
            s[i] = 'B';
            s[i - 1] = 'G';
            ++i;
         }
      }
   }

   printf("%s\n", s);
}