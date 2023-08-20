//@author: @ihnaqi
//@href: https://open.kattis.com/problems/eligibility
//@title: Eligibility
//@difficult: Easy

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
   let mut token = token.split_whitespace();
   let name = token.next().unwrap();
   let edu = token.next().unwrap().split("/").next().unwrap().parse::<i32>().unwrap();
   let birth = token.next().unwrap().split("/").next().unwrap().parse::<i32>().unwrap();
   let courses = token.next().unwrap().parse::<i32>().unwrap();

   if edu >= 2010 || birth >= 1991 {
      println!("{} eligible", name);
      return;
   }

   if courses <= 40 {
      println!("{} coach petitions", name);
   }
   else {
      println!("{} ineligible", name);
   }
}