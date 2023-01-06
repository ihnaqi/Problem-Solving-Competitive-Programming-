#include <bits/stdc++.h>
using namespace std;

int main()
{

   ios_base::sync_with_stdio(false);
   int n;
   int t;
   scanf("%d %d", &n, &t);

   char str[n];
   scanf("%s", str);

   int i = 0;
   while (i < n - 1)
   {
      int x = t;
      while (x-- > 0)
      {

         if (str[i] == 'B' && str[i + 1] == 'G')
         {
            swap(str[i], str[i + 1]);
            i++;
         }
      }
      i++;
   }

   printf("%s\n", str);
}