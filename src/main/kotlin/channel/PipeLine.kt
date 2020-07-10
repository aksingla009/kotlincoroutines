package channel

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.cancelChildren
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.runBlocking

fun CoroutineScope.produceNumbers() = produce<Int> {
    var x = 1
    while (true) {
        send(x++)
    }
}

fun CoroutineScope.square(numbers: ReceiveChannel<Int>) = produce<Int> {
    for (x in numbers) {
        send(x * x)
    }
}

fun main(){
    runBlocking {
        val numbers =  produceNumbers()
        val squres = square(numbers)

        for(i in 1..8){
            println(squres.receive())
        }
        println("Done!")
        coroutineContext.cancelChildren()
    }
}