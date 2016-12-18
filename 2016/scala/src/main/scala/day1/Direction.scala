package day1

sealed trait Direction {
  def turn(value: Turn): Direction
}

object Direction {

  case object North extends Direction {
    def turn(value: Turn) = value match {
      case Turn.Right => East
      case Turn.Left => West
    }
  }

  case object East extends Direction {
    def turn(value: Turn) = value match {
      case Turn.Right => South
      case Turn.Left => North
    }
  }

  case object South extends Direction {
    def turn(value: Turn) = value match {
      case Turn.Right => West
      case Turn.Left => East
    }
  }

  case object West extends Direction {
    def turn(value: Turn) = value match {
      case Turn.Right => North
      case Turn.Left => South
    }
  }
}
