organization := "pl.gigiel"
name := "seldon"
version := "0.0.0.1-SNAPSHOT"
scalaVersion := "2.11.7"

// http://www.scalatest.org/supersafe
resolvers in ThisBuild += "Artima Maven Repository" at "http://repo.artima.com/releases/"

// http://www.scalatest.org
libraryDependencies += "org.scalactic" %% "scalactic" % "2.2.6"
libraryDependencies += "org.scalatest" %% "scalatest" % "2.2.6" % "test"

// assembly
assemblyJarName in assembly := "seldon.jar"
mainClass in assembly := Some("pl.gigiel.seldon.SeldonApp")
assemblyOption in assembly := (assemblyOption in assembly).value.copy(includeScala = true)
