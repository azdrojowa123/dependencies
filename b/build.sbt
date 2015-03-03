name := "b"

libraryDependencies += "org.scala-sbt" % "command" % "0.13.7"

lazy val myRunTask = taskKey[Unit]("A custom run task.")

myRunTask := (runMain in Test).toTask(" com.netapp.example.PersonAssertion").value