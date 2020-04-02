package bench.benchs

class TestBench : BaseBench {
    override val name: String = "Primal"
    override val repeats: Int = 1000
    override fun run(): Int {
        var count = 0
        for (i in 2..3000) {
            var flag = true
            for (j in 2 until i) {
                if (i % j == 0) {
                    flag = false
                    break
                }
            }
            if (flag) count++
        }
        return count
    }
}