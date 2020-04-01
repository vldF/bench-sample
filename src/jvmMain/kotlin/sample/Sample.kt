package sample

import com.oracle.svm.core.annotate.Alias
import com.oracle.svm.core.annotate.RecomputeFieldValue
import com.oracle.svm.core.annotate.TargetClass
import kotlinx.benchmark.*

@State(Scope.Benchmark)
@OutputTimeUnit(BenchmarkTimeUnit.MILLISECONDS)
@Measurement(time = 1, timeUnit = BenchmarkTimeUnit.SECONDS)
@BenchmarkMode(Mode.Throughput)

class Sample2 {
    @Benchmark
    fun main() {
        print(2+1+7)
    }


    @TargetClass(className = "org.openjdk.jmh.runner.InfraControl")
    companion object Target_org_openjdk_jmh_runner_InfraControl {
        @Alias
        @RecomputeFieldValue(kind = RecomputeFieldValue.Kind.FieldOffset, declClass = Array<Any>::class)
        @JvmField val ADDRESS_FIELD_OFFSET: Int = 0
    }
}

