#include <bits/stdc++.h>
using namespace std;

int main()
{

   int t;
   scanf("%d", &t);

   while (t--)
   {
      int n;
      scanf("%d", &n);

      if (n % 2 == 1)
      {
         for (int i = 0; i < n; i++)
         {
            printf("1 ");
         }
      }
      else
      {
         for (int i = 0; i < n - 2; i++)
         {
            printf("2 ");
         }

         printf("3 1");
      }
      printf("\n");
   }

   return 0;
}