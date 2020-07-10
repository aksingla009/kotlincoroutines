import kotlinx.coroutines.*

fun main(){
    println("Program Execution will now block")
    runBlocking {
        launch {
            delay(1000L)
            println("Task from RUN BLOCKING")
        }

        GlobalScope.launch {
            delay(2000L)
            println("Task form Global Scope")
        }

        coroutineScope {
            launch {
                delay(1500L)
                println("Task from custom COROUTINE SCOPE")
            }
        }
    }
    println("Program Execution will now continue")
    Thread.sleep(2000)

}