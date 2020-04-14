package bench.benchs

import bench.benchmarker.Blackhole
import kotlin.random.Random

class SinCalcBench : BaseBench {
    override val name: String = "Sinus calculating"
    override val repeats: Int = 1000
    override val enabled: Boolean = true

    override fun run(blackhole: Blackhole) {
        val arg = Random.nextInt(0, 10) + Random.nextDouble(0.0, 1.0)
        var t: Double = arg / 1.0
        var res: Double = t
        var step = 3

        while (t > 0.000000001) {
            t = - t * arg * arg / (step * (step - 1))
            res += t
            step += 2
        }

        blackhole.consume(res)
    }

}