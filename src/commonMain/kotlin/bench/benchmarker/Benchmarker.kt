package bench.benchmarker

import bench.benchs.*


class Benchmarker {
    fun start(benchs: List<BaseBench>, all: Boolean, enabled: Boolean, platform: String) {
        var timeStartMini: Long
        var timeStopMini: Long
        val blackhole = Blackhole()

        val benchmarksToRun = when {
                all -> benchmarks
                enabled -> benchmarks.filter { it.enabled }
                else -> benchs
            }

        for (bench in benchmarksToRun) {
            if (!bench.enabled && enabled) continue

            Utils.runGC()

            val results = Array<Long>(bench.repeats) { 0 }

            var s = 0
            val timeStartBench = Utils.getNanos()
            while (s < bench.repeats) {
                timeStartMini = Utils.getNanos()
                bench.run(blackhole)
                timeStopMini = Utils.getNanos()
                results[s] = timeStopMini - timeStartMini
                s++
            }

            val timeStopBench = Utils.getNanos()

            val objResults = results.mapIndexed {n, res ->
                OneTurnResult(
                    bench.name,
                    n,
                    res
                )
            }

            val sumTime = timeStopBench - timeStartBench

            println("Benchmark ${bench.name} on $platform completed")
            println("Time (all): $sumTime = ${sumTime / 1000.0}μs")
            println("Time (min): ${objResults.minBy { it.time }!!.time}ns = ${objResults.minBy { it.time }!!.time / 1000.0}μs")
            println("Time (max): ${objResults.maxBy { it.time }!!.time}ns = ${objResults.maxBy { it.time }!!.time / 1000.0}μs")
            println("Avg time (for ${bench.repeats} iterations): " +
                    "${sumTime / bench.repeats}ns = ${sumTime / bench.repeats / 1000}μs")
            println()
            Utils.writeCsv(objResults, bench.name)
        }
    }
}

fun main() {
    println("Select tests (enter tasks number, separated by space):")
    println(benchmarks.mapIndexed { n, bench -> "$n ${bench.name} [${if (bench.enabled) "+" else "-"}]" }.joinToString("\n"))
    println("ALL: Run all tests")
    println("ENB: Run all enabled tests (marked +)")
    val inp = Utils.read()

    val platform = Utils.getPlatform()

    when (inp.toLowerCase()) {
        "all" -> Benchmarker().start(listOf(), all = true, enabled = false, platform = platform)
        "enb" -> Benchmarker().start(listOf(), all = false, enabled = true, platform = platform)
        else -> {
            val numbers = inp.split(" ").map { it.toInt()}
            val benchs = benchmarks.filterIndexed { n, _ -> n in numbers }
            Benchmarker().start( benchs, all = false, enabled = false, platform = platform)
        }
    }
}