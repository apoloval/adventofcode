package day1

case class Move(turn: Turn, steps: Int)

object Move {

  def parse(input: String): Move = {
    val turnChar = input.head
    val moves = input.tail
    Move(Turn.parse(turnChar), moves.toInt)
  }

  def parseSeq(input: String): Seq[Move] = {
    input.split(",").map(_.trim).map(parse)
  }
}
