package sharedstate

import kotlinx.coroutines.*
import java.util.concurrent.atomic.AtomicInteger
import kotlin.system.measureTimeMillis

fun main() {
    runBlocking {
        val counterContext = newSingleThreadContext("COUNTERCONTEXT")
        var counter = 0
        withContext(Dispatchers.Default) {
            massiveRun {
                withContext(counterContext) {
                    counter++
                }

            }
        }
        println("counter = $counter")
    }
}

private suspend fun massiveRun(action: suspend () -> Unit) {
    val n = 100
    val k = 1000

    val time = measureTimeMillis {
        coroutineScope {
            repeat(n) {
                launch {
                    repeat(k) {
                        action()
                    }
                }
            }
        }
    }

    println("Completed ${n * k} actions in $time ms")
}