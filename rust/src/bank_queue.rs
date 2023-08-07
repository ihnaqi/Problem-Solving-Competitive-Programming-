//@author: @ihnaqi
//@href: https://open.kattis.com/contests/b9xfkt/problems/bank
#![allow(unused)]
use std::io;

fn input() -> String {
   let mut s = String::new();
   io::stdin().read_line(&mut s).unwrap();

   s.trim().to_string()
}

pub fn main() {
   let s = input();
   let mut numbers = s.split_whitespace();
   let mut n = numbers.next().unwrap().parse::<i32>().unwrap();
   let mut t = numbers.next().unwrap().parse::<i32>().unwrap();
   let mut v: Vec<(i32, i32)> = Vec::new();

   for i in 0..n {
      let s = input();
      let mut numbers = s.split_whitespace();
      let mut am = numbers.next().unwrap().parse::<i32>().unwrap();
      let mut ti = numbers.next().unwrap().parse::<i32>().unwrap();

      v.push((am, ti));
   }
}