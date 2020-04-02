package bench.benchs

import bench.benchmarker.Blackhole

interface BaseBench {
    val name: String

    val repeats: Int

    val enabled: Boolean

    fun run(blackhole: Blackhole)
}