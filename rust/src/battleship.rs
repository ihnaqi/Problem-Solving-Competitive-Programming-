//@author: @ihnaqi
//@href: https://open.kattis.com/problems/battleship
//@difficulty: Medium
//@category: ad-hoc

use std::{io, vec};

fn input() -> String {
   let mut input = String::new();
   io::stdin().read_line(&mut input).expect("Failed to take user input");
   input
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
   let mut iter = s.split_whitespace();
   let w = iter.next().unwrap().parse::<usize>().unwrap();
   let h = iter.next().unwrap().parse::<usize>().unwrap();
   let n = iter.next().unwrap().parse::<i32>().unwrap();

   let mut ships = vec![0; 2];
   let mut board = vec![vec![vec![' '; h]; w]; 2];

   for i in 0..2 {
      for j in (0..h).rev() {
         let v: Vec<char> = input().chars().collect();
         for k in 0..w {
            board[i][k][j] = v[k];
            if v[k] == '#' {
               ships[i] += 1;
            }
         }
      }
   }

   let mut end = false;
   let mut turn = 0;

   for _ in 0..n {
      let s = input();
      let mut numbers = s.split_whitespace();
      let x = numbers.next().unwrap().parse::<usize>().unwrap();
      let y = numbers.next().unwrap().parse::<usize>().unwrap();

      if end {
         continue;
      }
      if board[1 - turn][x][y] == '#' {
         board[1 - turn][x][y] = '*';
         ships[1 - turn] -= 1;

         if ships[1 - turn] == 0 {
            turn = 1 - turn;

            if turn == 0 {
               end = true;
            }
         }
      }
      else {
         turn = 1 - turn;

         if turn == 0 && ships[0] * ships[1] == 0 {
            end = true;
         }
      }
   }

   if ships[0] == 0 && ships[1] > 0 {
      println!("player two wins")
   }
   else if ships[0] > 0 && ships[1] == 0 {
      println!("player one wins")
   }
   else {
      println!("draw")
   }

}