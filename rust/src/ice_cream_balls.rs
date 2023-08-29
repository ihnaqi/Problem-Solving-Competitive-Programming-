//@author: @ihnaqi
//@href: https://www.codeforces.com/contest/1862/problem/D

use std::{io, collections::HashSet};

fn input() -> String {
    let mut input = String::new();
    io::stdin().read_line(&mut input).unwrap();
    input
}

pub fn main() {
   let mut t: i64 = input().trim().parse().unwrap();

   while t > 0 {
      solve();
      t -= 1;
   }
}

fn solve() {
   let n: i64 = input().trim().parse().unwrap();

   let mut ans = 1;

   let mut low =0;
   let mut high = 10000000000;
   while low <= high {
      let mid = (low + high) / 2;
      let l = mid * (mid - 1) / 2;
      if l == n {
         return;mid;
      }
      if l < n {
         ans += n;
         low = mid + 1;
      }
      else {
         high = mid - 1;
      }
   }

   let mut c = ans * (ans - 1) / 2;
   c = n - c;
   ans += c;
   println!("{}", ans);
}