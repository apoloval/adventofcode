pub struct House { x: i32, y: i32 }

impl House {
    pub fn go_to(&self, dir: char) -> House {
        unimplemented!()
    }
}

pub fn delivers(input: &str) -> usize {
    let start = House { x: 0, y: 0 };
    let scanned_houses = input.chars().scan(start, |ref mut a, m| {
            *a = a.go_to(m);
            Some(a)
    });
    unimplemented!()
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn should_calculate_delivers() {
        assert_eq!(delivers(">"), 2);
        assert_eq!(delivers("^>v<"), 4);
        assert_eq!(delivers("^v^v^v^v^v"), 2);
    }
}
