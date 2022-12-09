import scala.io.Source
import scala.util.control.Breaks.{break, breakable}

object Task8 {
  def main(args: Array[String]): Unit = {
    val fileName = "../../inputs/day_8.txt"
    computeFirstPart(fileName)
    computeSecondPart(fileName)
  }

  def isVisible(arr: Array[Array[Char]], row: Int, col: Int, x_increment: Int, y_increment: Int): Boolean = {
    val currVal = arr(row)(col)
    var x = row
    var y = col
    breakable {
      while (true) {
        x += x_increment
        y += y_increment
        if (x < 0 || y < 0 || x > arr.length - 1 || y > arr(0).length - 1)
          break
        if (arr(x)(y) >= currVal)
          return false
      }
    }
    return true
  }


  def computeFirstPart(fileName: String) = {
    val lines = Source.fromFile(fileName).getLines.toList
    val arr = Array.ofDim[Char](lines.length, lines.head.length)
    for (i <- 0 to lines.length - 1) {
      arr(i) = lines(i).toCharArray
    }
    val dx = Array(0, 0, -1, 1)
    val dy = Array(-1, 1, 0, 0)
    var count = 0
    for (i <- 0 to arr.length - 1) {
      for (j <- 0 to arr(0).length - 1) {
        if (i == 0 || j == 0 || i == arr.length - 1 || j == arr(0).length - 1) {
          count += 1
        } else {
          var flag = false
          for (k <- 0 to dx.length - 1) {
            if (isVisible(arr, i, j, dx(k), dy(k))) {
              flag = true
            }
          }
          if (flag) count += 1
        }
      }
    }
    println(count)
  }

  def computeCount(arr: Array[Array[Char]], row: Int, col: Int): Int = {
    val dx = Array(0, 0, -1, 1)
    val dy = Array(-1, 1, 0, 0)
    var product = 1
    for (i <- 0 to dx.length - 1) {
      var currCount = 0
      val x_increment = dx(i)
      val y_increment = dy(i)
      var x = row
      var y = col
      breakable {
        while (true) {
          x += x_increment
          y += y_increment
          if (x < 0 || x > arr.length - 1 || y < 0 || y > arr(0).length - 1)
            break;
          else if(arr(x)(y)>=arr(row)(col)){
            currCount+=1
            //println("This is count", x, y , currCount)
            break
          }
          else {
            currCount += 1
            //println("This is count", x, y , currCount)
          }

        }
      }
      product *= Math.max(currCount, 1)
    }
    product
  }

  def computeSecondPart(fileName: String) = {
    val lines = Source.fromFile(fileName).getLines.toList
    val arr = Array.ofDim[Char](lines.length, lines.head.length)
    for (i <- 0 to lines.length - 1) {
      arr(i) = lines(i).toCharArray
    }
    var maxCount = 0
    for (i <- 0 to arr.length - 1) {
      for (j <- 0 to arr(0).length - 1) {
        if ((i != 0) && (j != 0) && (i != arr.length - 1) && (j != arr(0).length - 1)) {
          val currCount = computeCount(arr, i , j)
          maxCount = Math.max(currCount, maxCount)
        }
      }
    }
    println(maxCount)
  }
}
