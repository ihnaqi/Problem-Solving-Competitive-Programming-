use std::io;

fn main(){
  let mut a = String::new();

  let mut b = String::new();
  io::stdin()
  .read_line(&mut b)
  .expect("Error");

  io::stdin()
  .read_line(&mut a)
  .expect("Invalid Input!");
  let mut ct_a: u64 = 0;
  let mut ct_d: u64 = 0;
  
  let v = a.chars();
  
  for c in v{
    if c == 'A' {
      ct_a += 1;
    }
    else if c == 'D' {
      ct_d += 1;
    }
  }

  let a = if ct_a > ct_d {
    "Anton"
  }
    else if ct_d > ct_a {
      "Danik"
    }
    else{
      "Friendship"
    };

  println!("{a}");
}