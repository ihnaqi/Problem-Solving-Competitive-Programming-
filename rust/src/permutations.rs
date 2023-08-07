//@author: @ihnaqi
//@href: https://leetcode.com/problems/permutations/description/
//@title: 46 Permutations
//@difficulty: Medium

#![
   allow(
      dead_code,
      unused,
      clippy::needless_borrow
   )
]
struct Solution {
   // Just to make use of impl Solution
}

impl Solution {
   fn permute(nums: Vec<i32>) -> Vec<Vec<i32>> {

      let mut res: Vec<Vec<i32>> = Vec::new();
      Solution::helper(&mut res, &mut nums.clone(), 0);
      res
   }

   fn helper(res: &mut Vec<Vec<i32>>, nums: &mut Vec<i32>, i: usize) {
      if i == nums.len() {
         res.push(nums.to_vec());
         return;
      }

      for j in i..nums.len() {
         let mut t = nums[i];
         nums[i] = nums[j as usize];
         nums[j] = t;
         Solution::helper(res, nums, i + 1);
         t = nums[i];
         nums[i] = nums[j as usize];
         nums[j] = t;
      }
   }

}

fn valid_test(nums: Vec<i32>, vec: Vec<Vec<i32>>) {
   let res = Solution::permute(nums);

   assert_eq!(res, vec);
}

#[test]
fn test00() {
   let nums = vec![1, 2, 3];
   let vec = vec![
      vec![1, 2, 3],
      vec![1, 3, 2],
      vec![2, 1, 3],
      vec![2, 3, 1],
      vec![3, 1, 2],
      vec![3, 2, 1]
   ];

   valid_test(nums, vec);
}

#[test]
fn test01() {
   let nums = vec![1];
   let vec = vec![vec![1]];

   valid_test(nums, vec);
}

#[test]
fn test02() {
   let nums = vec![0, 1];
   let vec = vec![
      vec![0, 1],
      vec![1, 0]
   ];

   valid_test(nums, vec);
}

#[test]
fn test03() {
   let nums = vec![1, 2, 3, 4, 5];
   let vec = vec![
      vec![1, 2, 3, 4, 5],
      vec![1, 2, 3, 5, 4],
      vec![1, 2, 4, 3, 5],
      vec![1, 2, 4, 5, 3],
      vec![1, 2, 5, 3, 4],
      vec![1, 2, 5, 4, 3],
      vec![1, 3, 2, 4, 5],
      vec![1, 3, 2, 5, 4],
      vec![1, 3, 4, 2, 5],
      vec![1, 3, 4, 5, 2],
      vec![1, 3, 5, 2, 4],
      vec![1, 3, 5, 4, 2],
      vec![1, 4, 2, 3, 5],
      vec![1, 4, 2, 5, 3],
      vec![1, 4, 3, 2, 5],
      vec![1, 4, 3, 5, 2],
      vec![1, 4, 5, 2, 3],
      vec![1, 4, 5, 3, 2],
      vec![1, 5, 2, 3, 4],
      vec![1, 5, 2, 4, 3],
      vec![1, 5, 3, 2, 4],
      vec![1, 5, 3, 4, 2],
      vec![1, 5, 4, 2, 3],
      vec![1, 5, 4, 3, 2],
   ];

   valid_test(nums, vec);
}

#[test]
fn test04() {
   let nums = vec![1, 2, 3, 4];
   let vec = vec![
      vec![1, 2, 3, 4],
      vec![1, 2, 4, 3],
      vec![1, 3, 2, 4],
      vec![1, 3, 4, 2],
      vec![1, 4, 2, 3],
      vec![1, 4, 3, 2],
      vec![2, 1, 3, 4],
      vec![2, 1, 4, 3],
      vec![2, 3, 1, 4],
      vec![2, 3, 4, 1],
      vec![2, 4, 1, 3],
      vec![2, 4, 3, 1],
      vec![3, 1, 2, 4],
      vec![3, 1, 4, 2],
      vec![3, 2, 1, 4],
      vec![3, 2, 4, 1],
      vec![3, 4, 1, 2],
      vec![3, 4, 2, 1],
      vec![4, 1, 2, 3],
      vec![4, 1, 3, 2],
      vec![4, 2, 1, 3],
      vec![4, 2, 3, 1],
      vec![4, 3, 1, 2],
      vec![4, 3, 2, 1],
   ];

   valid_test(nums, vec);
}