package adventofcode.y2016.day2

case class AdvancedButton(num: Int) {
  require(num >= 1 && num <= 0xD)

  def toChar: Char = Integer.toHexString(num).head.toUpper

  def move(movement: Movement): AdvancedButton = movement match {
    case Movement.Up => AdvancedButton(moveUp)
    case Movement.Down => AdvancedButton(moveDown)
    case Movement.Left => AdvancedButton(moveLeft)
    case Movement.Right => AdvancedButton(moveRight)
  }

  def move(movements: Seq[Movement]): AdvancedButton = movements.foldLeft(this) {
    case (button, movement) => button.move(movement)
  }

  private def moveUp = num match {
    case 3 | 0xD => num - 2
    case 6 | 7 | 8 | 0xA | 0xB | 0xC => num - 4
    case _ => num
  }

  private def moveDown = num match {
    case 1 | 0xB => num + 2
    case 2 | 3 | 4 | 6 | 7 | 8 => num + 4
    case _ => num
  }

  private def moveLeft = num match {
    case 1 | 2 | 5 | 0xA | 0xD => num
    case _ => num - 1
  }

  private def moveRight = num match {
    case 1 | 4 | 9 | 0xC | 0xD => num
    case _ => num + 1
  }
}

object AdvancedButton {
  val Central = AdvancedButton(5)
}
