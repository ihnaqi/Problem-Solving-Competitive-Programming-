//@author: @ihnaqi
//@href: https://open.kattis.com/problems/canonical
//@title: Canonical Coin System
//@difficult: Medium

use std::io::{self, BufRead};
const INF: i32 = 1 << 29;
const MAXV: usize = 2000006;

fn input() -> impl Iterator<Item = String> {
   io::stdin().lock().lines().map(|line| line.unwrap())
}

pub fn main() {
   let mut lines = input();

   let n = lines.next().unwrap().parse::<i32>().unwrap();

   let mut v: Vec<_> = lines.next().unwrap().split_whitespace().map(|x| x.parse::<i32>().unwrap()).collect();

   let mut dp = vec![INF; MAXV];
   let mut greedy = vec![INF; MAXV];

   v.sort();
   dp[0] = 0;
   greedy[0] = 0;

   let mut index = 0;
   let mut is_canonical = true;

   for i in 1..MAXV {
      while index < n - 1 && v[index as usize + 1] <= i as i32 {
         index += 1;
      }

      greedy[i] = greedy[i - v[index as usize] as usize] + 1;

      for j in 0..n {
         if j < n && v[j as usize] <= i as i32 {
            dp[i] = std::cmp::min(dp[i], dp[i - v[j as usize] as usize] + 1);
         }
      }

      if greedy[i] != dp[i] {
         is_canonical = false;
         break;
      }
   }

   if is_canonical {
      println!("canonical");
   }
   else {
      println!("non-canonical");
   }
}