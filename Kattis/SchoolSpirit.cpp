#include <bits/stdc++.h>
using namespace std;

inline double calc(vector<double> v)
{
   double avg = 0.0;
   for (int i = 0; i < v.size(); i++)
   {
      avg += (v[i] * pow(4.0 / 5.0, i));
   }

   return avg / 5.0;
}

int main()
{

   ios_base::sync_with_stdio(0);

   int n;
   scanf("%d", &n);

   vector<double> A(n);

   for (int i = 0; i < n; i++)
   {
      scanf("%lf", &A[i]);
   }

   printf("%0.6lf\n", calc(A));

   double sum = 0.0;

   for (int i = 0; i < n; i++)
   {
      vector<double> v;
      v.assign(A.begin(), A.end());
      v.erase(v.begin() + i);
      sum += calc(v);
   }

   printf("%0.6lf\n", sum / n);
}