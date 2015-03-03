import sbt.Keys._
import sbt._

object MyBuild extends Build {

  val buildOrganization = "com.netapp.example"
  val buildVersion = "1.1"
  val buildScalaVersion = "2.11.4"

  val buildSettings = Defaults.defaultSettings ++ Seq(
    organization := buildOrganization,
    version := buildVersion,
    scalaVersion := buildScalaVersion,
    publishArtifact in(Compile, packageDoc) := false,
    publishArtifact in(Test, packageBin) := true,
    crossPaths := false,
    scalacOptions ++= Seq("-unchecked", "-deprecation", "-feature", "-Xfatal-warnings"),
    aggregate in update := false
  )


  lazy val a = Project(id = "a", base = file("a"), settings = buildSettings)
  lazy val b = Project(id = "b", base = file("b"), settings = buildSettings) dependsOn (a % "compile->compile;test->test;compile->test")
  lazy val root = Project(id = "root", base = file("."), settings = buildSettings) aggregate(a, b)
}
