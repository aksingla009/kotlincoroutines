package channel

import channel.util.produceCustomSquaresChannel
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.runBlocking

fun main() {
    runBlocking {

        /* for (i in produceCustomSquaresChannel(3)) {
             println(i)
         }*/

        produceCustomSquaresChannel(3).consumeEach {
            println(it)
        }
    }


}