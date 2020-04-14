package bench.benchs

import bench.benchmarker.Blackhole
import kotlin.random.Random

class RandNumsSum : BaseBench {
    override val name: String = "Sum of random numbers"
    override val repeats: Int = 1000
    override val enabled: Boolean = true

    override fun run(blackhole: Blackhole) {
        for (i in 0..100000) {
            val a = Random.nextInt()
            val b = Random.nextInt()
            val sum = a + b
            blackhole.consume(sum)
        }
    }

}