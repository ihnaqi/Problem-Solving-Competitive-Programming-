#include <bits/stdc++.h>
using namespace std;

int main()
{

   ios_base::sync_with_stdio(0);

   int n;
   int x;
   int y;
   scanf("%d %d %d", &n, &x, &y);

   n /= 2;

   if ((x == n || x == n + 1) && (y == n || y == n + 1))
   {
      printf("NO\n");
   }
   else
   {
      printf("YES\n");
   }
}