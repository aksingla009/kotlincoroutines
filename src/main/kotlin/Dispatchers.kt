import kotlinx.coroutines.*
import kotlin.concurrent.thread

fun main() {

    runBlocking {
//        launch(Dispatchers.Main) {
//            println("Main Dispatcher. Thread is ${Thread.currentThread().name} with id ${Thread.currentThread().id}")
//        }

        launch(Dispatchers.Default) {
            println("Default Dispatcher. Thread is ${Thread.currentThread().name} with id ${Thread.currentThread().id}")

            launch(Dispatchers.Unconfined) {
                println("Unconfined Dispatcher1 inside DEFAULT. Thread is ${Thread.currentThread().name} with id ${Thread.currentThread().id}")
                delay(100L)
                println("Unconfined Dispatcher2 inside DEFAULT. Thread is ${Thread.currentThread().name} with id ${Thread.currentThread().id}")
            }
        }

        launch(Dispatchers.Unconfined) {
            println("Unconfined Dispatcher11 inside flows.flows.flows.flows.errorhandling.main. Thread is ${Thread.currentThread().name} with id ${Thread.currentThread().id}")
            delay(200L)
            println("Unconfined Dispatcher12 inside flows.flows.flows.flows.errorhandling.main. Thread is ${Thread.currentThread().name} with id ${Thread.currentThread().id}")
        }


        launch(Dispatchers.IO) {
            println("IO Dispatcher. Thread is ${Thread.currentThread().name} with id ${Thread.currentThread().id}")
        }
        launch(newSingleThreadContext("AMAN THREAD")) {
            println("NEW SINGLE Thread is ${Thread.currentThread().name} with id ${Thread.currentThread().id}")

        }
    }

}
