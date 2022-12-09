import scala.io.Source

object Task7 {
  def main(args: Array[String]): Unit = {
    val fileName = "../../inputs/day_7.txt"
    computeFirstPart(fileName)
    computeSecondPart(fileName)
  }

  def computeFirstPart(fileName: String) = {
    for (line <- Source.fromFile(fileName).getLines) {
      if(line.startsWith("$")){

      }
    }
  }

  def computeSecondPart(fileName: String) = {

  }
}
