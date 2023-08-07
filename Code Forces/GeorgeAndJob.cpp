#include<bits/stdc++.h>
using namespace std;

typedef long long int lli;
typedef pair<int, int> ii;
void solve();
int main(int argc, char const *argv[]){
  ios_base::sync_with_stdio(false);
  solve();
}
void solve(){
  int n, m, k;
  scanf("%d %d %d", &n, &m, &k);

  lli dp[k+10][n+10];
  memset(dp, 0, sizeof dp);

  lli a[n+1];
  for(int i=1;i<=n;i++){
    scanf("%lld", &a[i]);
  }
  lli b[n+10] = {0};
  for(int i=1;i<=n;i++){
    b[i] = b[i-1] + a[i];
  }

  for(int i=1;i<=k;i++){
    for(int j=i*m;j<=n;j++){
      dp[i][j] = max(dp[i][j-1], dp[i-1][j-m] + b[j]-b[j-m]);
    }
  }

  printf("%lld\n", dp[k][n]);
}