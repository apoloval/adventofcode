package adventofcode.y2016.day2

sealed trait Movement

object Movement {

  case object Up extends Movement
  case object Down extends Movement
  case object Left extends Movement
  case object Right extends Movement

  def parse(input: Char): Movement = input.toUpper match {
    case 'U' => Up
    case 'D' => Down
    case 'L' => Left
    case 'R' => Right
    case _ => throw new IllegalArgumentException(s"cannot parse movement from '$input")
  }

  def parse(input: String): Seq[Movement] = input.map(parse)
}

