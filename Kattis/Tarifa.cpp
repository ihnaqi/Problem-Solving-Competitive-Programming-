#include <bits/stdc++.h>
using namespace std;

int main()
{
   ios_base::sync_with_stdio(false);

   int x;
   scanf("%d", &x);
   int n;
   scanf("%d", &n);
   int sum = x;
   while (n--)
   {
      int y;
      scanf("%d", &y);
      sum += x - y;
   }

   printf("%d\n", sum);
}