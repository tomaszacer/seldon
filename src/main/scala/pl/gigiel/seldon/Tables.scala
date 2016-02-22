package pl.gigiel.seldon

import slick.driver.H2Driver.api._

case class Item(id: Option[Long] = None, // 
                a: Option[Const.Coordinate] = None, //
                b: Option[Const.Coordinate] = None, // 
                c: Option[Const.Coordinate] = None, //
                d: Option[Const.Coordinate] = None, //
                e: Option[Const.Coordinate] = None)

class Items(tag: Tag) extends Table[(Item)](tag, "ITEMS") {
  def id: Rep[Long] = column[Long]("ID", O.PrimaryKey, O.AutoInc)
  def a: Rep[Const.Coordinate] = column[Const.Coordinate]("A")
  def b: Rep[Const.Coordinate] = column[Const.Coordinate]("B")
  def c: Rep[Const.Coordinate] = column[Const.Coordinate]("C")
  def d: Rep[Const.Coordinate] = column[Const.Coordinate]("D")
  def e: Rep[Const.Coordinate] = column[Const.Coordinate]("E")

  def * = (id.?, a.?, b.?, c.?, d.?, e.?) <> (Item.tupled, Item.unapply)
}

case class Info(id: Option[Int] = None, info: String)

class Infos(tag: Tag) extends Table[(Info)](tag, "INFOS") {
  def id: Rep[Int] = column[Int]("ID", O.PrimaryKey, O.AutoInc)
  def info: Rep[String] = column[String]("INFO")

  def * = (id.?, info) <> (Info.tupled, Info.unapply)
}
