package pl.gigiel.seldon

import slick.driver.H2Driver.api._

case class Info(id: Option[Int] = None, info: String)

class Infos(tag: Tag) extends Table[(Info)](tag, "INFOS") {
  def id: Rep[Int] = column[Int]("ID", O.PrimaryKey, O.AutoInc)
  def info: Rep[String] = column[String]("INFO")

  def * = (id.?, info) <> (Info.tupled, Info.unapply)
}
