//@author: @ihnaqi
//@href: https://www.codeforces.com/contest/1864/problem/B
//@date: 2023-08-26
//@category: greedy

use std::io;

fn input() -> String {
    let mut input = String::new();
    io::stdin()
        .read_line(&mut input)
        .expect("Error reading input");
    input
}

pub fn main() {
    let mut t: i32 = input().trim().parse().unwrap();

    while t > 0 {
        solve();
        t -= 1;
    }
}

fn solve() {
    let s = input();
    let mut numbers = s.trim().split_whitespace();
    let n = numbers.next().unwrap().parse::<usize>().unwrap();
    let k = numbers.next().unwrap().parse::<usize>().unwrap();
    let mut v: Vec<char> = input().trim().chars().collect();

   if k % 2 == 0 {
      v.sort();
      for c in v {
         print!("{}", c);
      }
      println!("");
      return;
   }

   let mut even: Vec<char> = Vec::new();
   let mut odd: Vec<char> = Vec::new();

   for i in 0..n {
      if i % 2 == 0 {
         even.push(v[i]);
      }
      else {
         odd.push(v[i]);
      }
   }

   even.sort();
   odd.sort();

   let mut ans: Vec<char> = Vec::new();

   let mut i = 0;
   let mut j = 0;

   while j < even.len() || i < odd.len() {
      if j < even.len() {
         ans.push(even[j]);
         j += 1;
      }
      if i < odd.len() {
         ans.push(odd[i]);
         i += 1;
      }
   }

   for c in ans {
      print!("{}", c);
   }
   println!();
}
