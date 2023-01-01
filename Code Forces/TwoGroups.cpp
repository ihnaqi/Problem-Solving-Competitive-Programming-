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
      scanf("%d", &n);

      long long int psum = 0;
      long long int nsum = 0;
      while (n--)
      {
         ;
         long long int a;
         scanf("%lld", &a);
         if (a > 0)
         {
            psum += (long long int)abs(a);
         }
         else
         {
            nsum += (long long int)abs(a);
         }
      }
      printf("%lld\n", (long long int)abs(psum - nsum));
   }

   return 0;
}