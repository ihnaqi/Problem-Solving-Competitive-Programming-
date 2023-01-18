#include<bits/stdc++.h>

using namespace std;

void work()
{
   int n;
   cin >> n;
   cout << n << ' ';
   for (int i = 1; i < n; i++)
      cout << i << ' ';
   cout << endl;
}

int main()
{
   int casenum = 1;
   cin >> casenum;
   for (int testcase = 1; testcase <= casenum; testcase++)
      work();
   return 0;
}