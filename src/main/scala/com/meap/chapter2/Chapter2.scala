package com.meap.chapter2

object Chapter2 {
  /**
    * EXERCISE 1 (optional): Write a function to get the n th Fibonacci number. The
    * first two Fibonacci numbers are 0 and 1 , and the next number is always the sum of
    * the previous two. Your definition should use a local tail-recursive function.
    */
  def fib(n: Int): Int = {
    @annotation.tailrec
    def go(n: Int, curr: Int, next: Int): Int = {
      if (n <= 0) curr
      else go(n - 1, next, curr + next)
    }

    go(n - 1, 0, 1)
  }

  /**
    * EXERCISE 2: Implement isSorted , which checks whether an Array[A] is
    * sorted according to a given comparison function.
    *
    * def isSorted[A](as: Array[A], gt: (A,A) => Boolean): Boolean
    */
  def isSorted[A](as: Array[A], gt: (A, A) => Boolean): Boolean = {
    @annotation.tailrec
    def go(as: Array[A], gt: (A, A) => Boolean, i: Int): Boolean = {
      if (i >= as.length - 1) true
      else if (!gt(as(i), as(i + 1))) false
      else go(as, gt, i + 1)
    }

    go(as, gt, 0)
  }

  /**
    * def partial1[A,B,C](a: A, f: (A,B) => C): B => C
    *
    * EXERCISE 3 (hard): Implement partial1 and write down a concrete usage
    * of it. There is only one possible implementation that compiles.
    */
  def partial1[A, B, C](a: A, f: (A, B) => C): B => C = b => f(a, b)

  /**
    * EXERCISE 4 (hard): Let's look at another example, currying , which converts a
    * function of N arguments into a function of one argument that returns another
    * function as its result.
    */
  def curry[A, B, C](f: (A, B) => C): A => B => C = a => b => f(a, b)

  /**
    * EXERCISE 5 (optional): Implement uncurry , which reverses the
    * transformation of curry .
    */
  def uncurry[A, B, C](f: A => B => C): (A, B) => C = (a, b) => f(a)(b)

  /**
    * EXERCISE 6: Implement the higher-order function that composes two
    * functions.
    */
  def compose[A, B, C](f: B => C, g: A => B): A => C = a => f(g(a))
}
