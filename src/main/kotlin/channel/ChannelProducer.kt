package channel

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {
    runBlocking {
        val channel = produce {
            for (x in 1..5) {
                send(x * x)
            }
        }
        for (i in channel) {
            println(i)
        }
    }


}