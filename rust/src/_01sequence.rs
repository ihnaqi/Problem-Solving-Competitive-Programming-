//@author: @ihnaqi
//@href: https://open.kattis.com/problems/sequences
//@title: 01 Sequence
//@difficulty: Hard

use std::io::{self, BufRead};

const MODULO: i64 = 1000000007;

fn input() -> impl Iterator<Item = String> {
   io::stdin().lock().lines().map(|line| line.unwrap())
}

pub fn main() {
   let mut lines = input();

   let s = lines.next().unwrap();

   let mut ones = 0;
   let mut branch = 1;
   let mut inversion = 0;

   for c in s.chars() {
      if c == '1' {
         ones = (ones + branch) % MODULO;
      }
      else if c == '0' {
         inversion = (inversion + ones) % MODULO;
      }
      else {
         inversion = ((inversion << 1) + ones) % MODULO;
         ones = ((ones << 1) + branch) % MODULO;
         branch = (branch << 1) % MODULO;
      }
   }

   println!("{}", inversion);
}