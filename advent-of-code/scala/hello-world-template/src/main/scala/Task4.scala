import scala.::
import scala.io.Source

object Task4 {
  def main(args: Array[String]): Unit = {
    val fileName = "../../inputs/day_4.txt"
    computeFirstPart(fileName)
    computeSecondPart(fileName)

  }

  def computeSecondPart(fileName: String) = {
    var score = 0
    for (line <- Source.fromFile(fileName).getLines) {
      val ranges = line.split(",")
      val firstRange = ranges(0).split("-").map(elem => Integer.parseInt(elem)).toList
      val secondRange = ranges(1).split("-").map(elem => Integer.parseInt(elem)).toList

      val minRange = if (firstRange(0) < secondRange(0)) firstRange else secondRange
      val maxRange = if (firstRange(0) < secondRange(0)) secondRange else firstRange

      if (minRange(1) >= maxRange(0))
        score += 1
    }
    println(score)
  }

  def computeFirstPart(fileName: String) = {
    var result = 0
    for (line <- Source.fromFile(fileName).getLines) {
      val ranges = line.split(",")
      val firstRange = ranges(0).split("-").map(elem => Integer.parseInt(elem)).toArray
      val secondRange = ranges(1).split("-").map(elem => Integer.parseInt(elem)).toArray
      if (firstRange(0) <= secondRange(0) && firstRange(1) >= secondRange(1))
        result += 1
      else if (secondRange(0) <= firstRange(0) && secondRange(1) >= firstRange(1))
        result += 1
    }
    println(result)
  }
}