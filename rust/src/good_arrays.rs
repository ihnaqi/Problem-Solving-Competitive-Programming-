//@author: @ihnaqi
//@href: https://codeforces.com/contest/1856/problem/B

#![
   allow(
      unused,
      dead_code,
      clippy::needless_borrow
   )
]
use std::collections::HashSet;
use std::io;

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
   let n = s.trim().parse::<i64>().unwrap();
   let mut v: Vec<_> = input().split_whitespace().map(|x| x.parse::<i64>().unwrap()).collect();

   let mut count = 0;
   let mut sum = 0;

   for i in &v {
      if *i == 1 {
         count += 1;
      }
      sum += *i;
   }

   if sum - n >= count && n != 1 {
      println!("YES");
   }
   else {
      println!("NO");
   }
}
