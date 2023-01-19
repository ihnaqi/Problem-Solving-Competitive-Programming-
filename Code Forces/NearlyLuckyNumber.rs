use std::io;

fn main(){
  let mut a = String::new();

  io::stdin()
  .read_line(&mut a)
  .expect("Invalid Input!");
  let mut a: u64 = a.trim().parse().expect("");

  let mut c: u64 = 0;
  
  loop{
    if a <= 0{
      break;
    }
    if a % 10 == 4 || a % 10 == 7 {
      c += 1;
    }
    a = a / 10;
  }

  let b = if c == 4 || c == 7 {
    "YES"
  } 
  else{
    "NO"
  };

  println!("{b}");
}