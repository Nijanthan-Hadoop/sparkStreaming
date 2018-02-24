import org.apache.spark.SparkConf
import org.apache.spark.streaming._
import org.apache.spark.streaming.dstream.ReceiverInputDStream
import org.apache.spark.streaming.flume._


object logstream {
  def main(args: Array[String]) {
    val sparkConf = new SparkConf().setAppName("DepartmentWiseCount").setMaster("yarn-client")
    val topicsSet = "log_topic".split(",").toSet
    val kafkaParams = Map[String, String]("metadata.broker.list" -> "10.0.1.4:9092,10.0.1.5:9092,10.0.1.6:9092")
    val ssc = new StreamingContext(sparkConf, Seconds(30))
    val messages: InputDStream[(String, String)] = KafkaUtils.createDirectStream[String, String, StringDecoder, StringDecoder](ssc, kafkaParams, topicsSet)

    val lines = messages.toDF
    lines.show()
//    val linesFiltered = lines.filter(rec => rec.contains("GET /department/"))
//    val countByDepartment = linesFiltered.
//      map(rec => (rec.split(" ")(6).split("/")(2), 1)).
//      reduceByKey(_ + _)
//    //        reduceByKeyAndWindow((a:Int, b:Int) => (a + b), Seconds(300), Seconds(60))
//    //    countByDepartment.saveAsTextFiles(args(0))
//    // Below function call will save the data into HDFS
//    countByDepartment.saveAsTextFiles(args(0))
    ssc.start()
    ssc.awaitTermination()
  }


}
