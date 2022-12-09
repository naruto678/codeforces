import scala.collection.immutable.HashSet
import scala.collection.mutable
import scala.io.Source
import scala.util.control.Breaks.{break, breakable}

object Task6 {
  def main(args: Array[String]) = {
    val fileName = "../../inputs/day_6.txt"
    computeFirstPart(fileName)
    computeSecondPart(fileName)

  }

  def computeFirstPart(fileName: String) = {
    val line = Source.fromFile(fileName).getLines().next()
    breakable {
      for (right <- 0 to line.length - 5) {
        val currLine = line.substring(right, right + 4)
        val set = HashSet[Char](currLine.charAt(0), currLine.charAt(1), currLine.charAt(2), currLine.charAt(3))
        if (set.size == 4) {
          println(right + 4)
          break
        }
      }
    }
  }

  def computeSecondPart(fileName: String) = {
    val line = Source.fromFile(fileName).getLines.next
    breakable {
      for (right <- 0 to line.length - 15) {
        val currString = line.substring(right, right + 14)
        val set = new mutable.HashSet[Char]()
        for (elem <- currString)
          set.add(elem)
        if (set.size == 14) {
          println(right + 14)
          break
        }
      }
    }
  }
}
