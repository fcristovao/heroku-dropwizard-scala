
name := "curium-application"

libraryDependencies ++= Seq(
  "io.dropwizard" % "dropwizard-core" % "1.0.2",
  "io.dropwizard" % "dropwizard-jdbi" % "1.0.2",
  "com.datasift.dropwizard.scala" %% "dropwizard-scala-core" % "1.0.0-1",
  "com.datasift.dropwizard.scala" %% "dropwizard-scala-jdbi" % "1.0.0-1",
  "de.thomaskrille" % "dropwizard-template-config" % "1.4.0",
  "org.postgresql" % "postgresql" % "9.4.1211.jre7"
)

enablePlugins(JavaAppPackaging)