//@author: @ihnaqi
//@href: https://open.kattis.com/problems/suspensionbridges
//@difficulty: Medium


#![
   allow(
      dead_code,
      unused,
      clippy::needless_borrow
   )
]

use std::io;
use std::f64;

fn input() -> String {
   let mut s = String::new();
   io::stdin().read_line(&mut s).unwrap();

   s
}

pub fn main() {
   let s = input();
   let mut numbers = s.trim().split_whitespace();
   let d = numbers.next().unwrap().parse::<f64>().unwrap();
   let s = numbers.next().unwrap().parse::<f64>().unwrap();

   let mut low = 0.0;
   let mut high = 1e18;
   let mut count = 0;

   while count < 300 {
      let mid = (low + high) / 2.0;

      if mid * f64::cosh(d / (2.0 * mid)) - mid >= s {
         low = mid;
      }
      else {
         high = mid;
      }
      count += 1;
   }

   let x = d / (2.0 * high);
   let mut x_exp = f64::powf(std::f64::consts::E, x) - f64::powf(std::f64::consts::E, -x);
   x_exp /= 2.0;
   let res = 2.0 * high * x_exp;
   println!("{:.8}", res);
}