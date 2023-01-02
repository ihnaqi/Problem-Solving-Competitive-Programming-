#include <bits/stdc++.h>
using namespace std;

int main()
{
   ios_base::sync_with_stdio(false);
   int S = (300005);
   int t;
   scanf("%d", &t);
   int bs[2];
   char s[S];

   while (t--)
   {
      int n;
      scanf("%d", &n);
      scanf("%s", s + 1);

      bs[0] = 0;
      bs[1] = 0;

      for (int i = 1; i < n; i++)
      {
         bs[s[i] - 48] = i;
         if (s[i] == 48)
         {
            printf("%d ", bs[1] + 1);
         }
         else
         {
            printf("%d ", bs[0] + 1);
         }
      }
      putchar('\n');
   }
}