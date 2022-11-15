#include <cstdio>
#include <bits/stdc++.h>
using namespace std;
int main()
{
   ios_base::sync_with_stdio(false);

   int n;
   scanf("%d", &n);
   unordered_map<string, vector<int>> map;
   while (n > 0)
   {
      string str;
      scanf("%s", &str);
      string country = str.substr(0, str.find_last_of(' '));
      int year = stoi(str.substr(str.find_last_of(' '), 4));
      if (map.count(country) == 0)
      {
         vector<int> vect;
         vect.push_back(year);
         map[country] = vect;
      }
      else
      {
         map[country].push_back(year);
      }
      n--;
   }

   // for (const auto &key_value : map)
   // {
   //    for (const auto &i : key_value.second)
   //        sort(i.begin(), i.end());
   // }

   scanf("%d", &n);
   while (n > 0)
   {
      string str;
      scanf("%d", &str);
      string country = str.substr(0, str.find_last_of(' '));
      int index = stoi(str.substr(str.find_last_of(' ') + 1, str.length() - str.find_last_of(' ')));
      scanf("%s %d", &country, &index);

      printf("%d", map[country][index - 1]);
      n--;
   }

   return 0;
}