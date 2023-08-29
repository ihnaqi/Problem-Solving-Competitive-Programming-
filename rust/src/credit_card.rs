//@author: @ihnaqi
//@href: https://www.open.kattis.com/problems/creditcard
//@difficulty: hard
//@category: ad-hoc

use std::io;

const EPS: f64 = 1e-3;
fn input() -> String {
   let mut input = String::new();
   io::stdin().read_line(&mut input)
      .expect("Failed to read line");

   input
}

pub fn main() {
   let s = input();
   let mut n = s.trim().parse::<i32>().unwrap();

   while n > 0 {
      solve();
      n -= 1;
   }
}

fn solve() {
   let s = input();
   let mut numbers = s.trim().split_whitespace();
   let mut r = numbers.next().unwrap().parse::<f64>().unwrap();
   let mut b = numbers.next().unwrap().parse::<f64>().unwrap();
   let m = numbers.next().unwrap().parse::<f64>().unwrap();

   let mut paid = false;
   r /= 100.0;
   for i in 1..=1200 {
      let mut interest = b * r;
      interest = f64::round(interest * 100.0) / 100.0;
      b += interest;
      b = f64::round(b * 100.0) / 100.0;
      b -= m;

      if b < EPS {
         println!("{}", i);
         paid = true;
         break;
      }
   }

   if !paid {
      println!("impossible");
   }

}