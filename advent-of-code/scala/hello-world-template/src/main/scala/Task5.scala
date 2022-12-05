
import java.util.List
import java.util.HashMap
import scala.collection.mutable.ListBuffer
import scala.io.Source

object Task5 {

  def computeFirstPart(fileName: String, map: HashMap[Integer, List[String]]) = {
    for (line <- Source.fromFile(fileName).getLines) {
      val values = line.split("\\s+")
      val numberOfBlocks = Integer.parseInt(values(1))
      val from = Integer.parseInt(values(3))
      val to = Integer.parseInt(values(5))
      val fromList = map.get(from)
      val toList = map.get(to)
      for (_ <- 0 to numberOfBlocks) {
        toList.add(fromList.remove(fromList.size() - 1))
      }

    }
    val res = new StringBuilder()
    for (i <- 1 to 9) {
      val elem = map.get(i)
      if (!elem.isEmpty)
        res.append(elem.get(elem.size() - 1))
    }
    println(res)
  }

  def computeSecondPart(fileName: String, map: HashMap[Integer, List[String]]) = ???

  def main(args: Array[String]): Unit = {
    val map = new HashMap[Integer, ListBuffer[String]]()
    map.put(1, List.of("B", "S", "V", "Z", "G", "P", "W"))
    map.put(2, List.of("J", "V", "B", "C", "Z", "F"))
    map.put(3, List.of("V", "L", "M", "H", "N", "Z", "D", "C"))
    map.put(4, List.of("L", "D", "M", "Z", "P", "F", "J", "B"))
    map.put(5, List.of("V", "F", "C", "G", "J", "B", "Q", "H"))
    map.put(6, List.of("G", "F", "Q", "T", "S", "L", "B"))
    map.put(7, List.of("L", "G", "C", "Z", "V"))
    map.put(8, List.of("N", "L", "G"))
    map.put(9, List.of("J", "F", "H", "C"))
    val fileName = "../../inputs/day_5.txt"
    computeFirstPart(fileName, map)
    map.clear()
    map.put(1, List.of("B", "S", "V", "Z", "G", "P", "W"))
    map.put(2, List.of("J", "V", "B", "C", "Z", "F"))
    map.put(3, List.of("V", "L", "M", "H", "N", "Z", "D", "C"))
    map.put(4, List.of("L", "D", "M", "Z", "P", "F", "J", "B"))
    map.put(5, List.of("V", "F", "C", "G", "J", "B", "Q", "H"))
    map.put(6, List.of("G", "F", "Q", "T", "S", "L", "B"))
    map.put(7, List.of("L", "G", "C", "Z", "V"))
    map.put(8, List.of("N", "L", "G"))
    map.put(9, List.of("J", "F", "H", "C"))
    computeSecondPart(fileName, map)
  }

}
