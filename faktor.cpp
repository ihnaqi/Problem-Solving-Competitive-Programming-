#include <bits/stdc++.h>
using namespace std;

int main()
{

   ios_base::sync_with_stdio(false);
   int n;
   int m;
   scanf("%d %d", &n, &m);
   m = m - 1;

   printf("%d\n", (n * m) + 1);
   return 0;
}