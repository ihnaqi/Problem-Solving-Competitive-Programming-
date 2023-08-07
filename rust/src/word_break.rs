//@author: @ihnaqi
//@href: https://leetcode.com/problems/word-break/
//@title: 193. Word Break
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

impl  Solution {

   fn word_break(s: String, word_dict: Vec<String>) -> bool {
      // instead of checking that all possible combination, i.e substrings of s in word_list
      // we will check whether the strings present in word_list can be used to make String s.
      //
      let mut cache = vec![false; s.len() + 1];
      cache[s.len()] = true;
      for i in (0..=s.len()).rev() {
         for word in word_dict.clone() {
            // here we need to make sure that the substring starting from ith + word.len() is not out of bound
            if i + word.len() <= s.len() && s[i..i + word.len()] == word {
               cache[i] = cache[i + word.len()];
            }
            if cache[i] {
               break;
            }
         }
      }
      cache[0]
   }
}

fn valid_test_cases(s: String, word_dict: Vec<String>, expected: bool) {
   assert_eq!(expected, Solution::word_break(s, word_dict));
}

#[test]
fn test00() {
   let s = String::from("leetcode");
   let word_dict = vec![
      String::from("leet"),
      String::from("code")
   ];
   valid_test_cases(s, word_dict, true);
}

#[test]
fn test01() {
   let s = String::from("applepenapple");
   let word_dict = vec![String::from("apple"), String::from("pen")];
   valid_test_cases(s, word_dict, true);
}

#[test]
fn test02() {
   let s = String::from("catsanddog");
   let word_dict = vec![
      String::from("cats"),
      String::from("dogs"),
      String::from("sand"),
      String::from("and"),
      String::from("cat")
   ];
   valid_test_cases(s, word_dict, false);
}