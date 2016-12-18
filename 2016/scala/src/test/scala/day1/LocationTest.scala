package day1

import org.scalatest.{Matchers, FlatSpec}

class LocationTest extends FlatSpec with Matchers {

  "Location" should "compute dist" in {
    Location(0, 0).dist shouldBe 0
    Location(0, 4).dist shouldBe 4
    Location(1, 3).dist shouldBe 4
    Location(-4, 3).dist shouldBe 7
    Location(-4, -12).dist shouldBe 16
  }

  it should "compute traverse with no moves" in {
    Location(7, 3).traverse(Location(7, 3)) shouldBe Seq(Location(7, 3))
  }

  it should "compute traverse with positive moves in X" in {
    Location(7, 3).traverse(Location(9, 3)) shouldBe Seq(
      Location(7, 3),
      Location(8, 3),
      Location(9, 3)
    )
  }

  it should "compute traverse with negative moves in X" in {
    Location(9, 3).traverse(Location(7, 3)) shouldBe Seq(
      Location(9, 3),
      Location(8, 3),
      Location(7, 3)
    )
  }

  it should "compute traverse with positive moves in Y" in {
    Location(7, 3).traverse(Location(7, 5)) shouldBe Seq(
      Location(7, 3),
      Location(7, 4),
      Location(7, 5)
    )
  }

  it should "compute traverse with negative moves in Y" in {
    Location(7, 5).traverse(Location(7, 3)) shouldBe Seq(
      Location(7, 5),
      Location(7, 4),
      Location(7, 3)
    )
  }

  it should "compute traverse from empty sequence" in {
    Location.traverse(Seq.empty) shouldBe Seq.empty
  }

  it should "compute traverse from sequence with one element" in {
    Location.traverse(Seq(Location(7, 3))) shouldBe Seq(Location(7, 3))
  }

  it should "compute traverse from non trivial sequence" in {
    Location.traverse(Seq(
      Location(7, 3),
      Location(9, 3),
      Location(9, 5)
    )) shouldBe Seq(
      Location(7, 3),
      Location(8, 3),
      Location(9, 3),
      Location(9, 4),
      Location(9, 5)
    )
  }
}
