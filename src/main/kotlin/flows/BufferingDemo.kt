package flows

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.buffer
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

private fun generate(): Flow<Int> = flow {
    for (i in 1..3) {
        delay(1000L)
        emit(i)
    }
}

//With Buffer
fun main() {
    runBlocking {
        val time = measureTimeMillis {
            generate().buffer().collect { value ->
                delay(3000L)
                println(value)
            }
        }
        println("Collected in $time ms Time")
    }
}

/*
Without Buffer
fun flows.flows.flows.flows.errorhandling.main() {
    runBlocking {
        val time = measureTimeMillis {
            flows.generate().collect { value ->
                delay(3000L)
                println(value)
            }
        }
        println("Collected in $time ms Time")
    }
}*/


