import java.io.{File, FileWriter}
import scala.io.Source
import scala.util.Using

object Etl:
  sealed trait Etl[A, B]:
    def extract(input: String): A

    def transform(data: A): B

    def load(data: B, output: String): Unit

  given StringImpl: Etl[List[String], List[String]] with
    override def extract(input: String): List[String] = FileUtils.extract(input)

    override def transform(data: List[String]): List[String] = data.map(_.toLowerCase)

    override def load(data: List[String], output: String): Unit = FileUtils.load(data, output)

  given IntImpl: Etl[List[String], List[Int]] with
    override def extract(input: String): List[String] = FileUtils.extract(input)

    override def transform(data: List[String]): List[Int] = data.map(_.toInt).map(_ * 2)

    override def load(data: List[Int], output: String): Unit = FileUtils.load(data, output)