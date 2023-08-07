//@author: @ihnaqi
//@href: https://codeforces.com/contest/1856/problem/C

#![
   allow(
      unused,
      dead_code,
      clippy::needless_borrow
   )
]

use std::io;
use std::cmp::max;

fn input() -> String {
   let mut s = String::new();
   io::stdin().read_line(&mut s).unwrap();

   s
}

pub fn main() {
   let s = input();
   let mut t = s.trim().parse::<i64>().unwrap();

   while t > 0 {
      solve();
      t -= 1;
   }
}

fn solve() {
   let s = input();
   let mut numbers = s.split_whitespace();
   let n = numbers.next().unwrap().parse::<i64>().unwrap();
   let mut k = numbers.next().unwrap().parse::<i64>().unwrap();
   let mut v: Vec<_> = input().split_whitespace().map(|x| x.parse::<i64>().unwrap()).collect();

   let mut max_value = 0;
   for i in 0..n {
      max(max_value, v[i as usize]);
   }

   let mut dp = vec![0; (n + 1) as usize];

   dp[0] = 0;

   for i in 1..n + 1 {
      dp[i as usize] = max_value;
      for j in 1..i {
         if v[(i - 1) as usize] < v[(i - j - 1) as usize] {
            dp[i as usize] = max(dp[i as usize], dp[j as usize] + v[(i - 1) as usize] + 1);
         }
      }
   }

   for i in 0..k + 1 {
      max_value = max(max_value, dp[i as usize]);
   }

   println!("{}", max_value);
}
