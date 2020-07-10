package channel

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main(){
    runBlocking {
        val producer = produceNumbers1()
        //Launching 5 coroutines
        repeat(5){
            launchProcessor(it,producer)
        }
        delay(500)
        producer.cancel()
    }
}
fun CoroutineScope.produceNumbers1() = produce<Int> {
    var x= 1
    while (true){
        send(x++)
        delay(100)
    }
}

fun CoroutineScope.launchProcessor(id : Int, channel : ReceiveChannel<Int>) = launch{
    for(msg in channel){
        println("Processor #$id received $msg")
    }
}