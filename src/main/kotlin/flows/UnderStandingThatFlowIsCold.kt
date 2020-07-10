package flows

import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking

fun main() {

    runBlocking {
        val numbersFLow1 = sendNumbersHere()
        //Code Will not run since FLOWS are cold
        //and it wont run until collect() is called on that flow
        println("Flow has NOT started yet")
        println("WILl Start the flow now...")
        numbersFLow1.collect { println(it) }


    }
}

fun sendNumbersHere() = flow {
    val list = listOf(1, 2, 3, 4, 5, 6, 7, 8)
    list.forEach { emit(it) }
}