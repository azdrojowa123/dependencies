name := "b"

libraryDependencies += "org.scala-sbt" %% "command" % "1.10.2"

lazy val myRunTask = taskKey[Unit]("A custom run task.")

myRunTask := (runMain in Test).toTask(" com.netapp.example.PersonAssertion").value