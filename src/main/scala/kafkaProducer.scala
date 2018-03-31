
import org.apache.kafka.clients.producer.{KafkaProducer, ProducerRecord}
import java.util.Properties
import org.apache.avro.Schema.Parser
import org.apache.avro.generic.GenericData

case class User(name: String, favoriteNumber: Int, favoriteColor: String)


object kafkaProducer {

  def main(args:Array[String]): Unit = {
    val props = new Properties()
    props.put("bootstrap.servers", "localhost:9092")
    props.put("schema.registry.url","http://0.0.0.0:8081")
    props.put("key.serializer", "io.confluent.kafka.serializers.KafkaAvroSerializer")
    props.put("value.serializer", "io.confluent.kafka.serializers.KafkaAvroSerializer")
    props.put("acks", "1")

    val producer = new KafkaProducer[String, GenericData.Record](props)
    val schemaParser= new Parser

    val key = "nij"

    val valueSchemaJson = s"""
    {
      "namespace": "com.avro.junkie",
      "type": "record",
      "name": "User2",
      "fields": [
        {"name": "name", "type": "string"},
        {"name": "favoriteNumber",  "type": "int"},
        {"name": "favoriteColor", "type": "string"}
      ]
    }
  """
    val valueSchemaAvro = schemaParser.parse(valueSchemaJson)
    val avroRecord = new GenericData.Record(valueSchemaAvro)

    val mary = new User("nijanthan",3,"blue")
    avroRecord.put("name",mary.name)
    avroRecord.put("favoriteNumber",mary.favoriteNumber)
    avroRecord.put("favoriteColor",mary.favoriteColor)

    val record = new ProducerRecord("nijavro", key, avroRecord)
    val ack = producer.send(record)
  }

}
