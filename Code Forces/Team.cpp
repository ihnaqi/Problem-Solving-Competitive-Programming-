#include <bits/stdc++.h>
using namespace std;

int main()
{

   ios_base::sync_with_stdio(false);
   int t;
   scanf("%d", &t);

   int count = 0;
   while (t--)
   {
      int a;
      int b;
      int c;
      scanf("%d %d %d", &a, &b, &c);

      count = a + b + c > 1 ? count + 1 : count;
   }
   printf("%d\n", count);
}