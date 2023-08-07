//@author: @ihnaqi
//@href: 
//@title: Convert a number to Hexadecimel
//@difficult: Easy

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
   fn to_hex(num: i32) -> String {
      format!("{:X}", num).to_lowercase()
   }
}

fn valid_test_cases(num: i32, expected: String) {
   assert_eq!(expected, Solution::to_hex(num));
}

#[test]
fn test00() {
   let num = 26;
   let expected = String::from("1a");
   valid_test_cases(num, expected);
}

#[test]
fn test01() {
   let num = -1;
   let expected = String::from("ffffffff");
   valid_test_cases(num, expected);
}