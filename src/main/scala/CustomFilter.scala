object CustomFilter extends App {

  private def isEven(num: Int): Boolean = {
    num % 2 == 0
  }

  private def isOdd(num: Int): Boolean = {
    num % 2 != 0
  }

  private def customFilter(ls: List[Int], predicate: Int => Boolean): List[Int] = {
    val result: List[Int] = ls.flatMap { x =>
      if (predicate(x)) List(x)
      else List.empty[Int]
    }
    result
  }

  private val myList: List[Int] = (1 to 10).toList
  private val myList1: List[Int] = List.range(1,10)
  private val filteredEvenList = customFilter(myList, isEven)
  private val filteredOddList = customFilter(myList1, isOdd)
  println(filteredOddList)
  println(filteredEvenList)
  println("DONE")
}
