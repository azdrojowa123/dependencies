name := "dependencies"

version := "1.0"

scalaVersion := "2.11.3"

val buildSettings = Seq(
//  organization := buildOrganization,
//  version := buildVersion,
//  scalaVersion := buildScalaVersion,
  publishArtifact in(Compile, packageDoc) := false,
  publishArtifact in(Test, packageBin) := true,
  crossPaths := false,
  scalacOptions ++= Seq("-unchecked", "-deprecation", "-feature", "-Xfatal-warnings"),
  aggregate in update := false
)

lazy val a = project.in(file("a"))
  .settings(buildSettings)
lazy val b = project.in(file("b"))
  .settings(buildSettings)
  .dependsOn (a % "compile->compile;test->test;compile->test")

lazy val root = project.in(file(".")).settings(buildSettings).aggregate(a, b)