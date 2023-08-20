//@author: @ihnaqi
//@href: https://open.kattis.com/problems/election
//@title: Election (Kattis)
//@difficulty: Hard

use std::io::{self, BufRead};

fn input() -> impl Iterator<Item = String> {
   io::stdin().lock().lines().map(|line| line.unwrap())
}

pub fn main() {
   let mut lines = input();
   let mut t = lines.next().unwrap().parse::<i32>().unwrap();

   while t > 0 {
      solve(
         lines.next().unwrap().parse::<i32>().unwrap(),
         lines.next().unwrap().parse::<i32>().unwrap(),
         lines.next().unwrap().parse::<i32>().unwrap(),
         lines.next().unwrap().parse::<i64>().unwrap()
      );
      t -= 1;
   }
}

fn solve(n: i32, v1: i32, v2: i32, w: i64) {
   let mut left = n - v1 - v2;
   let needed = (n >> 1) + 1 - v1;

   if (n & 1) != 0 && v2 > (n >> 1) || (n & 1) == 0 && v2 >= (n >> 1) {
      println!("RECOUNT!");
      return;
   }

   if v1 > (n >> 1) {
      println!("GET A CRATE OF CHAMPAGNE FROM THE BASEMENT");
      return;
   }
   let factor = 0.5.powf(left);
   let sum: i64 = 0;

   for i in 0..needed {
      sum += bc[left][i];
   }

   factor *= sum;
}