//@author: @ihnaqi
//@href: https://open.kattis.com/problems/memorymatch
//@difficulty: Medium

#![
   allow(
      unused,
      dead_code
   )
]

use std::{io, collections::{HashMap, HashSet}};

fn input() -> String {
   let mut s = String::new();

   io::stdin().read_line(&mut s).unwrap();

   s
}

pub fn main() {
   let s = input();
   let n = s.trim().parse::<i32>().unwrap();
   let mut v = vec![String::new(); n as usize + 1];

   // {blank}, indcates that this value is useless or has already been reavled.
   v[0] = String::from("blank");
   let mut map = HashMap::<String, HashSet<i32>>::new();
   // Set of cards unfolded by other players
   let mut set = HashSet::<i32>::new();

   let s = input();

   let mut k = s.trim().parse::<i32>().unwrap();

   loop {

      if k == 0 {
         break;
      }

      let s = input();
      let mut line = s.split_whitespace();
      let x = line.next().unwrap().parse::<i32>().unwrap();
      let y = line.next().unwrap().parse::<i32>().unwrap();
      let x_str = line.next().unwrap().to_string();
      let y_str = line.next().unwrap().to_string();

      if &x_str == &y_str {
         v[x as usize] = String::from("blank");
         v[y as usize] = String::from("blank");
         set.insert(x);
         set.insert(y);
      }
      else {
         v[x as usize] = x_str;
         v[y as usize] = y_str;
      }
      k -= 1;
   }

   for i in 1..=n {
      if set.contains(&i) {
         continue;
      }
      let key = &v[i as usize].clone();
      if map.contains_key(key) {
         if let Some(set) = map.get_mut(key) {
            set.insert(i);
         }
      }
      else {
         let mut set = HashSet::new();
         set.insert(i);
         map.insert((*key).to_string(), set);
      }
   }

   let mut unknown = 0;
   for i in v {
      if i.is_empty() {
         unknown += 1;
      }
   }

   let mut single = 0;
   let mut res = 0;

   for (key, value) in map.iter() {
      if value.len() == 1 {
         single += 1;
      }
      else if !key.is_empty(){
         res += 1;
      }
   }
   if single >= unknown {
      res += unknown;
   }
   else if unknown == 2{
      res += 1;
   }

   println!("{}", res);
}
