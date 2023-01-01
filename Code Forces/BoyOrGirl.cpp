#include <bits/stdc++.h>
using namespace std;

int main()
{

   ios_base::sync_with_stdio(false);
   string str;
   scanf("%s", str[0]);

   map<char, int> D;

   for (int i = 0; i < str.size(); i++)
   {
      D[str.at(i)]++;
   }
   printf("%s\n", str);
   printf("%d\n", str.size());
   printf("%d\n", D.size());

   printf("%s\n", D.size() % 2 == 1 ? "IGNORE HIM!" : "CHAT WITH HER!");
}