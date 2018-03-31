import java.util.Properties

import org.apache.spark.SparkContext._
import org.apache.spark.SparkContext

import org.apache.spark.streaming.dstream._
import org.apache.spark.streaming._
import org.apache.spark.streaming.StreamingContext
import org.apache.spark.streaming.StreamingContext._
import org.apache.spark.streaming.kafka._
import org.apache.spark.SparkConf
import org.apache.spark.streaming.kafka010.KafkaUtils
import org.apache.spark.sql.types.{ StructType, StructField, StringType }
import org.apache.spark.Logging
import org.apache.spark.rdd.RDD
import org.apache.spark.sql.Row
import org.apache.log4j.{ Level, Logger }
import org.apache.spark.streaming.{Seconds, StreamingContext}
import io.confluent.kafka.serializers.KafkaAvroDecoder

object kafkaConsumer  {

  def main(args:Array[String]): Unit ={

      val conf = new SparkConf().setAppName("kafka-consumer")
      val sc = new SparkContext(conf)
      val ssc = new StreamingContext(sc, Seconds(20))
      val kafkaParams = Map[String, String]("metadata.broker.list" -> "localhost:9092", "schema.registry.url" -> "http://localhost:8081", "auto.offset.reset" -> "largest", "group.id" -> "group1")
      val topics = "avro"
      val topicSet = Set(topics)
      val messages = KafkaUtils.createDirectStream[Object, Object, KafkaAvroDecoder, KafkaAvroDecoder](ssc, kafkaParams, topicSet).map(_._2)
      val lines = messages.map(data => data.toString)

    lines.foreachRDD(rdd => {
      if (rdd.count != 0) {
        messages.foreachRDD { rdds =>
          val offsetRanges = rdds.asInstanceOf[HasOffsetRanges].offsetRanges
          val hiveContext = new org.apache.spark.sql.hive.HiveContext(sc)
          val data = hiveContext.read.json(rdd)
          data.printSchema()
          data.show()
        }
      }
    }

      ssc.start()
      ssc.awaitTermination()

  }
}
