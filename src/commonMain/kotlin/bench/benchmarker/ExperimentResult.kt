package bench.benchmarker

data class ExperimentResult(
    val name: String,
    val repeats: Int,
    val time: Long
)