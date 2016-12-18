package adventofcode.y2016.day2

case class Button(num: Int) {
  require(num >= 1 && num <= 9)

  def move(movement: Movement): Button = movement match {
    case Movement.Up => Button(moveUp)
    case Movement.Down => Button(moveDown)
    case Movement.Left => Button(moveLeft)
    case Movement.Right => Button(moveRight)
  }

  def move(movements: Seq[Movement]): Button = movements.foldLeft(this) {
    case (button, movement) => button.move(movement)
  }

  private def moveUp = num match {
    case 1 | 2 | 3 => num
    case _ => num - 3
  }

  private def moveDown = num match {
    case 7 | 8 | 9 => num
    case _ => num + 3
  }

  private def moveLeft = num match {
    case 1 | 4 | 7 => num
    case _ => num - 1
  }

  private def moveRight = num match {
    case 3 | 6 | 9 => num
    case _ => num + 1
  }
}

object Button {
  val Central = Button(5)
}
