name := "sparkstreaming"

version := "0.1"

scalaVersion := "2.11.11"

//resolvers ++= Seq(
//  Classpaths.typesafeReleases,
//  "confluent" at "http://packages.confluent.io/maven/"
//)

libraryDependencies += "org.apache.spark" %% "spark-core" % "2.1.0"
libraryDependencies += "org.apache.spark" %% "spark-sql" % "2.1.0"
libraryDependencies += "org.apache.spark" %% "spark-hive" % "2.1.0"
//libraryDependencies += "org.apache.spark" %% "spark-streaming" % "2.1.0" % "provided"
//libraryDependencies += "org.apache.spark" %% "spark-streaming-flume" % "2.1.0"
//libraryDependencies += "org.apache.spark" %% "spark-streaming-flume-sink" % "2.1.0"
