//@author: @ihnaqi
//@href: https://open.kattis.com/problems/helpaphd
//@title: Help a PhD Candidate Out
//@difficulty: Easy

use std::io::{self, BufRead};

fn input() -> impl Iterator<Item = String> {
   io::stdin().lock().lines().map(|line| line.unwrap())
}

pub fn main() {
   let mut input = input();
   let mut t = input.next().unwrap().parse::<i32>().unwrap();

   while t > 0 {
      solve(input.next().unwrap());
      t -= 1;
   }
}

fn solve(token: String) {
   let mut index = 0;
   let mut ch = ' ';

   for c in token.clone().chars() {
      if c == '+' || c == '=' {
         ch = c;
         break;
      }
      index += 1;
   }

   match ch {
      '=' => println!("skipped"),
      _ => {
         let a = token[0..index].parse::<i32>().unwrap();
         let b = token[index + 1..].parse::<i32>().unwrap();

         println!("{}", a + b);
      }
   }

}