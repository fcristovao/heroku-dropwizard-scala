name := "curium"


// all sub projects have the same version
version in ThisBuild := "0.0"

scalaVersion in ThisBuild := "2.11.8"

// common dependencies
libraryDependencies in ThisBuild ++= Seq(

)

lazy val api = project in file("curium-api")

lazy val application = project in file("curium-application") dependsOn api

