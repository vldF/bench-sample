package bench.benchmarker

import kotlinx.cinterop.cstr
import platform.posix.fopen
import platform.posix.fwrite
import platform.posix.mkdir
import platform.windows.OpenProcess
import kotlin.system.getTimeNanos

actual class Utils {
    actual companion object {
        actual fun getNanos() = getTimeNanos()
        actual fun read() = readLine()!!
        actual fun getPlatform() = "Kotlin-Native"
        @ExperimentalUnsignedTypes
        actual fun writeCsv(experimentResult: List<OneTurnResult>, benchName: String) {
            createDirIfNotExist(benchName)
            val textToWrite = experimentResult.joinToString(separator = "\n") { it.toString() }
            val file = fopen( "./bench/${benchName}/${getPlatform()}.csv", "wt")
            fwrite(textToWrite.cstr, textToWrite.length.toULong(), 1u, file)
        }

        private fun createDirIfNotExist(bench: String) {
            mkdir("./bench")
            mkdir("./bench/$bench")
        }

        actual fun runGC() {
            kotlin.native.internal.GC.collect()
        }
    }
}