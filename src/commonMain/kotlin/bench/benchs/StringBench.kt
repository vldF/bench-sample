package bench.benchs

import bench.benchmarker.Blackhole

class StringBench : BaseBench {
    override val name: String = "StringBench"
    override val repeats: Int = 1000
    override val enabled = true
    override fun run(blackhole: Blackhole) {
        var res = ""
        for (i in 0..10000) {
            var newString = i.toString()
            newString = newString.replace("0", "x")
            res += newString
        }

        blackhole.consume(res.length)
    }

}