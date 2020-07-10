package flows

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeoutOrNull

fun main() {

    runBlocking {
        val numbersFLow1 = sendNumbersAfter400MilliSecondsDelay()
        println("Flow has NOT started yet")
        println("WILl Start the flow now...")

        //WITH TIMEOUT OR NULL will cancel the coroutine after 1000 milliseconds
        /*
        Runs a given suspending block of code inside a coroutine with a specified timeout
        and returns null if this timeout was exceeded.
        The code that is executing inside the block is cancelled on timeout
        and the active or next invocation of cancellable suspending function inside the block
        throws a TimeoutCancellationException.
         */
        withTimeoutOrNull(1000L) {
            numbersFLow1.collect {
                println(it)
            }

        }


    }
}

fun sendNumbersAfter400MilliSecondsDelay() = flow {
    val list = listOf(1, 2, 3, 4, 5, 6, 7, 8)
    list.forEach {
        delay(400L)
        emit(it)
    }
}