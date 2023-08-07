//@author: @ihnaqi
//@href: https://leetcode.com/problems/search-a-2d-matrix/
//@title: 74. Search a 2D Matrix
//@difficulty: Medium

#![
   allow(
      dead_code,
      unused,
      clippy::needless_borrow
   )
]

struct Solution {
   //
}

impl Solution {
   fn search_2d_matrix(matrix: Vec<Vec<i32>>, target: i32) -> bool {

      for v in matrix {
         if target >= v[0] && target <= v[v.len() - 1] {
            let mut low = 0;
            let mut high = v.len() - 1;
            while low <= high {
               let mid = (high + low) / 2;
               if v[mid] == target {
                  return  true;
               }
               else if v[mid] > target {
                  high = mid - 1;
               }
               else {
                  low = mid + 1;
               }
            }
         }
      }

      false
   }
}

fn valid_test_cases(matrix: Vec<Vec<i32>>, target: i32, expected: bool) {
   assert_eq!(expected, Solution::search_2d_matrix(matrix, target));
}

#[test]
fn test00() {
   let matrix = vec![
      vec![1, 3, 5, 7],
      vec![10 ,11, 16,20],
      vec![23 ,30, 34,60]
   ];
   valid_test_cases(matrix, 3, true);
}

#[test]
fn test01() {
   let matrix = vec![
      vec![1,3,5,7],
      vec![10,11,16,20],
      vec![23,30,34,60]
   ];
   valid_test_cases(matrix, 13, false);
}