organization := "pl.gigiel"
name := "seldon"
version := "0.0.0.1-SNAPSHOT"
scalaVersion := "2.11.7"

// http://www.scalatest.org/supersafe
resolvers in ThisBuild += "Artima Maven Repository" at "http://repo.artima.com/releases/"

// http://www.scalatest.org
libraryDependencies += "org.scalactic" %% "scalactic" % "2.2.6"
libraryDependencies += "org.scalatest" %% "scalatest" % "2.2.6" % "test"

// package
mainClass in (Compile, packageBin) := Some("pl.gigiel.seldon.SeldonApp")

// assembly
assemblyJarName in assembly := "seldon.jar"
mainClass in assembly := Some("pl.gigiel.seldon.SeldonApp")
assemblyOption in assembly := (assemblyOption in assembly).value.copy(includeScala = true)

// db
libraryDependencies += "com.h2database" % "h2" % "1.4.191"
libraryDependencies += "com.typesafe.slick" %% "slick" % "3.1.1"
libraryDependencies += "ch.qos.logback" % "logback-classic" % "1.1.3"
libraryDependencies += "com.typesafe" % "config" % "1.3.0"
libraryDependencies += "org.joda" % "joda-convert" % "1.8.1"
