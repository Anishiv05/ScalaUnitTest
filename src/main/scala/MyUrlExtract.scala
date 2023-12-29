import java.io.{FileNotFoundException, PrintWriter}
import scala.io.Source
import scala.util.{Using, Try}

class MyUrlExtract(inputFile: String, outputFile: String) {

  private val urlPattern = """\b(https?)://\S+\b""".r

  def readAndWriteUrls(): Unit = {
    Try {
      Using.resource(Source.fromFile(inputFile)) { source =>
       // val urls = source.getLines().flatMap(line => urlPattern.findAllMatchIn(line).map(_.group(0))).toList
        val urls = source.getLines().flatMap(line => urlPattern.findAllIn(line)).toList

        Using.resource(new PrintWriter(outputFile)) { writer =>
          urls.foreach(url => writer.println(url))
        }

        println(s"Extracted URLs written to $outputFile")
      }
    } recover {
      case e: FileNotFoundException => println(s"File not found: ${e.getMessage}")
      case ex: Exception => println(s"An error occurred: ${ex.getMessage}")
    }
  }
}

object MyUrlExtract extends App {

  val inputFile = "src/main/scala/MyInput"
  val outputFile = "src/main/scala/MyOutput"

  val urlExtractor = new MyUrlExtract(inputFile, outputFile)
  urlExtractor.readAndWriteUrls()
  println("Done")
}

