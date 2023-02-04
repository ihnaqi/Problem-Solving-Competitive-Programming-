#include<bits/stdc++.h>
using namespace std;

int main(){

   ios_base::sync_with_std(false);

   int t;
   scanf("%d", &t);
   
   int res = 0;

   while(t --){
      int p;
      int q;

      scanf("%d %d", &p, &q);
      if(q - p <= 2){
         res ++;
      }
   }

   printf("%d\n", res);
}