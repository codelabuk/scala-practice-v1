import java.io.{File, FileWriter}
import scala.io.Source
import scala.util.Using

@main def run: Unit =
  val input: String = ""
  val output: String = ""
  etl(input, output)

def etl(inputFilePath: String, outputFIlePath: String): Unit =
  val extracted = extract(inputFilePath)
  val transformed = transform(extracted)
  load(transformed, outputFIlePath)
end etl



