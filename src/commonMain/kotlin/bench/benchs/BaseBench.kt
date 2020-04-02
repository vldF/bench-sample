package bench.benchs

interface BaseBench {
    val name: String

    val repeats: Int

    fun run(): Any
}