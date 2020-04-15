package bench.benchmarker

expect class Utils {
    companion object {
        fun getNanos(): Long

        fun read(): String

        fun getPlatform(): String

        fun writeCsv(experimentResult: List<OneTurnResult>, benchName: String)

        fun runGC()
    }
}