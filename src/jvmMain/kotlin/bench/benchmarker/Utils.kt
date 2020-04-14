package bench.benchmarker

import java.io.File

actual class Utils {
    actual companion object {
        actual fun getNanos() = System.nanoTime()
        actual fun read() = readLine()!!
        actual fun getPlatform(): String = System.getProperty("java.vm.name")
        actual fun writeCsv(experimentResult: List<OneTurnResult>, benchName: String) {
            createDirIfNotExist(benchName)

            val textToWrite = experimentResult.joinToString(separator = "\n") { it.toString() }
            val file = File("./bench/$benchName/${getPlatform()}.csv")
            file.writeText(textToWrite)
        }

        private fun createDirIfNotExist(bench: String) {
            File("./bench/$bench").mkdirs()
        }
    }
}