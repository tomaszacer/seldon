package pl.gigiel.seldon

import slick.driver.H2Driver.api._

object SeldonDB {
  def db: Unit = {
    val database = Database.forConfig("seldondb")

    val infos: TableQuery[Infos] = TableQuery[Infos]
    val insertAction: DBIO[Option[Int]] = infos ++= Seq(
      new Info(Option(1), "info1"), //
      new Info(Option(2), "info2") //
      )

    val source = scala.io.Source.fromURL(getClass.getResource("/application.conf"))
    println(source.mkString)
    println("ok - SeldonDB")
  }
}
