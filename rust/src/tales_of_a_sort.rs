//@author: @ihnaqi
//@href: https://codeforces.com/contest/1856/problem/0

use std::io;
use std::cmp;

fn input() -> String {
   let mut s = String::new();
   io::stdin().read_line(&mut s).unwrap();

   s
}

pub fn main() {
   let s = input();
   let mut t = s.trim().parse::<i32>().unwrap();

   while t > 0 {
      solve();
      t -= 1;
   }
}

fn solve() {
   let s = input();
   let n = s.trim().parse::<i32>().unwrap();
   let mut v: Vec<_> = input().split_whitespace().map(|x| x.parse::<i32>().unwrap()).collect();

   if is_sorted(&v) {
      println!("0");
   }
   else {
      let mut res = -1;
      for i in (1..=n-1).rev() {
         if v[i as usize] >= v[(i - 1) as usize] {
            continue;
         }
         else {
            res = i;
            break;
         }
      }
      let mut max = v[0];
      for i in 1..=res {
         max = cmp::max(max, v[i as usize]);
      }
      println!("{}", max);
   }
}

fn is_sorted(v: &Vec<i32>) -> bool {

   for i in 1..v.len() {
      if v[i] < v[i - 1] {
         return false;
      }
   }
   true
}