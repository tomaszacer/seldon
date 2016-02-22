package pl.gigiel.seldon

import slick.driver.H2Driver.api._
import org.h2.tools.Server
import scala.concurrent.{ Future, Await }
import scala.concurrent.duration.Duration
import scala.concurrent.ExecutionContext.Implicits.global
import slick.jdbc.meta.MTable

object SeldonDB {
  def db: Unit = {
    //Class.forName("org.h2.Driver") // unnecessary in jdbc 4+
    //var server: Server = Server.createTcpServer("-tcpPort", "9123", "-tcpAllowOthers").start

    val infos = TableQuery[Infos]
    val items = TableQuery[Items]
    val database = Database.forConfig("seldondb")
    try {
      val setupAction = DBIO.seq((infos.schema ++ items.schema).create)
      val setupFuture: Future[Unit] = database.run(setupAction)

      Await.result(database.run(DBIO.seq(
        infos += Info(info = "info1"),
        infos += Info(info = "info1"),
        infos.result.map(println))), Duration.Inf)

      Await.result(database.run(DBIO.seq(
        items += Item(a = Const.coordinate(1), b = Const.coordinate(1), c = Const.coordinate(1), d = Const.coordinate(1), e = Const.coordinate(1)),
        items += Item(a = Const.coordinate(2), b = Const.coordinate(2), c = Const.coordinate(2), d = Const.coordinate(2), e = Const.coordinate(2)),
        items.result.map(println))), Duration.Inf)

    } finally {
      database.close
    }

    val source = scala.io.Source.fromURL(getClass.getResource("/application.conf"))
    println(source.mkString)
    println("ok - SeldonDB")
  }
}
