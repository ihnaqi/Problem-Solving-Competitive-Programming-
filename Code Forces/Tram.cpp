#include <bits/stdc++.h>
using namespace std;

int main()
{
   ios_base::sync_with_stdio(false);

   int t;
   scanf("%d", &t);

   int m = 0;
   int p = 0;
   while (t--)
   {
      int in;
      int out;
      scanf("%d %d", &out, &in);

      p -= out;
      p += in;

      m = max(p, m);
   }

   printf("%d\n", m);
}