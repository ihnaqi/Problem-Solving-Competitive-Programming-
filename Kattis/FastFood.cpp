#include <cstdio>
#include <vector>
#include <bits/stdc++.h>

int main()
{
   std::ios_base::sync_with_stdio(false);
   int total;
   scanf("%d", &total);

   while (total > 0)
   {

      int n;
      int m;
      scanf("%d %d", &n, &m);

      std::vector<std::vector<int>> array;

      for (int i = 0; i < n; i++)
      {
         int k;
         scanf("%d", &k);
         std::vector<int> vect;
         for (int j = 0; j < k; j++)
         {
            int elem;
            scanf("%d", &elem);
            vect.push_back(elem);
         }
         int prize;
         scanf("%d", &prize);
         vect.push_back(prize);
         array.push_back(vect);
      }

      std::vector<int> T;
      for (int i = 0; i < m; i++)
      {
         int num;
         scanf("%d", &num);
         T.push_back(num);
      }

      int money = 0;
      for (int i = 0; i < array.size(); i++)
      {
         bool cashable = true;
         for (int j = 0; j < array[i].size() - 1; j++)
         {
            if (T[array[i][j] - 1] < 1)
            {

               cashable = false;
               break;
            }
         }

         while (cashable)
         {

            money += array[i][array[i].size() - 1];
            for (int j = 0; j < array[i].size() - 1; j++)
            {
               T[array[i][j] - 1] = T[array[i][j] - 1] - 1;
               if (T[array[i][j] - 1] == 0)
               {
                  cashable = false;
                  break;
               }
            }
         }
      }
      printf("%d\n", money);
      total--;
   }

   return 0;
}