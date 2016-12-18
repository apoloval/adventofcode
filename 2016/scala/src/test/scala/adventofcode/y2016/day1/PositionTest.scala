package adventofcode.y2016.day1

import org.scalatest.{Matchers, FlatSpec}

class PositionTest extends FlatSpec with Matchers {

  "Position" should "walk a sequence of moves" in {
    Position.Initial.walk(Seq(
      Move(Turn.Right, 2),
      Move(Turn.Left, 3)
    )) shouldBe Position(2, 3, Direction.North)
    Position.Initial.walk(Seq(
      Move(Turn.Right, 2),
      Move(Turn.Right, 2),
      Move(Turn.Right, 2)
    )) shouldBe Position(0, -2, Direction.West)
    Position.Initial.walk(Seq(
      Move(Turn.Right, 5),
      Move(Turn.Left, 5),
      Move(Turn.Right, 5),
      Move(Turn.Right, 3)
    )).location.dist shouldBe 12
  }
}
