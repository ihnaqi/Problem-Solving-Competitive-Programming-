//@author: @ihnaqi
//@href: 
//@title: Number of Music Playlist
//@difficulty: Hard
#![
   allow(
      dead_code,
      unused,
      clippy::needless_borrow
   )
]

use std::cmp::min;

struct  Solution{
   //
}


impl Solution {
   fn num_music_playlists(n: i32, goal: i32, k: i32) -> i32 {
      const MOD: i64 = 1e9 as i64 + 7;
      let mut dp = vec![vec![0; n as usize + 1]; 2];
      dp[0][0] = 1;

      for i in 1..=goal {
         dp[i as usize % 2][0] = 0;
         for j in 1..=min(i, n) {
            dp[i as usize % 2][j as usize] = dp[(i - 1) as usize % 2][(j - 1) as usize] * (n - (j - 1)) as i64 % MOD;

            if j > k {
               dp[i as usize % 2][j as usize] = (dp[i as usize % 2][j as usize] + dp[(i - 1) as usize % 2][j as usize] * (j - k) as i64 ) % MOD;
            }
         }
      }

      dp[(goal % 2) as usize][n as usize] as i32
   }
}

fn valid_test_cases(n: i32, goal: i32, k: i32, expected: i32) {
   assert_eq!(Solution::num_music_playlists(n, goal, k), expected);
}

#[test]
fn test00() {
   valid_test_cases(3, 3, 1, 6);
}

#[test]
fn test01() {
   valid_test_cases(2, 3, 0, 6);
}