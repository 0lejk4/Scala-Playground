package com

import com.gelo.GeloDummyRunner
import com.meap.MeapDummyRunner

object Main {
  def main(args: Array[String]): Unit = {
    val runners = List(MeapDummyRunner, GeloDummyRunner)
    runners.foreach(_.run())
  }
}
