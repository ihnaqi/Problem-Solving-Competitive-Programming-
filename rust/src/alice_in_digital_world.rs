//@author: @ihnaqi
//@href: https://open.kattis.com/problems/alicedigital
//@title: Alice in the Digital World
//@difficulty: Medium

#![
   allow(
      dead_code,
      unused,
      clippy::needless_borrow
   )
]

use std::io;
use std::cmp;

fn input() -> String {
   let mut s = String::new();
   io::stdin().read_line(&mut s).unwrap();

   s.trim().to_string()
}

pub fn main(){
   let s = input();
   let mut t = s.parse::<i32>().unwrap();

   while t > 0 {
      solve();
      t -= 1;
   }
}

fn solve() {
   let s = input();
   let mut numbers = s.split_whitespace();
   let n = numbers.next().unwrap().parse::<usize>().unwrap();
   let m = numbers.next().unwrap().parse::<i32>().unwrap();

   let v: Vec<_> = input().split_whitespace().map(|x| x.parse::<i32>().unwrap()).collect();
   let mut i = 0;
   let mut res = 0;

   while i < n{
      if v[i] < m {
         i += 1;
         continue;
      }
      let mut j = i;
      let mut m_count = 0;
      let mut curr_sum = 0;
      let mut prev_m_index = 0;

      while j < n && v[j] >= m{
         if v[j] == m {
            if m_count == 0 {
               prev_m_index = j;
            }
            m_count += 1;
         }
         if m_count > 1 {
            break;
         }
         curr_sum += v[j];
         j += 1;
      }

      if m_count > 0 {
         res = cmp::max(res, curr_sum);
      }

      if prev_m_index == 0 {
         i = j;
      }
      else {
         i = prev_m_index + 1;
      }
   }

   println!("{}", res);
}