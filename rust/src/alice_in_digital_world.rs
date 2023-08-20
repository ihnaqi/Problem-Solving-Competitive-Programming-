//@author: @ihnaqi
//@href: https://open.kattis.com/problems/alicedigital
//@difficulty: Medium

use std::{io, cmp::max};

fn input() -> String {
   let mut s = String::new();

   io::stdin().read_line(&mut s).unwrap();

   s
}

pub fn main() {
   let s = input();
   let mut t = s.trim().parse::<i32>().unwrap();

   while t > 0 {
      let s = input();
      let mut numbers = s.trim().split_whitespace();
      let n = numbers.next().unwrap().parse::<i32>().unwrap();
      let m = numbers.next().unwrap().parse::<i32>().unwrap();
      solve(n, m);
      t -= 1;
   }
}

fn solve(n: i32, m: i32) {
   let vec: Vec<_> = input().trim().split_whitespace().map(|x| x.parse::<i32>().unwrap()).collect();
   let mut res = 0;
   let mut curr_sum = 0;
   let mut m_count = 0;
   // let mut v = vec![0; vec.len()];

   for i in 0..n {
      let num = vec[i as usize];
      if num < m {
         if m_count > 0 {
            res = max(res, curr_sum);
         }
         m_count = 0;
         curr_sum = 0;
      }
      else if m == num {
         if m_count > 0 {
            let mut j = i as usize - 1;
            let mut temp = 0;
            while j > 0 {
               if vec[j] == m {
                  break;
               }
               temp += vec[j];
               j -= 1;
            }
            res = max(res, curr_sum);
            curr_sum = temp;
            m_count += 1;
         }
         curr_sum += num;
         m_count += 1;
      }
      else {
         curr_sum += num;
      }
   }

   if m_count > 0 {
      res = max(res, curr_sum);
   }

   println!("{}", res);
}
// Example test cases
/*

2
6 2
1 3 2 6 2 4
10 3
4 7 8 12 14 1 3 7 4 3

*/