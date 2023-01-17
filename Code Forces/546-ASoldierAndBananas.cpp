#include <bits/stdc++.h>
using namespace std;

int main()
{

   ios_base::sync_with_stdio(0);

   int k;
   int n;
   int w;

   scanf("%d %d %d", &k, &n, &w);
   int t = 0;
   for (int i = 1; i <= w; i++)
   {
      t += (i * k);
   }

   printf("%d\n", t - n > 0 ? t - n : 0);
}
