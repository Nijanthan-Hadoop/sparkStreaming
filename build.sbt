name := "sparkstreaming"

version := "0.1"

scalaVersion := "2.11.11"

//resolvers ++= Seq(
//  Classpaths.typesafeReleases,
//  "confluent" at "http://packages.confluent.io/maven/"
//)

libraryDependencies += "org.apache.hadoop" % "hadoop-hdfs" % "2.6.0"
libraryDependencies += "org.apache.spark" %% "spark-core" % "2.1.0"
libraryDependencies += "org.apache.spark" %% "spark-sql" % "2.1.0"
libraryDependencies += "org.apache.spark" %% "spark-hive" % "2.1.0"
libraryDependencies += "org.apache.parquet" % "parquet-format" % "2.4.0"
libraryDependencies += "org.apache.parquet" % "parquet-avro" % "1.9.0"
libraryDependencies += "org.apache.kafka" %% "kafka" % "0.11.0.2"
//libraryDependencies += "commons-logging" % "commons-logging" % "1.1.3"
//libraryDependencies += "org.apache.httpcomponents" % "httpclient" % "4.5.5"
//libraryDependencies += "org.apache.spark" %% "spark-streaming" % "2.1.0" % "provided"
//libraryDependencies += "org.apache.spark" %% "spark-streaming-flume" % "2.1.0"
//libraryDependencies += "org.apache.spark" %% "spark-streaming-flume-sink" % "2.1.0"
