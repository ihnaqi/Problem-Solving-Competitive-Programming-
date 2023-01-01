#include <bits/stdc++.h>
using namespace std;

int main()
{
   ios_base::sync_with_stdio(false);
   int t;

   scanf("%d", &t);
   while (t--)
   {
      int a;
      int b;
      int c;
      scanf("%d %d %d", &a, &b, &c);
      int sum = a + b + c;

      int mx = max(a, max(b, c));
      int mn = min(a, min(b, c));
      printf("%d\n", sum - mx - mn);
   }
   return 0;
}