//@author: @ihnaqi
//@href: https://leetcode.com/problems/letter-combinations-of-a-phone-number/
//@title: 17. Letter Combination of a Phone Number
//@difficulty: Medium

#![
   allow(
      dead_code,
      unused,
      clippy::needless::needless_borrow
   )
]

struct Solution{
   //
}

impl Solution {
   fn letter_combinations(digits: String) -> Vec<String> {
      if digits.is_empty() {
         return vec![];
      }
      let mut res = Vec::<String>::new();
      // I need a reference point from where I can get all of my required characters against a number
      // I can either use map or a an array, since size is fixed so I am using array
      let cache = ["abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"];
      let mut sb = String::new();
      Solution::combinations(&digits, 0, &cache, &mut sb, &mut res);

      res
   }

   fn combinations(digits: &str, i: usize, cache: &[&str], sb: &mut String, res: &mut Vec<String>) {
      if i == digits.len() {
         res.push(sb.to_string());
         return;
      }

      let num = digits.chars().nth(i);
      let index = match num {
         Some(c) => c.to_digit(10).unwrap() as usize,
         None => 0,
      };

      let c = cache[index - 2];
      dbg!(index, c);
      for k in 0..c.len() {
         sb.push(c.as_bytes()[k] as char);
         Solution::combinations(digits, i + 1, cache, sb, res);
         sb.remove(sb.len() - 1);
      }
   }
}

fn valid_test_cases(digits: String, expected: Vec<String>) {
   assert_eq!(Solution::letter_combinations(digits), expected);
}

#[test]
fn test00() {
   let digits = String::from("23");
   let expected = vec![
      String::from("ad"),
      String::from("ae"),
      String::from("af"),
      String::from("bd"),
      String::from("be"),
      String::from("bf"),
      String::from("cd"),
      String::from("ce"),
      String::from("cf")
   ];

   valid_test_cases(digits, expected);
}

#[test]
fn test01() {
   let digits = String::from("");
   let expected = vec![];

   valid_test_cases(digits, expected);
}

#[test]
fn test02() {
   let digits = String::from("2");
   let expected = vec![
      String::from("a"),
      String::from("b"),
      String::from("c")
   ];

   valid_test_cases(digits, expected);
}