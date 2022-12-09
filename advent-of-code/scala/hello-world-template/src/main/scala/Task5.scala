
import scala.collection.mutable.ListBuffer
import scala.collection.mutable.HashMap
import scala.io.Source

object Task5 {

  def computeFirstPart(fileName: String, map: HashMap[Integer, ListBuffer[String]]) = {
    for (line <- Source.fromFile(fileName).getLines) {
      val values = line.split("\\s+")
      val numberOfBlocks = Integer.parseInt(values(1))
      val from = Integer.parseInt(values(3))
      val to = Integer.parseInt(values(5))
      val fromList = map.get(from).get
      val toList = map.get(to).get
      for (_ <- 0 to numberOfBlocks - 1) {
        toList.append(fromList.remove(fromList.length - 1))
      }

    }
    val res = new StringBuilder()
    for (i <- 1 to 9) {
      map.get(i).map(buffer => {
        res.append(buffer.last)
      })
    }
    println(res)
  }

  def computeSecondPart(fileName: String, map: HashMap[Integer, ListBuffer[String]]) = {
    for (line <- Source.fromFile(fileName).getLines) {
      val values = line.split("\\s+")
      val numberOfBlocks = Integer.parseInt(values(1))
      val from = Integer.parseInt(values(3))
      val to = Integer.parseInt(values(5))

      val fromList = map.get(from).get
      val toList = map.get(to).get

      val tempStack = ListBuffer[String]()
      for (_ <- 0 to numberOfBlocks-1) {
        tempStack.append(fromList.remove(fromList.length - 1))
      }
      tempStack.toList.reverse.foreach(elem => {
        toList.append(elem)
      })

    }

    val res = new StringBuilder()
    for (i <- 1 to 9) {
      map.get(i).map(buffer => {
        res.append(buffer.last)
      })

    }
    println(res)


  }

  def main(args: Array[String]): Unit = {
    val map = new HashMap[Integer, ListBuffer[String]]()
    map.put(1, ListBuffer("B", "S", "V", "Z", "G", "P", "W"))
    map.put(2, ListBuffer("J", "V", "B", "C", "Z", "F"))
    map.put(3, ListBuffer("V", "L", "M", "H", "N", "Z", "D", "C"))
    map.put(4, ListBuffer("L", "D", "M", "Z", "P", "F", "J", "B"))
    map.put(5, ListBuffer("V", "F", "C", "G", "J", "B", "Q", "H"))
    map.put(6, ListBuffer("G", "F", "Q", "T", "S", "L", "B"))
    map.put(7, ListBuffer("L", "G", "C", "Z", "V"))
    map.put(8, ListBuffer("N", "L", "G"))
    map.put(9, ListBuffer("J", "F", "H", "C"))
    val fileName = "../../inputs/day_5.txt"
    computeFirstPart(fileName, map)
    map.clear()
    map.put(1, ListBuffer("B", "S", "V", "Z", "G", "P", "W"))
    map.put(2, ListBuffer("J", "V", "B", "C", "Z", "F"))
    map.put(3, ListBuffer("V", "L", "M", "H", "N", "Z", "D", "C"))
    map.put(4, ListBuffer("L", "D", "M", "Z", "P", "F", "J", "B"))
    map.put(5, ListBuffer("V", "F", "C", "G", "J", "B", "Q", "H"))
    map.put(6, ListBuffer("G", "F", "Q", "T", "S", "L", "B"))
    map.put(7, ListBuffer("L", "G", "C", "Z", "V"))
    map.put(8, ListBuffer("N", "L", "G"))
    map.put(9, ListBuffer("J", "F", "H", "C"))
    computeSecondPart(fileName, map)
  }

}
