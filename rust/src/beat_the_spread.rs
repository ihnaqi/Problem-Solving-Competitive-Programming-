//@author: @ihnaqi
//@href: https://www.open.kattis.com/prblems/beatspread
//@difficulty: Easy
//@category: ad-hoc

use std::io;

fn input() -> String {
   let mut input = String::new();
   io::stdin().read_line(&mut input)
      .expect("Failed to read line");

   input
}

pub fn main() {
   let s = input();
   let mut n: i32 = s.trim().parse().unwrap();

   while n > 0 {
      solve();
      n -= 1;
   }
}

fn solve() {
   let s = input();
   let mut numbers = s.trim().split_whitespace();
   let s = numbers.next().unwrap().parse::<i32>().unwrap();
   let d = numbers.next().unwrap().parse::<i32>().unwrap();

   if d > s {
      println!("impossible");
      return;
   }

   for i in 0..=s {
      for j in 0..=i {
         if i + j == s && (i - j).abs() == d {
            println!("{} {}", i, j);
            return;
         }
      }
   }
   println!("impossible");
}