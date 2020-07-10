package channel.util

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.channels.produce

fun CoroutineScope.produceCustomSquaresChannel(tillNumber: Int) = produce {
    for (x in 1..tillNumber) {
        send(x * x)
    }
}