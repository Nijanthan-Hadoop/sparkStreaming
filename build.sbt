name := "sparkstreaming"

version := "0.1"

scalaVersion := "2.11.11"

//assemblyMergeStrategy in assembly := {
//  case PathList("META-INF", xs @ _*) => MergeStrategy.discard
//  case x => MergeStrategy.first
//}

resolvers ++= Seq(
  Classpaths.typesafeReleases,
  "confluent" at "http://packages.confluent.io/maven/"
)

libraryDependencies += "org.apache.hadoop" % "hadoop-hdfs" % "2.6.0"
libraryDependencies += "org.apache.spark" %% "spark-core" % "2.2.0"
libraryDependencies += "org.apache.spark" %% "spark-sql" % "2.2.0"
libraryDependencies += "org.apache.spark" %% "spark-hive" % "2.2.0"
libraryDependencies += "org.apache.parquet" % "parquet-format" % "2.4.0"
libraryDependencies += "org.apache.parquet" % "parquet-avro" % "1.9.0"
libraryDependencies += "org.apache.kafka" %% "kafka" % "0.11.0.2"
libraryDependencies += "com.databricks" %% "spark-avro" % "4.0.0"
libraryDependencies += "org.apache.avro" % "avro" % "1.8.2"
libraryDependencies += "io.confluent" % "kafka-avro-serializer" % "3.2.1"
libraryDependencies += "org.apache.spark" %% "spark-streaming" % "2.2.0" % "provided"
libraryDependencies += "org.apache.spark" %% "spark-streaming-kafka-0-10" % "2.2.0"
//libraryDependencies += "org.apache.spark" %% "spark-streaming-kafka" % "1.6.2"
