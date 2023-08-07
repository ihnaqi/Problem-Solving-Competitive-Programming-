//@author: @ihnaqi
//@href: https://leetcode.com/problems/unique-binary-search-trees-ii/
//@title: 95. Unique Binary Search Trees II
//@difficulty: Medium


// #[
//    derive(
//       Debug,
//       PartialEq,
//       Eq,
//    )
// ]

#![
   allow(
      dead_code,
      unused,
      clippy::needless_borrow
   )
]

use std::rc::Rc;
use std::cell::RefCell;

pub struct TreeNode {
   pub val: i32,
   pub left: Option<Rc<RefCell<TreeNode>>>,
   pub right: Option<Rc<RefCell<TreeNode>>>,
}

impl TreeNode {
   #[inline]
   pub fn new(val: i32) -> Self {
      TreeNode {
         val,
         left: None,
         right: None
      }
   }
}

struct Solution {
   //
}

impl Solution {
   fn generate_trees(n: i32) -> Vec<Option<Rc<RefCell<TreeNode>>>> {
      if n == 0 {
         return  Vec::new();
      }

      let mut dp = vec![Vec::new(); (n + 1) as usize];
      dp[0].push(None);

      for nodes in 1..=n {
         let mut trees_per_node = Vec::new();
         for root in 1..=nodes {
            let left_trees = &dp[(root - 1) as usize];
            let right_trees = &dp[(nodes - root) as usize];

            for left_tree in left_trees {
               for right_tree in right_trees {
                  let root_node = Some(Rc::new(RefCell::new(TreeNode::new(root))));
                  root_node.as_ref().unwrap().borrow_mut().left = left_tree.clone();
                  root_node.as_ref().unwrap().borrow_mut().right = Solution::clone(right_tree.clone(), root);
                  trees_per_node.push(root_node);
               }
            }
         }
         dp[nodes as usize] = trees_per_node;
      }
      dp[n as usize].clone()
   }

   fn clone(tree: Option<Rc<RefCell<TreeNode>>>, offset: i32) -> Option<Rc<RefCell<TreeNode>>> {
      tree.map(| node | {
         Rc::new(RefCell::new(TreeNode {
            val: node.borrow().val + offset,
            left: Solution::clone(node.borrow().left.clone(), offset),
            right: Solution::clone(node.borrow().right.clone(), offset)
         }))
      })
   }
}
