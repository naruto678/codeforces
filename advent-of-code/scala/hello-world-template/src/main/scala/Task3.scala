
import java.util
import java.util.concurrent.CopyOnWriteArrayList
import scala.collection.mutable
import scala.io.Source

object Task3 {
  def main(args: Array[String]): Unit = {
    val fileName = "../../inputs/day_3.txt"
    computeFirst(fileName)
    computeSecond(fileName)
  }

  def computeSecond(fileName: String): Unit = {
    val lines = Source.fromFile(fileName).getLines().iterator
    val lineGroup = new util.ArrayList[util.ArrayList[String]]()
    while (lines.hasNext) {
      val currGroup = new util.ArrayList[String]()
      currGroup.add(lines.next())
      currGroup.add(lines.next())
      currGroup.add(lines.next())
      lineGroup add currGroup
    }
    var totalScore = 0
    lineGroup.forEach(group => {
      val firstSet = new mutable.HashSet[Char]()
      val secondSet = new mutable.HashSet[Char]()
      val thirdSet = new mutable.HashSet[Char]()
      for (elem <- group.get(0))
        firstSet.add(elem)
      for (elem <- group.get(1))
        secondSet.add(elem)
      for (elem <- group.get(2))
        thirdSet.add(elem)
      var res = ' '
      for (elem <- firstSet) {
        if (secondSet.contains(elem) && thirdSet.contains(elem))
          res = elem
      }
      if (res.isUpper)
        totalScore += res.asDigit - 'A'.asDigit + 27
      else
        totalScore += res.asDigit - 'a'.asDigit + 1
    })
    println(totalScore)
  }

  def computeFirst(fileName: String): Unit = {
    var score: Int = 0
    for (line <- Source.fromFile(fileName).getLines) {
      val firstString = line.substring(0, line.length / 2)
      val secondString = line.substring(line.length / 2)
      val set = new mutable.HashSet[Char]()
      for (elem <- firstString)
        set.add(elem)
      var res = ' '
      for (elem <- secondString)
        if (set.contains(elem)) {
          res = elem
        }
      if (res.isUpper)
        score += res.asDigit - 'A'.asDigit + 27
      else
        score += res.asDigit - 'a'.asDigit + 1
    }
    println(score)

  }
}
