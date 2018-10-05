package com.meap.chapter2

import com.Runner

/**
  * Chapter 2 - Getting started
  */
object Chapter2Runner extends Runner {
  override def run(): Unit = {
    val firstTenFibonacciNumbers = List.range(1, 10).map(Chapter2.fib)

    println(s"Fibonacci : ${firstTenFibonacciNumbers.toString}")

    val sortedNonInclusiveArray: Array[Int] = Array(1, 2, 4, 4, 5, 6)

    println(s"\nTest array data${sortedNonInclusiveArray.mkString("[", " , ", "]")}")


    val isRaising = Chapter2.isSorted(sortedNonInclusiveArray, (a: Int, b: Int) => a <= b)
    println(s"Sorted raising : $isRaising")

    val isStrictRaising = Chapter2.isSorted(sortedNonInclusiveArray, (a: Int, b: Int) => a < b)
    println(s"Sorted strict raising : $isStrictRaising")


    val fieldNumerator: (Array[Char], Int) => String = (a: Array[Char], b: Int) => {
      s"${a.map(_.toString).reduce(_ + _)} $b"
    }

    val chars = Array('i', 'd')

    val idNumerator: Int => String = Chapter2.partial1(chars, fieldNumerator)

    val id: String = idNumerator(1)

    println(s"Partial result : $id")
    println(s"\nPartial is equal to original : ${fieldNumerator(chars, 1) == id}")


    val sumCurried: Int => Int => Int = Chapter2.curry((a: Int, b: Int) => a + b)
    println(s"\nCurried sum : ${sumCurried(1)(2)}")

    val sumUncurried: (Int, Int) => Int = Chapter2.uncurry(sumCurried)

    println(s"Uncurried sum: ${sumUncurried(1, 2)}")
    println(s"Curried sum same as uncurried sum = ${sumUncurried(1, 2) == sumCurried(1)(2)}")

  }
}
