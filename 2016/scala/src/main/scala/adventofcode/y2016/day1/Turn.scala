package adventofcode.y2016.day1

sealed trait Turn

object Turn {
  case object Right extends Turn
  case object Left extends Turn

  def parse(input: Char): Turn = {
    input.toUpper match {
      case 'R' => Turn.Right
      case 'L' => Turn.Left
      case _ => throw new IllegalArgumentException(s"cannot parse '$input' into a turn")
    }
  }
}
