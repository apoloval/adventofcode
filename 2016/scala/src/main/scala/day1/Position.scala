package day1

case class Position(location: Location, direction: Direction) {

  def walk(move: Move): Position = {
    val newDirection = direction.turn(move.turn)
    val newLocation = newDirection match {
      case Direction.North => Location(location.x, location.y + move.steps)
      case Direction.East => Location(location.x + move.steps, location.y)
      case Direction.South => Location(location.x, location.y - move.steps)
      case Direction.West => Location(location.x - move.steps, location.y)
    }
    Position(newLocation, newDirection)
  }

  def walk(moves: Seq[Move]): Position = {
    moves.foldLeft(this)((pos, mov) => pos.walk(mov))
  }
}

object Position {
  val Initial = Position(Location(0, 0), Direction.North)

  def apply(x: Int, y: Int, dir: Direction): Position =
    Position(Location(x, y), dir)
}
