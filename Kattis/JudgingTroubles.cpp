#include <bits/stdc++.h>
using namespace std;

int main()
{

   ios_base::sync_with_stdio(0);
   cin.tie(NULL);

   int n;
   cin >> n;
   unordered_map<string, int> dmj;
   unordered_map<string, int> kat;

   for (int i = 0; i < n; i++)
   {
      string s;
      cin >> s;
      dmj[s]++;
   }

   for (int i = 0; i < n; i++)
   {
      string s;
      cin >> s;
      kat[s]++;
   }

   int res = 0;

   for (unordered_map<string, int>::iterator it = dmj.begin(); it != dmj.end(); it++)
   {
      if (kat.find(it->first) != kat.end())
      {
         res += min(it->second, kat.find(it->first)->second);
      }
   }

   printf("%d\n", res);
}