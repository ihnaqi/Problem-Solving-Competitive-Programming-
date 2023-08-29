//@author: @ihnaqi
//@href: https://www.codeforces.com/contest/1862/problem/C

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
   let v: Vec<i64> = input().trim().split(" ").map(|x| x.parse().unwrap()).collect();
   let mut u = v.clone();
   u.sort();

   if u[n as usize / 2] == v[n as usize / 2] {
      println!("YES");
   } else {
      println!("NO");
   }

}