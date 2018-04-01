import org.apache.spark.rdd.RDD
import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.avro.generic.GenericData$Record
import org.apache.spark.sql.{ Encoders, SparkSession }
import org.apache.spark.streaming.{ StreamingContext, _ }
import io.confluent.kafka.serializers.KafkaAvroDeserializer
import org.apache.spark.streaming.kafka010.ConsumerStrategies.Subscribe
import org.apache.spark.streaming.kafka010.LocationStrategies.PreferConsistent
import org.apache.spark.streaming.kafka010.{ CanCommitOffsets, HasOffsetRanges, KafkaUtils, OffsetRange }

object oldConsumer extends App {

  val conf = new SparkConf().setMaster("local[2]").setAppName("kafka-consumer")
  val sc = new SparkContext(conf)
  val ssc = new StreamingContext(sc, Seconds(5))

  val kafkaParams = Map[String, Object](
    "bootstrap.servers" -> "localhost:9092",
    "key.deserializer" -> "io.confluent.kafka.serializers.KafkaAvroDeserializer",
    "value.deserializer" -> "io.confluent.kafka.serializers.KafkaAvroDeserializer",
    "schema.registry.url" -> "http://0.0.0.0:8081",
    "auto.offset.reset" -> "earliest",
    "enable.auto.commit" -> (false: java.lang.Boolean),
    "group.id" -> "group1")

  val topics = Array("nijavro")
  val stream = KafkaUtils.createDirectStream[String, String](ssc, PreferConsistent, Subscribe[String, String](topics, kafkaParams))
  stream.print()

  //ConsumerRecord(topic = test_mysql_sample, partition = 0, offset = 67, CreateTime = 1505379645403, checksum = 2903150596, serialized key size = -1, serialized value size = 19, key = null, value = {"c1":1,"c2":{"string":"a"},"c3":{"string":"b"}})

//  var offsetRanges = Array[OffsetRange]()
//
//  stream.transform {
//    rdd =>
//      //Cast the rdd to an interface that lets us get an array of OffsetRange
//      offsetRanges = rdd.asInstanceOf[HasOffsetRanges].offsetRanges
//      rdd
//  }.foreachRDD(rdd => {
//    if (rdd.count != 0) {
//      val hiveContext = new org.apache.spark.sql.hive.HiveContext(sc)
//      val rdds: RDD[String] = rdd.map(e => e.value().asInstanceOf[org.apache.avro.generic.GenericData$Record].toString)
//      val data = hiveContext.read.json(rdds)
//      data.printSchema()
//      data.show()
////      data.registerTempTable("sourceData")
////      hiveContext.sql("INSERT INTO TABLE default.kafka_demo_1 SELECT * FROM sourceData")
//
//      // some time later, after outputs have completed
//      stream.asInstanceOf[CanCommitOffsets].commitAsync(offsetRanges)
//
//    } else {
//      println("RDD is Empty - No data")
//    }
//  })

  ssc.start()
  ssc.awaitTermination()
}
