//@author: @ihanqi
//@href: https://open.kattis.com/problems/babybites
//@difficulty: Easy

use std::io;

fn input() -> String {
   let mut s = String::new();
   io::stdin().read_line(&mut s).unwrap();

   s
}

pub fn main() {
   let s = input();
   let n = s.trim().parse::<i32>().unwrap();
   let v: Vec<_> = input().trim().split_whitespace().map(|x| x.to_string()).collect();

   let mut correct = true;
   for i in 1..=n {
      let s = i.to_string();
      let mumble = String::from("mumble");
      if v[i as usize - 1] != mumble && v[i as usize - 1] != s {
         correct = false;
      }
   }

   if correct {
      println!("makes sense");
   }
   else {
      println!("something is fishy");
   }
}