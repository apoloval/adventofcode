name := "adventofcode"

organization := "adventofcode"

scalaVersion := "2.11.8"

resolvers ++= Seq(
  DefaultMavenRepository,
  "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/"
)

libraryDependencies ++= Seq(
  "org.scalactic" %% "scalactic" % "3.0.1",
  "org.scalatest" % "scalatest_2.11" % "3.0.1" % "test"
)
