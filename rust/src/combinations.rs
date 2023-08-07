#![allow(
   dead_code,
   unused,
   clippy::needless_borrow
)]

fn combine(n: i32, k: i32) -> Vec<Vec<i32>>{
   let mut vec: Vec<Vec<i32>> = Vec::new();
   let mut cmb_vec: Vec<i32> = vec![0; k as usize];
   let mut input_vec: Vec<i32> = Vec::new();
   for i in 0..k {
      input_vec.push(k);
   }
   combination(&input_vec, &mut vec, &mut cmb_vec, 0, n - 1, 0, k as usize);

   vec
}

fn combination(input_vec: &Vec<i32>, vec: &mut Vec<Vec<i32>>, cmb: &mut Vec<i32>, start: i32, end: i32, index: usize, k: usize) {
   if index as usize == k {
      vec.push(cmb[0..k].to_vec());
      return;
   }

   
}


fn process_valid_case(n: i32, k: i32, v: Vec<Vec<i32>>) {
   let res = combine(n, k);
   dbg!(v[0][0], res[0][0]);
   let mut ans = true;
   for i in 0..res.len() {
      for j in 0..res[0].len() {
         if res[i as usize][j as usize] != v[i as usize][j as usize] {
            ans = false;
            break;
         }
      }
   }
   assert_eq!(ans, true);
}

#[test]
fn test00() {
   let v = vec![
      vec![1]
   ];
   process_valid_case(1, 1, v);
}


#[test]
fn test01() {
let v = vec![
   vec![1, 2],
   vec![1, 3],
   vec![1, 4],
   vec![2, 3],
   vec![2, 4],
   vec![3, 4]
];
process_valid_case(4, 2, v);
}