//@author: @ihnaqi
//@href: https://codeforces.com/contest/1862/problem/B

use std::io;

fn input() -> String {
   let mut buffer = String::new();
   io::stdin().read_line(&mut buffer).expect("Failed");
   buffer
}

pub fn main() {
   let s = input();
   let mut t = s.trim().parse::<i64>().unwrap();

   while t > 0 {
      solve();
      t -= 1;
   }
}

fn solve() {
   let s = input();
   let n = s.trim().parse::<i64>().unwrap();
   let s = input();
   let v = s.trim().split_whitespace().map(|x| x.parse::<i64>().unwrap()).collect::<Vec<i64>>();

   let mut ans = Vec::<i64>::new();
   ans.push(v[0]);
   let mut count = 1;

   for i in 1..n {
      if v[i as usize] >= v[i as usize - 1] {
         ans.push(v[i as usize]);
         count += 1;
      }
      else {
         ans.push(v[i as usize]);
         ans.push(v[i as usize]);
         count += 2;
      }
   }

   println!("{}", count);
   for num in ans {
      print!("{} ", num);
   }

   println!("");

}