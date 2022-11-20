#include <bits/stdc++.h>
using namespace std;

int main()
{
   ios_base::sync_with_stdio(false);

   while (true)
   {

      int n;
      scanf("%d", &n);

      if (n == 0)
      {
         break;
      }
      vector<int> A(n);
      vector<int> p(n, -1);

      for (int i = 0; i < n; ++i)
      {
         scanf("%d", &A[i]);
      }

      vector<int> L(n, 0);
      vector<int> L_id(n, 0);
      int k = 0;
      int lis_end = 0;
      for (int i = 0; i < n; ++i)
      {
         int pos = lower_bound(L.begin(), L.begin() + k, A[i]) - L.begin();
         printf("BEGIN: %d, K: %d, POS: %d\n", *L.begin(), k, pos);
         L[pos] = A[i];
         L_id[pos] = i;
         p[i] = pos ? L_id[pos - 1] : -1;

         if (pos == k)
         {
            k = pos + 1;
            lis_end = i;
         }
         else if (pos == k - 1)
         {
            lis_end = i;
         }
      }
      printf("%d ", k);
      vector<int> output;
      while (lis_end != -1)
      {
         output.push_back(A[lis_end]);
         lis_end = p[lis_end];
      }

      for (int i = output.size() - 1; i > -1; i--)
      {
         printf("%d ", output[i]);
      }
      printf("\n");
   }
}