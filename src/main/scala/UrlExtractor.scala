import scala.io.Source
import java.io.PrintWriter

class UrlExtractor(inputFile: String, outputFile: String) {

  // Created a Regex for URL pattern
  private val urlPattern = """\b(https?)://\S+\b""".r

  def readAndWriteUrls(): Unit = {
    val urls = Source.fromFile(inputFile).getLines().flatMap(line => urlPattern.findAllMatchIn(line).map(_.group(0))).toList

    val writer = new PrintWriter(outputFile)
    try {
      urls.foreach(url => writer.println(url))
    } finally {
      writer.close()
    }
    println(s"Extracted URLs written to $outputFile")
  }
}

object UrlExtractor extends App {

  val inputFile = "src/main/scala/MyInput"
  val outputFile = "src/main/scala/MyOutput"

  val urlExtractor = new UrlExtractor(inputFile, outputFile)

  urlExtractor.readAndWriteUrls()
}
