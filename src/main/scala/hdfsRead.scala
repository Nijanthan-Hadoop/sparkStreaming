import org.apache.hadoop.conf.Configuration
import org.apache.hadoop.fs.FileSystem
import org.apache.hadoop.fs.Path
import java.util.Properties
import org.apache.kafka.clients.producer._
import org.apache.parquet
import java.io.PrintWriter



object hdfsRead {

  def main(args:Array[String]): Unit = {

//    val path = new Path("/file1")
//    val conf = new Configuration()
//    val fileSystem = FileSystem.get(conf)
//    val stream = fileSystem.open(path)
//    def readLines = Stream.cons(stream.readLine, Stream.continually( stream.readLine))
////    readLines.takeWhile(_ != null).foreach(line => println(line))
//
//
//    val  props = new Properties()
//    props.put("bootstrap.servers", "localhost:9092")
//    props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer")
//    props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer")
//   // props.put("schema.registry.url", "http://localhost:8081")
//
//
//    val producer = new KafkaProducer[String,String](props)
//    val TOPIC = "parquetRead"
//
//    for ( i <- 1 to 10)
//    {
//      val record = new ProducerRecord(TOPIC,"key",s"hello $i")
//        producer.send(record)
//    }
//
//    readLines.takeWhile(_ != null).foreach(line => val record = new producerRecord(TOPIC,"key",line);producer.send(record))
//
//    producer.close()
  }

}
