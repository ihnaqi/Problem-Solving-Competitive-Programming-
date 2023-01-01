#include <bits/stdc++.h>
using namespace std;

int main()
{

   int n;
   cin >> n;

   vector<bool> v(n, true);
   v[0] = v[1] = false;
   for (int i = 2; i * i < n; i++)
   {
      if (v[i])
      {
         for (int j = i * i; j < n; j += i)
         {
            v[j] = false;
         }
      }
   }
   int count = 0;
   for (int i = 0; i < v.size(); i++)
   {
      if (v[i] == true)
      {
         count++;
      }
   }

   cout << count << endl;
}