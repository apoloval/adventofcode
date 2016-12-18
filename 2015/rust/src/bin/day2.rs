use std::io;
use std::io::BufRead;

struct Side { x: usize, y: usize }

impl Side {
    pub fn surface(&self) -> usize { self.x * self.y }
    pub fn perimeter(&self) -> usize { 2 * self.x + 2 * self.y }
}

struct Present { x: usize, y: usize, z: usize }

impl Present {

    pub fn from_str(s: &str) -> Option<Present> {
        let parts: Vec<&str> = s.split('x').collect();
        if parts.len() != 3 { return None; }
        parts[0].parse().and_then(|x|
            parts[1].parse().and_then(|y|
                parts[2].parse().map(|z|
                    Present { x: x, y: y, z: z }
                )
            )
        ).ok()
    }

    pub fn wrapping_paper(&self) -> usize {
        self.surface() + self.smallest_side().surface()
    }

    pub fn ribbon_len(&self) -> usize {
        self.ribbon_wrap_len() + self.ribbon_bow_len()
    }

    fn surface(&self) -> usize {
        2 * self.x * self.y + 2 * self.x * self.z + 2 * self.y * self.z
    }

    fn smallest_side(&self) -> Side {
        let mut dims = [self.x, self.y, self.z];
        dims.sort();
        Side  { x: dims[0], y: dims[1] }
    }

    fn ribbon_wrap_len(&self) -> usize {
        self.smallest_side().perimeter()
    }

    fn ribbon_bow_len(&self) -> usize {
        self.x * self.y * self.z
    }
}

pub fn wrapping_paper(x: usize, y: usize, z: usize) -> usize {
    let present = Present { x: x, y: y, z: z };
    present.wrapping_paper()
}

pub fn ribbon_length(x: usize, y: usize, z: usize) -> usize {
    let present = Present { x: x, y: y, z: z };
    present.ribbon_len()
}

fn main() {
    let stdin = io::stdin();
    let mut paper_len = 0;
    let mut ribbon_len = 0;
    let lines = stdin.lock().lines();
    let presents = lines.map(|l| Present::from_str(l.ok().unwrap().trim()).unwrap());
    for present in presents {
        paper_len += present.wrapping_paper();
        ribbon_len += present.ribbon_len();
    }
    println!("Total wrapping paper length: {}", paper_len);
    println!("Total ribbon length: {}", ribbon_len);
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn should_calculate_wrapping_paper() {
        assert_eq!(wrapping_paper(2, 3, 4), 58);
        assert_eq!(wrapping_paper(1, 1, 10), 43);
    }

    #[test]
    fn should_calculate_ribbon_length() {
        assert_eq!(ribbon_length(2, 3, 4), 34);
        assert_eq!(ribbon_length(1, 1, 10), 14);
    }
}
