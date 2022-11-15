#include <bits/stdc++.h>

int main()
{

   std::ios_base::sync_with_stdio(false);
   int num;
   scanf("%d", &num);
   while (1 < 2)
   {
      int digitSum = 0;
      int n = num;
      while (n > 0)
      {
         digitSum += n % 10;
         n = n / 10;
      }
      if (num % digitSum == 0)
      {
         printf("%d\n", num);
         break;
      }
      num++;
   }

   return 0;
}