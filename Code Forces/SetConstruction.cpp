#include <bits/stdc++.h>
using namespace std;

int main()
{
   int t;
   cin >> t;

   while (t--)
   {
      int n;
      cin >> n;

      char a[n][n];
      for (int i = 0; i < n; i++)
      {
         for (int j = 0; j < n; j++)
         {
            cin >> a[i][j];
         }
      }

      vector<vector<int>> ans;

      for (int i = 0; i < n; i++)
      {
         ans.push_back({i + 1});
      }
      int ind[n];
      for (int i = 0; i < n; i++)
      {
         ind[i] = 0;
      }
      vector<vector<int>> adj;
      for (int i = 0; i < n; i++)
      {
         adj.push_back({});
         for (int j = 0; j < n; j++)
         {
            if (a[i][j] == '1')
            {
               adj[i].push_back(j);
               ind[i]++;
            }
         }
      }

      queue<int> q;

      for (int i = 0; i < n; i++)
      {
         if (ind[i] == 0)
         {
            q.push(i);
         }
      }

      while (!q.empty())
      {
         int x = q.front();
         q.pop();
         for (int i = 0; i < adj[x].size(); i++)
         {
            int c = adj[x][i];
            ind[c]--;
            ans[c].push_back(x + 1);
            if (ind[c] == 0)
            {
               q.push(c);
            }
         }

         for (int i = 0; i < n; i++)
         {
            cout << ans[i].size() << " ";
            sort(ans[i].begin(), ans[i].end());
            for (int j = 0; j < ans[i].size(); j++)
            {
               cout << ans[i][j] << " ";
            }
            cout << "\n";
         }
      }
   }
}