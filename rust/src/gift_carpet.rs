//@author: @ihnaqi
//@href: https://codeforces.com/contest/1862/problem/A

#![
   allow(
      dead_code,
      unused
   )
]

use std::io;

fn input() -> String {
   let mut buffer = String::new();
   io::stdin().read_line(&mut buffer).expect("Failed");
   buffer
}

pub fn main() {
   let s = input();
   let mut t = s.trim().parse::<i32>().unwrap();

   while t > 0 {
      solve();
      t -= 1;
   }
}

fn solve() {
   let s = input();
   let numbers = s.trim().split(" ").collect::<Vec<&str>>();
   let rows = numbers[0].parse::<i32>().unwrap();
   let cols = numbers[1].parse::<i32>().unwrap();

   let mut vec: Vec<Vec<char>> = Vec::new();

   for i in 0..rows {
      let s = input();
      vec.push(s.trim().to_string().chars().collect::<Vec<char>>());
   }

   let mut v: Vec<String> = Vec::new();
   for j in 0..cols {
      let mut s = String::new();
      for i in 0..rows {
         s.push(vec[i as usize][j as usize]);
      }
      v.push(s);
   }

   let mut i = 0;
   let res = String::from("vika");
   let mut index = 0;
   let mut char = res.chars().nth(index).unwrap();
   while i < v.len() {
      if v[i].contains(char.to_string().as_str()) {
         if index == 3 {
            println!("YES");
            return;
         }
         index += 1;
         char = res.chars().nth(index).unwrap();
      }
      i += 1;
   }

   println!("NO");

}