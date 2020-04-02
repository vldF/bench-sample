package bench.benchmarker

import kotlin.random.Random

class Blackhole {
    private val int1: Int = Random.nextInt()
    private val int2: Int = int1 + 1

    fun consume(int: Int) {
        if (int xor int1 == int xor int2) {
            //it never happening
            throw IllegalArgumentException("Something went wrong")
        }
    }
    
    fun consume(obj: Any) {
        if (obj.hashCode() xor int1 == obj.hashCode() xor int2) {
            //it never happening
            throw IllegalArgumentException("Something went wrong")
        }
    }
}