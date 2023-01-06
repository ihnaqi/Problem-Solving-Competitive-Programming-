#include <bits/stdc++.h>
using namespace std;

int main()
{

   ios_base::sync_with_stdio(false);

   int n;
   scanf("%d", &n);

   char arr[n];
   scanf("%s", arr);

   int ct = 0;

   for (int i = 1; i < n; i++)
   {
      if (arr[i - 1] == arr[i])
      {
         ct++;
      }
   }

   printf("%d\n", ct);
}
