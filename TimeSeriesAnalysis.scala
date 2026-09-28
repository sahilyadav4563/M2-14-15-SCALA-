import scala.io.Source

object TimeSeriesAnalysis {

  def main(args: Array[String]): Unit = {

    // Read CSV file
    val file = Source.fromFile("ind_vs_wi_runs.csv")

    val data = file.getLines().drop(1).map { line =>
      val parts = line.split(",")

      val team = parts(0)
      val player = parts(1)
      val runs = parts(2).toInt
      val balls = parts(3).toInt

      (team, player, runs, balls)
    }.toList

    file.close()

    // Display data
    println("India vs West Indies Runs")

    data.foreach {
      case (team, player, runs, balls) =>
        println(s"$team - $player : $runs runs from $balls balls")
    }

    // Extract runs
    val runs = data.map(_._3)

    // Basic analysis
    val average = runs.sum.toDouble / runs.size
    val highest = runs.max
    val lowest = runs.min

    println("\nTime Series Analysis")
    println(f"Average Runs: $average%.2f")
    println(s"Highest Runs: $highest")
    println(s"Lowest Runs: $lowest")

    // Team-wise analysis
    val indiaRuns = data
      .filter(_._1 == "India")
      .map(_._3)

    val westIndiesRuns = data
      .filter(_._1 == "West Indies")
      .map(_._3)

    println(s"\nIndia Player Runs: ${indiaRuns.sum}")
    println(s"West Indies Player Runs: ${westIndiesRuns.sum}")
  }
}
