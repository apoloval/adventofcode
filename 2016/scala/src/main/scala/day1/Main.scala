package day1

object Main {

  val Input = "R4, R3, L3, L2, L1, R1, L1, R2, R3, L5, L5, R4, L4, R2, R4, L3, R3, L3, R3, R4, R2, L1, R2, L3, L2, L1, R3, R5, L1, L4, R2, L4, R3, R1, R2, L5, R2, L189, R5, L5, R52, R3, L1, R4, R5, R1, R4, L1, L3, R2, L2, L3, R4, R3, L2, L5, R4, R5, L2, R2, L1, L3, R3, L4, R4, R5, L1, L1, R3, L5, L2, R76, R2, R2, L1, L3, R189, L3, L4, L1, L3, R5, R4, L1, R1, L1, L1, R2, L4, R2, L5, L5, L5, R2, L4, L5, R4, R4, R5, L5, R3, L1, L3, L1, L1, L3, L4, R5, L3, R5, R3, R3, L5, L5, R3, R4, L3, R3, R1, R3, R2, R2, L1, R1, L3, L3, L3, L1, R2, L1, R4, R4, L1, L1, R3, R3, R4, R1, L5, L2, R2, R3, R2, L3, R4, L5, R1, R4, R5, R4, L4, R1, L3, R1, R3, L2, L3, R1, L2, R3, L3, L1, L3, R4, L4, L5, R3, R5, R4, R1, L2, R3, R5, L5, L4, L1, L1"

  def visitedTwice(locations: Seq[Location],
                   visited: Set[Location] = Set.empty): Option[Location] = {
    if (locations.isEmpty) None
    else {
      val next = locations.head
      if (visited.contains(next)) Some(next)
      else visitedTwice(locations.tail, visited + next)
    }
  }

  def part1: Int = {
    val moves = Move.parseSeq(Input)
    val finalPosition = Position.Initial.walk(moves)
    finalPosition.location.dist
  }

  def part2: Int = {
    val moves = Move.parseSeq(Input)
    val locations = moves
      .scanLeft(Position.Initial)((pos, move) => pos.walk(move))
      .map(_.location)
    val traversedLocations = Location.traverse(locations)
    visitedTwice(traversedLocations).get.dist
  }

  def main(args: Array[String]): Unit = {
    println(s"The shortest part to the destination is $part1 blocks away")
    println(s"The first location visited twice is $part2 blocks away")
  }
}
