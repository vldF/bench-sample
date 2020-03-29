package sample

import kotlinx.benchmark.*


@State(Scope.Benchmark)
@OutputTimeUnit(BenchmarkTimeUnit.MILLISECONDS)
@Measurement(time = 1, timeUnit = BenchmarkTimeUnit.SECONDS)
@BenchmarkMode(Mode.Throughput)
class Sample {
    @Benchmark
    fun main() {
        2+7
    }
}

@TargetClass(className = "")