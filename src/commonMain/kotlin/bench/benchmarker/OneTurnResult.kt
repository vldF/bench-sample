package bench.benchmarker

data class OneTurnResult (
    val name: String,
    val turnNumber: Int,
    val time: Long
) {
    override fun toString(): String ="$name,$turnNumber,$time"
}