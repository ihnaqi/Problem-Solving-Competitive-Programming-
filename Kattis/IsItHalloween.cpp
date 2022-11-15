#include <bits/stdc++.h>
using namespace std;

int main()
{

   ios_base::sync_with_stdio(false);
   string m;
   int d;
   cin >> m >> d;
   if ((m.compare("OCT") == 0 && d == 31) || (m.compare("DEC") == 0 && d == 25))
   {
      printf("yup\n");
   }
   else
   {
      printf("nope\n");
   }
   return 0;
}