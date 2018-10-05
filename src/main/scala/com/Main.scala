package com

import com.gelo.GeloDummyRunner
import com.meap.MeapDummyRunner
import com.meap.chapter2.Chapter2Runner

object Main {
  //What should be runned
  val SHOULD_RUN = "CHAPTER_2"

  def main(args: Array[String]): Unit = {
    run(SHOULD_RUN)
    //Absolute Mad Lads
    //runAll()
  }

  /**
    * Run one concrete runner
    * @param runner - runner name
    */
  def run(runner: String): Unit = runners.getOrElse(runner, MeapDummyRunner).run()

  /**
    * Run all runners
    */
  def runAll(): Unit = runners.values.foreach(_.run())

  val runners = Map(
    "MEAP_DUMMY" -> MeapDummyRunner,
    "GELO_DUMMY" -> GeloDummyRunner,
    "CHAPTER_2" -> Chapter2Runner
  )
}
