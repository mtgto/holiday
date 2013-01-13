// -*- scala -*-

name := "holiday"

organization := "net.mtgto"

licenses := Seq("zlib License" -> url("https://github.com/mtgto/holiday/blob/master/LICENSE"))

homepage := Some(url("https://github.com/mtgto/holiday"))

version := "0.1.0"

scalaVersion := "2.10.0"

crossScalaVersions := Seq("2.9.1", "2.9.2", "2.10.0")

scalacOptions ++= Seq("-deprecation", "-unchecked", "-feature", "-encoding", "UTF8")

libraryDependencies ++= Seq(
  "org.specs2" %% "specs2" % "1.12.3" % "test"
)

initialCommands := "import net.mtgto.holiday._"

publishTo := Some(Resolver.file("file", new File("maven/")))
