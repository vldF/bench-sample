package bench.benchs

import bench.benchmarker.Blackhole
import kotlin.random.Random

class ListAddBench : BaseBench {
    override val name: String = "listAdd"
    override val repeats: Int = 1000
    override val enabled: Boolean = true

    override fun run(blackhole: Blackhole) {
        val res = mutableListOf<Int>()
        for (i in 0..100000)
            res.add(Random.nextInt())

        blackhole.consume(res)
    }
}