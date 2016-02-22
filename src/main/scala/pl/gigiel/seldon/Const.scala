package pl.gigiel.seldon

object Const {
  type Coordinate = Long
  def coordinate(a: Long): Option[Const.Coordinate] = Option(a)
}
