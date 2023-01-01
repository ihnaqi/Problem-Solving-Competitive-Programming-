#include <bits/stdc++.h>
using namespace std;

int main()
{
   ios_base::sync_with_stdio(false);
   int t;
   scanf("%d", &t);
   while (t--)
   {
      int n;
      int x;
      scanf("%d %d", &n, &x);

      int k = n / x;
      if (n % x != 0 || n >> 16 == x)
      {
         printf("-1\n");
         continue;
      }

      vector<int> v;
      v.push_back(0);
      v.push_back(x);

      for (int i = 2; i < n; i++)
      {
         if (k == 200)
         {
            printf("-1\n");
            continue;
         }
         v.push_back(i);
      }

      v.push_back(1);

      for (int i = 2; i < 50 && i * i <= n / x; i++)
      {
         while (n / x % i == 0)
         {
            v[x] = x * i;
            x = x * i;
         }
      }
      if (x < n)
      {
         v[x] = n;
      }

      for (int i = 1; i <= n; i++)
      {
         printf("%d ", v[i]);
      }
      printf("\n");
   }
}