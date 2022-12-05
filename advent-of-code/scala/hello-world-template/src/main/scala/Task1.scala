import scala.io.Source

object Task1 {

  def computeFirstPart(fileName: String): Unit = {
    var maxScore = 0
    var currScore = 0
    for (line <- Source.fromFile(fileName).getLines) {
      if (line.length == 0) {
        maxScore = Math.max(maxScore, currScore)
        currScore = 0
      } else {
        currScore += Integer.parseInt(line)
      }
    }
    println(maxScore)
  }

  def computeSecondPart(fileName: String) = {
    var firstMax, secondMax, thirdMax = 0
    var currScore = 0
    for (line <- Source.fromFile(fileName).getLines) {
      if (line.length == 0) {
        if (currScore > firstMax) {
          thirdMax = secondMax
          secondMax = firstMax
          firstMax = currScore
        } else if (currScore > secondMax) {
          thirdMax = secondMax
          secondMax = currScore
        } else if (currScore > thirdMax) {
          thirdMax = currScore
        }
        currScore = 0

      } else {
        currScore += Integer.parseInt(line)
      }
    }
    println(firstMax + secondMax + thirdMax)
  }


  def main(args: Array[String]) = {
    val fileName = "../../inputs/day_1.txt"
    computeFirstPart(fileName)
    computeSecondPart(fileName)
  }
}
