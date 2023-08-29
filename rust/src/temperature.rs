//@author: @ihanqi
//@href: https://open.kattis.com/problems/temperature
//@difficulty: Easy

use std::io;

fn input() -> String {
   let mut s = String::new();
   io::stdin().read_line(&mut s).unwrap();

   s
}

pub fn main() {
   let s = input();
   let mut nums = s.trim().split_whitespace();
   let x = nums.next().unwrap().parse::<f32>().unwrap();
   let y = nums.next().unwrap().parse::<f32>().unwrap();
   if x == 0.0  && y == 1.0{
      println!("ALL GOOD");
   }
   else if y == 1.0 {
      println!("IMPOSSIBLE");
   }
   else {
      println!("{:.6}", -1.0 * (x / (y - 1.0)));
   }
}