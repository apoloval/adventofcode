package day1

case class Location(x: Int, y: Int) {

  def dist: Int = Math.abs(x) + Math.abs(y)

  def traverse(other: Location): Seq[Location] = {
    if (this == other) Seq(this)
    else {
      if (x == other.x) {
        val nextY = if (y < other.y) y + 1 else y - 1
        this +: Location(x, nextY).traverse(other)
      } else {
        val nextX = if (x < other.x) x + 1 else x - 1
        this +: Location(nextX, y).traverse(other)
      }
    }
  }
}

object Location {
  def traverse(locations: Seq[Location]): Seq[Location] = {
    if (locations.isEmpty) Seq.empty
    else if (locations.size == 1) locations
    else {
      val from = locations.head
      val to = locations.tail.head
      val traversed = from.traverse(to)
      traversed.take(traversed.size - 1) ++ traverse(locations.tail)
    }
  }
}
