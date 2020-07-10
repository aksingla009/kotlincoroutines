package flows

import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.runBlocking

//Creating a flow directly from a collection using asFLow method
fun main() {

    runBlocking {
        sendNumbersFromCollectionASAFlow().collect {
            println("the number is $it")
        }

    }
}

fun sendNumbersFromCollectionASAFlow() = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).asFlow()
