package bench.benchs

import bench.benchmarker.Blackhole
import kotlin.random.Random

class SinCalcMultiBench : BaseBench {
    override val name: String = "Sinus for multi args calculating"
    override val repeats: Int = 1000
    override val enabled: Boolean = true

    override fun run(blackhole: Blackhole) {
        for (arg in 0..1000) {
            var t: Double = arg + Random.nextDouble(0.0, 1.0)
            var res: Double = t
            var step = 3

            while (t > 0.000000001) {
                t = -t * arg * arg / (step * (step - 1))
                res += t
                step += 2
            }

            blackhole.consume(res)
        }
    }

}