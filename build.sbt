name := "CanIDate"

version := "1.0-SNAPSHOT"

libraryDependencies ++= Seq(
  "mysql" % "mysql-connector-java" % "5.1.18",
    javaJdbc,
    javaEbean,
  cache,
  "org.jsoup" % "jsoup" % "1.7.2",
  "org.json" % "json"  % "20131018"
)

play.Project.playJavaSettings
