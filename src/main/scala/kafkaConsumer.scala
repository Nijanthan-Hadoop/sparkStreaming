//import java.util.Properties
//
//import org.apache.spark.SparkContext._
//import org.apache.spark.SparkContext
//import org.apache.kafka.clients.producer.{ KafkaProducer, ProducerRecord }
//import org.apache.spark.streaming.dstream._
//import org.apache.spark.streaming._
//import org.apache.spark.streaming.StreamingContext
//import org.apache.spark.streaming.StreamingContext._
//import org.apache.spark.streaming.kafka._
//import org.apache.spark.SparkConf
//import org.apache.spark.streaming.kafka.KafkaUtils
//import org.apache.spark.sql.types.{ StructType, StructField, StringType }
//import org.apache.spark.Logging
//import org.apache.spark.rdd.RDD
//import org.apache.spark.sql.Row
//import org.apache.log4j.{ Level, Logger }


object kafkaConsumer extends App {

//  val conf = new SparkConf().setAppName("kafka-consumer")
//  val sc = new SparkContext(conf)
//  val ssc = new StreamingContext(sc, Seconds(20))
//  val kafkaParams = Map[String, String]("metadata.broker.list" -> "localhost:9092", "schema.registry.url" -> "http://localhost:8081", "auto.offset.reset" -> "largest", "group.id" -> "group1")
//  val topics = ""
//  val topicSet = Set(topics)
//  val messages = KafkaUtils.createDirectStream[Object, Object, KafkaAvroDecoder, KafkaAvroDecoder](ssc, kafkaParams, topicSet).map(_._2)
//  val lines = messages.map(data => data.toString).toDF
//  lines.show()
//  ssc.start()
//  ssc.awaitTermination()


}
