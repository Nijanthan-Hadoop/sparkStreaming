import org.apache.hadoop.conf.Configuration
import org.apache.hadoop.fs.FileSystem
import org.apache.hadoop.fs.Path
import java.io.PrintWriter


object hdfsRead {

  def main(args:Array[String]): Unit = {

    val path = new Path("/file1")
    val conf = new Configuration()
    val fileSystem = FileSystem.get(conf)
    val stream = fileSystem.open(path)
    def readLines = Stream.cons(stream.readLine, Stream.continually( stream.readLine))

    readLines.takeWhile(_ != null).foreach(line => println(line))
  }

}
