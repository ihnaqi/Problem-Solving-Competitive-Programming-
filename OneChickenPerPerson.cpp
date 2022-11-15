#include <bits/stdc++.h>
using namespace std;

int main()
{

   ios_base::sync_with_stdio(false);
   int p;
   int c;
   scanf("%d %d", &p, &c);

   if (c - p > 0)
   {
      printf("Dr. Chaz will have %d %s of chicken left over!", c - p, (c - p == 1 ? "piece" : "pieces"));
   }
   else if (c - p < 0)
   {
      printf("Dr. Chaz needs %d more %s of chicken!", abs(c - p), (abs(c - p) == 1 ? "piece" : "pieces"));
   }
}