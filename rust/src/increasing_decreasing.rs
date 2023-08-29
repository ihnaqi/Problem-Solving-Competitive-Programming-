//@author: @ihnaqi
//@href: https://www.codeforces.com/contest/1864/problem/A
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
   let x = numbers.next().unwrap().parse::<i32>().unwrap();
   let y = numbers.next().unwrap().parse::<i32>().unwrap();
   let n = numbers.next().unwrap().parse::<usize>().unwrap();

   let mut res = vec![0; n];
   res[0] = x;
   res[n - 1] = y;

   let mut d = 1;

   for i in (1..n - 1).rev() {
      res[i] = res[i + 1] - d;
      d += 1;
   }

   let mut flag = true;

   for i in 0..n - 1 {
      if res[i + 1] <= res[i] {
         flag = false;
         break;
      }
      if i + 2 < n {
         if res[i + 2] - res[i + 1] >= res[i + 1] - res[i] {
            flag = false;
            break;
         }
      }
   }

   if !flag {
      println!("-1");
      return;
   }
   for i in 0..n {
      print!("{} ", res[i]);
   }
   println!();
}
