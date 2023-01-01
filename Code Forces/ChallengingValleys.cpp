#include <bits/stdc++.h>
using namespace std;
#define ll long long;

int main()
{
   int t;

   cin >> t;
   while (t--)
   {
      int r;
      cin >> r;
      int array[r];
      for (int i = 0; i < r; i++)
      {
         cin >> array[i];
      }

      int f = 1;

      for (int i = 0; i < r - 1 and f == 1; i++)
      {
         if (array[i] < array[i + 1])
         {
            f = 0;
            while (array[i + 1] >= array[i] and i < r - 1)
            {
               i++;
            }
            if (i == r - 1)
            {
               cout << "YES" << endl;
               break;
            }
            else
            {
               cout << "NO" << endl;
            }
         }
      }
      if (f == 1)
      {
         cout << "YES" << endl;
      }
   }
   return 0;
}