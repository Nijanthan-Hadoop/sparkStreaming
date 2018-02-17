import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.sql.SQLContext


object streaming {
  def main(args:Array[String]): Unit =
  {
    val conf = new SparkConf()
      .setMaster("local[2]")
      .setAppName("")
    val sc = new SparkContext(conf)
    val sqlContext = new SQLContext(sc)
    import sqlContext.implicits._

    val a=List(1,2,3,4,5)
    for ( i <- a)
    {
      println(i)
    }
    val dfy=sc.parallelize(a).toDF
    dfy.show()
    println("a")
  }
}