#include <bits/stdc++.h>

using namespace std;

int matrix[4000][4000] = {0};

int main()
{

   ios_base::sync_with_stdio(false);
   cin.tie(nullptr);
   cout.tie(nullptr);

   int V, E, Q;
   // cin >> V >> E >> Q;
   scanf("%d %d %d", &V, &E, &Q);

   bool trans = false;
   bool neg = false;
   int transV = V;

   for (int i = 0; i < 4000; i++)
   {
      for (int j = 0; j < 4000; j++)
      {
         matrix[i][j] = 0;
      }
   }

   for (int i = 0; i < E; i++)
   {
      int from, to;
      // cin >> from >> to;
      scanf("%d %d", &from, &to);

      matrix[from][to]++;
   }

   for (int i = 0; i < Q; i++)
   {
      int option = 0;
      // cin >> option;
      scanf("%d", &option);

      if (option == 1)
      {
         V++;
         if (neg)
         {
            for (int j = 0; j < V; j++)
            {
               matrix[V - 1][j] = 1;
               matrix[j][V - 1] = 1;
            }
         }
      }
      else if (option == 2)
      {
         int from, to;
         // cin >> from >> to;
         scanf("%d %d", &from, &to);

         if (trans)
            swap(from, to);

         matrix[from][to] = 1 - matrix[from][to];
      }
      else if (option == 3)
      {
         int from;
         // cin >> from;
         scanf("%d", &from);

         for (int j = 0; j < V; j++)
         {
            if (from == j)
               continue;
            matrix[j][from] = neg ? 1 : 0;
            matrix[from][j] = neg ? 1 : 0;
         }
      }
      else if (option == 4)
      {
         int from, to;
         // cin >> from >> to;
         scanf("%d %d", &from, &to);

         if (trans)
            swap(from, to);

         matrix[from][to] = 1 - matrix[from][to];
      }
      else if (option == 5)
      {
         trans = !trans;
         transV = V;
      }
      else
      {
         neg = !neg;
      }
   }

   if (trans)
   {
      for (int i = 0; i < transV; i++)
      {
         for (int j = 0; j <= i; j++)
         {
            swap(matrix[i][j], matrix[j][i]);
         }
      }
   }

   for (int i = 0; i < V; i++)
      matrix[i][i] = 0;

   // cout << V << endl;
   printf("%d\n", V);
   for (int i = 0; i < V; i++)
   {
      int sum = 0;
      uint64_t hash = 0;
      uint64_t current = 1;
      for (int j = 0; j < V; j++)
      {

         if ((!neg && matrix[i][j]) || (neg && matrix[i][j] == 0))
         {
            if (i == j)
               continue;

            hash += current * j;
            current = (current * 7) % 1000000007;
            sum += 1;
            hash = hash % 1000000007;
         }
      }
      // cout << sum << ' ' << hash << endl;
      printf("%d %d\n", sum, hash);
   }

   return 0;
}