//@author: @ihnaqi
//@href: https://open.kattis.com/problems/bubbletea
//@difficulty: Medium

#![
   allow(
      dead_code,
      unused
   )
]

use std::{io, collections::HashMap, cmp};

fn input() -> String {
   let mut s = String::new();
   io::stdin().read_line(&mut s).unwrap();

   s
}

pub fn main() {
   let s = input();
   let n = s.trim().parse::<i32>().unwrap();
   let tea: Vec<_> = input().split_whitespace().map(|x| x.parse::<i32>().unwrap()).collect();
   let s = input();
   let m = s.trim().parse::<i32>().unwrap();
   let toppings: Vec<_> = input().split_whitespace().map(|x| x.parse::<i32>().unwrap()).collect();
   let mut map: HashMap<i32, Vec<i32>> = HashMap::new();

   let mut i = 0;
   loop {
      if i == tea.len() {
         break;
      }
      let s = input();
      let mut nums = s.split_whitespace();
      nums.next().unwrap();
      let v: Vec<_> = nums.map(|x| x.parse::<i32>().unwrap()).collect();
      map.insert(tea[i], v);
      i += 1;
   }

   let s = input();
   let total = s.trim().parse::<i32>().unwrap();
   let mut min = 1 << 29;
   let mut max = 0;
   for (key, value) in map.iter() {
      for num in value {
         max = cmp::max(num + key, max);
         min = cmp::min(key + num, min);
      }
   }

   let res = total / min;
   println!("{}", res - 1);
}