package flows

import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking

//Creating a flow directly from a collection using asFLow method
fun main() {

    runBlocking {
        sendNumbersFromAnyTypeOfParameter().collect {
            println("the number is $it")
        }
    }
}

fun sendNumbersFromAnyTypeOfParameter() = flowOf("ONE", "TWO", "THREE", "FOUR", "FIVE",6,8,9)
