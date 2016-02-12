package pl.gigiel.seldon

import slick.driver.H2Driver.api._
import org.h2.tools.Server
import scala.concurrent.Await
import scala.concurrent.duration.Duration
import scala.concurrent.ExecutionContext.Implicits.global

object SeldonDB {
  def db: Unit = {
    //Class.forName("org.h2.Driver") // unnecessary in jdbc 4+
    //var server: Server = Server.createTcpServer("-tcpPort", "9123", "-tcpAllowOthers").start

    val infos = TableQuery[Infos]
    val database = Database.forConfig("seldondb")
    try {
      Await.result(database.run(DBIO.seq(
        //infos.schema.create,
        infos += Info(None, "info1"),
        infos += Info(None, "info1"),
        infos.result.map(println))), Duration.Inf)
    } finally database.close

    val source = scala.io.Source.fromURL(getClass.getResource("/application.conf"))
    println(source.mkString)
    println("ok - SeldonDB")
  }
}
