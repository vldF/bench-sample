package bench.benchs

import bench.benchmarker.Blackhole

class PrimalNumbersBench : BaseBench {
    override val name: String = "Primal"
    override val repeats: Int = 1000
    override val enabled = true
    override fun run(blackhole: Blackhole) {
        var count = 0
        for (i in 2..10000) {
            var flag = true
            for (j in 2 until i) {
                if (i % j == 0) {
                    flag = false
                    break
                }
            }
            if (flag) count++
        }
        blackhole.consume(count)
    }
}