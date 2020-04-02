package bench.benchmarker

import bench.benchs.*


class Benchmarker {
    fun main() {
        var timeStartMini: Long
        var timeStopMini: Long
        var timeStartBench: Long
        var timeStopBench: Long

        val blackhole = Blackhole()

        for (bench in bencmarks) {
            if (!bench.enabled) continue
            val results = Array<Long>(bench.repeats) { 0 }

            var s = 0
            timeStartBench = System.nanoTime()
            while (s < bench.repeats) {
                timeStartMini = System.nanoTime()
                bench.run(blackhole)
                timeStopMini = System.nanoTime()
                results[s] = timeStopMini - timeStartMini
                ++s
            }
            timeStopBench = System.nanoTime()

            val experimentResult = ExperimentResult(
                bench.name,
                bench.repeats,
                timeStopBench - timeStartBench
            )
            val objResults = results.mapIndexed {n, res ->
                OneTurnResult(
                    bench.name,
                    n,
                    res
                )
            }

            println("Benchmark ${bench.name} completed")
            println("Time (all): ${experimentResult.time}ns = ${experimentResult.time / 1000.0}μs")
            println("Time (min): ${objResults.minBy { it.time }!!.time}ns = ${objResults.minBy { it.time }!!.time / 1000.0}μs")
            println("Time (max): ${objResults.maxBy { it.time }!!.time}ns = ${objResults.maxBy { it.time }!!.time / 1000.0}μs")
            println("Avg time (for ${experimentResult.repeats} iterations): " +
                    "${experimentResult.time / experimentResult.repeats}ns = ${experimentResult.time / experimentResult.repeats / 1000}μs")
        }
    }
}

fun main() {
    Benchmarker().main()
}