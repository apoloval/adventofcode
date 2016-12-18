use std::io;

fn char_weight(c: char) -> isize {
	match c {
		'(' => 1,
		')' => -1,
		_ => 0,
	}
}

pub fn level_of(input: &str) -> isize {
	input.chars()
		.map(char_weight)
		.fold(0, |a, w| a + w)
}

pub fn enters_in_basement(input: &str) -> Option<usize> {
	input.chars()
		.map(char_weight)
		.scan(0, |a, w| {
			*a = *a + w;
			Some(*a)
		})
		.position(|w| w == -1)
	    .map(|w| w + 1)
}

fn main() {
    let mut input = String::new();
	io::stdin().read_line(&mut input).unwrap();
	println!("Part 1 answer is {}", level_of(&input));
	println!("Part 2 answer is {:?}", enters_in_basement(&input));
}

#[cfg(test)]
mod tests {

	use super::*;

	#[test]
	fn should_calculate_level() {
		assert_eq!(level_of("(())"), 0);
		assert_eq!(level_of("()()"), 0);
		assert_eq!(level_of("))((((("), 3);
		assert_eq!(level_of("())"), -1);
		assert_eq!(level_of("))("), -1);
		assert_eq!(level_of(")))"), -3);
		assert_eq!(level_of(")())())"), -3);
	}

	#[test]
	fn should_enter_in_basement() {
		assert_eq!(enters_in_basement(")"), Some(1));
		assert_eq!(enters_in_basement("()())"), Some(5));
	}
}
